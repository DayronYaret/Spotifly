package es.ulpgc.dayron.spotifly.users;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public class UsersPresenter implements UsersContract.Presenter {

  public static String TAG = UsersPresenter.class.getSimpleName();

  private WeakReference<UsersContract.View> view;
  private UsersViewModel viewModel;
  private UsersContract.Model model;
  private UsersContract.Router router;

  public UsersPresenter(UsersState state) {
    viewModel = state;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // use passed state if is necessary
    UsersState state = router.getDataFromPreviousScreen();
    if (state != null) {

      // update view and model state
      viewModel.data = state.data;

      // update the view
      view.get().displayUsers(viewModel);

      return;
    }

    // update the view
    view.get().displayUsers(viewModel);

  }

  @Override
  public void selectedUserListDAta(String user) {
    router.passDataToNextScreen(user);
    router.goUserSong();
  }

  @Override
  public void SignOut() {
    model.signOut(new RepositoryContract.SignOut() {
      @Override
      public void userSignOut(boolean isLogout) {
        if (isLogout == true) {
          goLogin();
        } else {
          //no se que poner aqui
        }
      }
    });
  }

  @Override
  public void goLogin() {
    router.goLogin();
    view.get().finishActivity();
  }

  @Override
  public void goSongs() {
    router.goSongs();
  }

  @Override
  public void goAddSongs() {
    router.goAddSongs();
  }

  @Override
  public void isLogin() {
    model.isLogin(new RepositoryContract.IsUserLogin() {
      @Override
      public void isUserLogin(boolean isLogin) {
        if (isLogin == true) {
          //cargar usuarios
          fillUsersArray();
        } else {
          router.goLogin();
        }
      }
    });
  }

  @Override
  public void fillUsersArray() {
    model.fillUsersArray(new RepositoryContract.FillUsersArray() {
      @Override
      public void onFillUsersArray(boolean error, ArrayList<String> usuarios) {
        if (error == false) {
          view.get().displaySuccess();
          viewModel.users = usuarios;
          Log.d("pres2", viewModel.users.toString());
          view.get().displayUsers(viewModel);
        } else {
          view.get().displayFailure();
          Log.d("pres", "fallo al coger el array");
        }
      }
    });
    //Log.d("pres", listaCanciones.toString());
  }

  @Override
  public void injectView(WeakReference<UsersContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(UsersContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(UsersContract.Router router) {
    this.router = router;
  }
}

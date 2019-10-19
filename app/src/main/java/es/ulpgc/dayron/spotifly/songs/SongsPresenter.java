package es.ulpgc.dayron.spotifly.songs;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public class SongsPresenter implements SongsContract.Presenter {

  public static String TAG = SongsPresenter.class.getSimpleName();

  private WeakReference<SongsContract.View> view;
  private SongsViewModel viewModel;
  private SongsContract.Model model;
  private SongsContract.Router router;

  public SongsPresenter(SongsState state) {
    viewModel = state;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // use passed state if is necessary
    SongsState state = router.getDataFromPreviousScreen();
    if (state != null) {

      // update view and model state
      viewModel.data = state.data;

      // update the view
      view.get().displayData(viewModel);

      return;
    }

    // call the model
    String data = model.fetchData();

    // set view state
    viewModel.data = data;

    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void goLogin() {
    router.goLogin();
  }

  @Override
  public void isLogin() {
    model.isLogin(new RepositoryContract.IsUserLogin() {
      @Override
      public void isUserLogin(boolean isLogin) {
        if(isLogin==true){
          //cargar canciones
        }else{
          router.goLogin();
        }
      }
    });
  }

  @Override
  public void SignOut() {
    model.signOut(new RepositoryContract.SignOut() {
      @Override
      public void userSignOut(boolean isLogout) {
        if(isLogout==true){
          goLogin();
        }else{
          //no se que poner aqui
        }
      }
    });
  }

  @Override
  public void injectView(WeakReference<SongsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(SongsContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(SongsContract.Router router) {
    this.router = router;
  }
}

package es.ulpgc.dayron.spotifly.userSong;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public class UserSongPresenter implements UserSongContract.Presenter {

  public static String TAG = UserSongPresenter.class.getSimpleName();

  private WeakReference<UserSongContract.View> view;
  private UserSongViewModel viewModel;
  private UserSongContract.Model model;
  private UserSongContract.Router router;
  private String usuario;

  public UserSongPresenter(UserSongState state) {
    viewModel = state;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // use passed state if is necessary
    usuario = router.getDataFromPreviousScreen();
    if (usuario != null) {

      // update view and model state
      Log.d("PresUS", usuario);
      viewModel.usuario = usuario;
      getUserSong();

      return;
    }

    //view.get().displayData(viewModel);

  }

  @Override
  public void goPlayer() {
    router.passDataToPlayer(viewModel.cancion);
    router.goSongs();
  }

  @Override
  public void injectView(WeakReference<UserSongContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(UserSongContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(UserSongContract.Router router) {
    this.router = router;
  }

  private void getUserSong(){
    model.getUserSong(usuario, new RepositoryContract.GetUserSong() {
      @Override
      public void onGetUserSong(boolean error, String cancion) {
        if(error==false){
          viewModel.cancion=cancion;
          if(view.get()!=null) {
            view.get().displayData(viewModel);
          }
        }else{
          view.get().displayFailure();
        }
      }
    });
  }
}

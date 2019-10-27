package es.ulpgc.dayron.spotifly.songs;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;
import es.ulpgc.dayron.spotifly.app.Song;

public class SongsPresenter implements SongsContract.Presenter {

  public static String TAG = SongsPresenter.class.getSimpleName();

  private WeakReference<SongsContract.View> view;
  private SongsViewModel viewModel;
  private SongsContract.Model model;
  private SongsContract.Router router;
  //private ArrayList<String> listaCanciones = new ArrayList<>();

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


    }

    // call the model
    fillSongsArray();

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
          fillSongsArray();
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
  public void goFriends() {
    router.goFriends();
  }

  @Override
  public void goAddFriends() {
    router.goAddFriends();
  }

  @Override
  public void goAddSongs() {
    router.goAddSongs();
  }

  @Override
  public void selectSongListData(String title) {
    router.passDataToNextScreen(title);
    router.goPlayer();
  }

  @Override
  public ArrayList<String> fillSongsArray() {
     return model.fillSongsArray(new RepositoryContract.FillSongsArray() {
      @Override
      public void onFillSongsArray(boolean error, ArrayList<String> canciones){
        if(error == false){
          view.get().displaySuccess();
          viewModel.canciones=canciones;
          view.get().displaySongs(viewModel);
        }else{
          view.get().displayFailure();
          Log.d("pres", "fallo al coger el array");
        }
      }
    });
    //Log.d("pres", listaCanciones.toString());
  }

  /**
  @Override
  public ArrayList<String> devolverArray() {
    return listaCanciones;
  }
**/
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

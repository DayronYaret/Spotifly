package es.ulpgc.dayron.spotifly.player;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public class PlayerPresenter implements PlayerContract.Presenter {

  public static String TAG = PlayerPresenter.class.getSimpleName();

  private WeakReference<PlayerContract.View> view;
  private PlayerViewModel viewModel;
  private PlayerContract.Model model;
  private PlayerContract.Router router;

  public PlayerPresenter(PlayerState state) {
    viewModel = state;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // use passed state if is necessary
    String titulo = router.getDataFromPreviousScreen();
    if (titulo != null) {

      // update view and model state
      viewModel.title = titulo;
      getInfoSong(viewModel.title);

      // update the view

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
  public void injectView(WeakReference<PlayerContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(PlayerContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(PlayerContract.Router router) {
    this.router = router;
  }

  private void getInfoSong(String titulo){
    model.getInfoSong(titulo, new RepositoryContract.GetInfoSong() {
      @Override
      public void onGetInfoSong(boolean error, String artist, String url) {
        if(error == false){

          viewModel.artist=artist;
          viewModel.url=url;
            view.get().displayData(viewModel);
          view.get().reproducirCancion(viewModel.url);
            Log.d("prespl", viewModel.artist);


        }else{
          viewModel.artist=artist;
          viewModel.url=url;
          view.get().displayFailure();
          view.get().displayData(viewModel);
        }
      }
    });
  }
}

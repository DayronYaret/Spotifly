package es.ulpgc.dayron.spotifly.player;

import android.util.Log;

import java.lang.ref.WeakReference;

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
    PlayerState state = router.getDataFromPreviousScreen();
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
}

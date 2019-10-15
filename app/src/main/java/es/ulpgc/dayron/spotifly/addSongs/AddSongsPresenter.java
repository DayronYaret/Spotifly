package es.ulpgc.dayron.spotifly.addSongs;

import android.util.Log;

import java.lang.ref.WeakReference;

public class AddSongsPresenter implements AddSongsContract.Presenter {

  public static String TAG = AddSongsPresenter.class.getSimpleName();

  private WeakReference<AddSongsContract.View> view;
  private AddSongsViewModel viewModel;
  private AddSongsContract.Model model;
  private AddSongsContract.Router router;

  public AddSongsPresenter(AddSongsState state) {
    viewModel = state;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // use passed state if is necessary
    AddSongsState state = router.getDataFromPreviousScreen();
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
  public void injectView(WeakReference<AddSongsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AddSongsContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AddSongsContract.Router router) {
    this.router = router;
  }
}
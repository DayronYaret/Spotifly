package es.ulpgc.dayron.spotifly.friends;

import android.util.Log;

import java.lang.ref.WeakReference;

public class FriendsPresenter implements FriendsContract.Presenter {

  public static String TAG = FriendsPresenter.class.getSimpleName();

  private WeakReference<FriendsContract.View> view;
  private FriendsViewModel viewModel;
  private FriendsContract.Model model;
  private FriendsContract.Router router;

  public FriendsPresenter(FriendsState state) {
    viewModel = state;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // use passed state if is necessary
    FriendsState state = router.getDataFromPreviousScreen();
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
  public void injectView(WeakReference<FriendsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(FriendsContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(FriendsContract.Router router) {
    this.router = router;
  }
}

package es.ulpgc.dayron.spotifly.addFriends;

import android.util.Log;

import java.lang.ref.WeakReference;

public class AddFriendsPresenter implements AddFriendsContract.Presenter {

  public static String TAG = AddFriendsPresenter.class.getSimpleName();

  private WeakReference<AddFriendsContract.View> view;
  private AddFriendsViewModel viewModel;
  private AddFriendsContract.Model model;
  private AddFriendsContract.Router router;

  public AddFriendsPresenter(AddFriendsState state) {
    viewModel = state;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // use passed state if is necessary
    AddFriendsState state = router.getDataFromPreviousScreen();
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
  public void injectView(WeakReference<AddFriendsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AddFriendsContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AddFriendsContract.Router router) {
    this.router = router;
  }
}

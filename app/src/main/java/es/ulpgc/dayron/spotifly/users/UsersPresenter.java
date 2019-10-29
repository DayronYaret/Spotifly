package es.ulpgc.dayron.spotifly.users;

import android.util.Log;

import java.lang.ref.WeakReference;

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

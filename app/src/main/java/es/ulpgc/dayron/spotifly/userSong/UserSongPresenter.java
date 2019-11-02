package es.ulpgc.dayron.spotifly.userSong;

import android.util.Log;

import java.lang.ref.WeakReference;

public class UserSongPresenter implements UserSongContract.Presenter {

  public static String TAG = UserSongPresenter.class.getSimpleName();

  private WeakReference<UserSongContract.View> view;
  private UserSongViewModel viewModel;
  private UserSongContract.Model model;
  private UserSongContract.Router router;

  public UserSongPresenter(UserSongState state) {
    viewModel = state;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // use passed state if is necessary
    UserSongState state = router.getDataFromPreviousScreen();
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
}

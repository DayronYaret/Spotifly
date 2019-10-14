package es.ulpgc.dayron.spotifly.friendSong;

import android.util.Log;

import java.lang.ref.WeakReference;

public class FriendSongPresenter implements FriendSongContract.Presenter {

  public static String TAG = FriendSongPresenter.class.getSimpleName();

  private WeakReference<FriendSongContract.View> view;
  private FriendSongViewModel viewModel;
  private FriendSongContract.Model model;
  private FriendSongContract.Router router;

  public FriendSongPresenter(FriendSongState state) {
    viewModel = state;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // use passed state if is necessary
    FriendSongState state = router.getDataFromPreviousScreen();
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
  public void injectView(WeakReference<FriendSongContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(FriendSongContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(FriendSongContract.Router router) {
    this.router = router;
  }
}

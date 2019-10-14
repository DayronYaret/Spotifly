package es.ulpgc.dayron.spotifly.friendSong;

import java.lang.ref.WeakReference;

public interface FriendSongContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(FriendSongViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(FriendSongState state);

    FriendSongState getDataFromPreviousScreen();
  }
}

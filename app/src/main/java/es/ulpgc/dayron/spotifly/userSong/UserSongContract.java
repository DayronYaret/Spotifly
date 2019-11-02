package es.ulpgc.dayron.spotifly.userSong;

import java.lang.ref.WeakReference;

public interface UserSongContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(UserSongViewModel viewModel);
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

    void passDataToNextScreen(UserSongState state);

    UserSongState getDataFromPreviousScreen();
  }
}

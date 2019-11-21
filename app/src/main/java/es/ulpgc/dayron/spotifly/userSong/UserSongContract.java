package es.ulpgc.dayron.spotifly.userSong;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public interface UserSongContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(UserSongViewModel viewModel);

    void displayFailure();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void goPlayer();
  }

  interface Model {
    String fetchData();
    void getUserSong(String usuario, RepositoryContract.GetUserSong callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(UserSongState state);

    String getDataFromPreviousScreen();

    void passDataToPlayer(String cancion);

    void goSongs();
  }
}

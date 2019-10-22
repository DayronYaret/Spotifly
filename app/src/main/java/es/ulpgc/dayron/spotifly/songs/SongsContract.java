package es.ulpgc.dayron.spotifly.songs;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public interface SongsContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(SongsViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void goLogin();

    void isLogin();

    void SignOut();

    void goFriends();

    void goAddFriends();

    void goAddSongs();
  }

  interface Model {
    String fetchData();
    void isLogin(RepositoryContract.IsUserLogin callback);
    void signOut(RepositoryContract.SignOut callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(SongsState state);

    SongsState getDataFromPreviousScreen();

    void goLogin();

    void goFriends();

    void goAddFriends();

    void goAddSongs();
  }
}

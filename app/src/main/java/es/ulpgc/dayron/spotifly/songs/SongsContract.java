package es.ulpgc.dayron.spotifly.songs;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;
import es.ulpgc.dayron.spotifly.app.Song;

public interface SongsContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(SongsViewModel viewModel);

    void displaySuccess();

    void displayFailure();

    void displaySongs(SongsViewModel viewModel);
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

    void selectSongListData(String title);

    ArrayList<String> fillSongsArray();

    //ArrayList<String> devolverArray();
  }

  interface Model {
    String fetchData();
    void isLogin(RepositoryContract.IsUserLogin callback);
    void signOut(RepositoryContract.SignOut callback);
    ArrayList<String> fillSongsArray(RepositoryContract.FillSongsArray callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(String state);

    SongsState getDataFromPreviousScreen();

    void goLogin();

    void goFriends();

    void goAddFriends();

    void goAddSongs();

    void goPlayer();
  }
}

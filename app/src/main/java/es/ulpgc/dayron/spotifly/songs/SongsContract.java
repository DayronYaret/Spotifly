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

    void finishActivity();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void goLogin();

    void isLogin();

    void SignOut();

    void goAddSongs();

    void selectSongListData(String title);

    void fillSongsArray();

      void goUsers();

      //ArrayList<String> devolverArray();
  }

  interface Model {
    String fetchData();
    void isLogin(RepositoryContract.IsUserLogin callback);
    void signOut(RepositoryContract.SignOut callback);
    void fillSongsArray(RepositoryContract.FillSongsArray callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(String state);

    SongsState getDataFromPreviousScreen();

    void goLogin();

    void goAddSongs();

    void goPlayer();

    void goUsers();
  }
}

package es.ulpgc.dayron.spotifly.addSongs;

import android.net.Uri;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public interface AddSongsContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AddSongsViewModel viewModel);

    void displayError();

    void displaySuccess();

    void terminar();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void SignOut();

    void goLogin();

    void goFriends();

    void goAddFriends();

    void goSongs();

    void uploadSong(String songTitle, String songArtist, Uri path);
  }

  interface Model {
    String fetchData();

    void uploadSong(String title, String artist, Uri path, RepositoryContract.UploadSong callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(AddSongsState state);

    AddSongsState getDataFromPreviousScreen();
  }
}

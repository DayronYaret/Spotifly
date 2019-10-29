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

    void goSongs();

    void uploadSong(String songTitle, String songArtist, Uri path);

      void goUsers();
  }

  interface Model {
    String fetchData();

    void uploadSong(String title, String artist, Uri path, RepositoryContract.UploadSong callback);

    void signOut(RepositoryContract.SignOut signOut);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(AddSongsState state);

    AddSongsState getDataFromPreviousScreen();

    void goSongs();

    void goLogin();

    void goUsers();
  }
}

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

    /**
     * Metodo para cerrar sesion
     */
    void SignOut();

    void goLogin();

    void goSongs();

    /**
     * Metodo que coge el contenido de los campos de texto y la uri del archivo y lo guarda en firebase
     * @param songTitle titulo de la cancion
     * @param songArtist artista de la cancion
     * @param path uri del archivo
     */
    void uploadSong(String songTitle, String songArtist, Uri path);

      void goUsers();
  }

  interface Model {
    String fetchData();

    /**
     * Metodo que coge el contenido de los campos de texto y la uri del archivo y lo guarda en firebase
     * @param title titulo de la cancion
     * @param artist artista de la cancion
     * @param path uri del archivo
     * @param callback callback que se llama una vez se termina de subir la cancion a la base de datos
     */
    void uploadSong(String title, String artist, Uri path, RepositoryContract.UploadSong callback);

    /**
     * Metodo para cerrar sesion en la aplicacion
     * @param callback callback que se llama cuando se termina de cerrar la sesion
     */
    void signOut(RepositoryContract.SignOut callback);
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

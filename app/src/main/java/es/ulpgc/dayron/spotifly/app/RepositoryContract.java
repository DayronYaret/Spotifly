package es.ulpgc.dayron.spotifly.app;

import android.net.Uri;

import java.util.ArrayList;

public interface RepositoryContract {

  interface LoginUser{
    void onUserLogIn(boolean error); //devuelve datos a presenter
  }

  /**
   * Metodo usado para iniciar sesion en la aplicación, comprueba los datos recogidos con los que tiene Firebase, en caso negativo, no puede acceder
   * @param email email del usuario
   * @param pass contraseña del usuario
   * @param callback callback que se llama una vez se han comprobado los datos
   */
  void loginUser(String email, String pass, RepositoryContract.LoginUser callback); //metodo que llama el presenter

  interface RegisterUser{
    void onUserRegister(boolean error);
  }

  /**
   * Metodo para registrar un usuario en la aplicacion, recoge el nombre del usuario, su email y una contraseña que serán registrados en Firebase
   * @param user nombre del usuario
   * @param email email del usuario, necesario para autenticar
   * @param pass contraseña asociada al usuario, necesaria para autenticar
   * @param callback callback que se llama una vez se ha termiando el proceso de registro
   */
  void registerUser(String user, String email, String pass, RepositoryContract.RegisterUser callback);

  interface IsUserLogin{
    void isUserLogin(boolean isLogin);
  }

  /**
   * Metodo para comprobar si ya ha iniciado sesion en la aplicacion, para acceder directamente a la pantalla de las canciones
   * @param callback callback al que se llama una vez se termina la comprobacion
   */
  void checkLogin(RepositoryContract.IsUserLogin callback);

  interface SignOut{
    void userSignOut(boolean isLogout);
  }

  /**
   * Metodo para salir y cerrar la sesion de la aplicacion, se encarga de hacer saber a Firebase de que ha cerrado sesion
   * @param callback callback al que se llama una vez se termina el cerrar sesion
   */
  void signOut(RepositoryContract.SignOut callback);

  interface ForgotPassword{
    void onForgotPassword(boolean error);
  }

  /**
   * Metodo para restablecer la contraseña de un usuario, una vez se pone el email, Firebase manda un correo a la direccion para que ponga una nueva clave
   * @param email email del usuario que va a cambiar de contraseña
   * @param callback callback al que se llama una vez se envia el correo
   */
  void forgotPassword(String email, RepositoryContract.ForgotPassword callback);

  interface UploadSong{
    void onUploadSong(boolean error);
  }

  /**
   * Metodo que introduce una nueva cancion a la base de datos, mete el archivo elegido en Storage y se guarda la referencia en RealTime Database
   * @param title titulo de la cancion
   * @param artist artista de la cancion
   * @param path Uri del archivo elegido para poder recogerlo y enviarlo a Firebase
   * @param callback callback al que se llama una vez se sube la cancion
   */
  void uploadSong(String title, String artist, Uri path, RepositoryContract.UploadSong callback);

  interface FillSongsArray{
    void onFillSongsArray(boolean error, ArrayList<String> listaCanciones);
  }

  /**
   * Metodo que rellena el array de canciones necesarias para mostrar todos los archivos que hay en Firebase
   * @param callback callback al que se llama una vez se termina de rellenar el array
   */
  void fillSongsArray(RepositoryContract.FillSongsArray callback);

  interface FillUsersArray{
    void onFillUsersArray(boolean error, ArrayList<String>listausuarios);
  }

  /**
   * Metodo que rellena el array de usuarios registrados en la aplicacion, recoge los datos de RealTimeDatabase
   * @param callback callback al que se llama una vez se termina de rellenar el array
   */
  void fillUsersArray(RepositoryContract.FillUsersArray callback);

  interface GetInfoSong{
    void onGetInfoSong(boolean error, String artist, String url);
  }

  /**
   * Metodo que recoge los datos basicos de la cancion, como su artista y url para su reproduccion
   * @param titulo titulo de la cancion
   * @param callback callback al que se llama una vez se termina de recoger los datos
   */
  void getInfoSong(String titulo, RepositoryContract.GetInfoSong callback);

  interface GetUserSong{
    void onGetUserSong(boolean error, String cancion);
  }

  /**
   * Metodo que recoge que cancion ha escuchado por ultima vez el usuario elegido
   * @param usuario usuario que se ha elegido
   * @param callback callback al que se llama una vez se termina de recoger la cancion
   */
  void getUserSong(String usuario, RepositoryContract.GetUserSong callback);
}




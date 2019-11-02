package es.ulpgc.dayron.spotifly.app;

import android.net.Uri;

import java.util.ArrayList;

public interface RepositoryContract {
  interface LoginUser{
    void onUserLogIn(boolean error); //devuelve datos a presenter
  }
  void loginUser(String email, String pass, RepositoryContract.LoginUser callback); //metodo que llama el presenter


  interface RegisterUser{
    void onUserRegister(boolean error);
  }
  void registerUser(String user, String email, String pass, RepositoryContract.RegisterUser callback);

  interface IsUserLogin{
    void isUserLogin(boolean isLogin);
  }
  void checkLogin(RepositoryContract.IsUserLogin callback);

  interface SignOut{
    void userSignOut(boolean isLogout);
  }
  void signOut(RepositoryContract.SignOut callback);

  interface ForgotPassword{
    void onForgotPassword(boolean error);
  }
  void forgotPassword(String email, RepositoryContract.ForgotPassword callback);

  interface UploadSong{
    void onUploadSong(boolean error);
  }

  void uploadSong(String title, String artist, Uri path, RepositoryContract.UploadSong callback);

  interface FillSongsArray{
    void onFillSongsArray(boolean error, ArrayList<String> listaCanciones);
  }
ArrayList<String> fillSongsArray(RepositoryContract.FillSongsArray callback);

  interface FillUsersArray{
    void onFillUsersArray(boolean error, ArrayList<String>listausuarios);
  }
  void fillUsersArray(RepositoryContract.FillUsersArray callback);


}




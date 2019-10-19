package es.ulpgc.dayron.spotifly.app;

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
}

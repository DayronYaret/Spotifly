package es.ulpgc.dayron.spotifly.login;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public interface LoginContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(LoginViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void signIn(String user, String pass);

    void goForgot();

    void goRegister();

    void onSuccess();

    void OnError();


  }

  interface Model {
    String fetchData();

    void signIn(String user, String pass, RepositoryContract.LoginUser callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(LoginState state);

    LoginState getDataFromPreviousScreen();

    void goRegister();

    void goForgot();

    void goSongs();
  }
}

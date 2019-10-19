package es.ulpgc.dayron.spotifly.login;

import java.lang.ref.WeakReference;

public interface LoginContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(LoginViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void signIn(String user, String pass);

    void goForgot();

    void goRegister();
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(LoginState state);

    LoginState getDataFromPreviousScreen();

    void goRegister();

    void goForgot();
  }
}

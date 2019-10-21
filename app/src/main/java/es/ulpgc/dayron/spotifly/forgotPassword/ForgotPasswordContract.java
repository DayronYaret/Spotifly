package es.ulpgc.dayron.spotifly.forgotPassword;

import android.widget.EditText;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public interface ForgotPasswordContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(ForgotPasswordViewModel viewModel);

    void displaySuccess();

    void displayError();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void forgotPassword(String email);

  }

  interface Model {
    String fetchData();
    void forgotPassword(String email, RepositoryContract.ForgotPassword callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(ForgotPasswordState state);

    ForgotPasswordState getDataFromPreviousScreen();

    void goLogin();
  }
}

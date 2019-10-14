package es.ulpgc.dayron.spotifly.forgotPassword;

import java.lang.ref.WeakReference;

public interface ForgotPasswordContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(ForgotPasswordViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(ForgotPasswordState state);

    ForgotPasswordState getDataFromPreviousScreen();
  }
}

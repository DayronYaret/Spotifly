package es.ulpgc.dayron.spotifly.register;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public interface RegisterContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(RegisterViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void register(String user, String userEmail, String userPass);
  }

  interface Model {
    String fetchData();
    void register(String user, String email, String pass, RepositoryContract.RegisterUser callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(RegisterState state);

    RegisterState getDataFromPreviousScreen();
  }
}

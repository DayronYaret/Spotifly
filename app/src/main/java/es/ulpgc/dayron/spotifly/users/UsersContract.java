package es.ulpgc.dayron.spotifly.users;

import java.lang.ref.WeakReference;

public interface UsersContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(UsersViewModel viewModel);
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

    void passDataToNextScreen(UsersState state);

    UsersState getDataFromPreviousScreen();
  }
}

package es.ulpgc.dayron.spotifly.friends;

import java.lang.ref.WeakReference;

public interface FriendsContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(FriendsViewModel viewModel);
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

    void passDataToNextScreen(FriendsState state);

    FriendsState getDataFromPreviousScreen();
  }
}

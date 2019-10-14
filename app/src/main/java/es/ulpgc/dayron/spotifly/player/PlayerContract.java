package es.ulpgc.dayron.spotifly.player;

import java.lang.ref.WeakReference;

public interface PlayerContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(PlayerViewModel viewModel);
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

    void passDataToNextScreen(PlayerState state);

    PlayerState getDataFromPreviousScreen();
  }
}

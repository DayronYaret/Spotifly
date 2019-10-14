package es.ulpgc.dayron.spotifly.songs;

import java.lang.ref.WeakReference;

public interface SongsContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(SongsViewModel viewModel);
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

    void passDataToNextScreen(SongsState state);

    SongsState getDataFromPreviousScreen();
  }
}

package es.ulpgc.dayron.spotifly.player;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public interface PlayerContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(PlayerViewModel viewModel);

    void displayFailure();

    void reproducirCancion(String url);

  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();
  }

  interface Model {
    String fetchData();
    void getInfoSong(String titulo, RepositoryContract.GetInfoSong callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(PlayerState state);

    String getDataFromPreviousScreen();
  }
}

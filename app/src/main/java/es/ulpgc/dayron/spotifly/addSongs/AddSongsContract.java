package es.ulpgc.dayron.spotifly.addSongs;

import java.lang.ref.WeakReference;

public interface AddSongsContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AddSongsViewModel viewModel);
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

    void passDataToNextScreen(AddSongsState state);

    AddSongsState getDataFromPreviousScreen();
  }
}

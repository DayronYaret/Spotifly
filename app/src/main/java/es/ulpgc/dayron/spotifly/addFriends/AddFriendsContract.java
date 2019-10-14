package es.ulpgc.dayron.spotifly.addFriends;

import java.lang.ref.WeakReference;

public interface AddFriendsContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AddFriendsViewModel viewModel);
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

    void passDataToNextScreen(AddFriendsState state);

    AddFriendsState getDataFromPreviousScreen();
  }
}

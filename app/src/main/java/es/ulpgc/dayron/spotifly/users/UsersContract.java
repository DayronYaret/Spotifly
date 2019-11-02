package es.ulpgc.dayron.spotifly.users;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public interface UsersContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(UsersViewModel viewModel);

    void displayUsers(UsersViewModel viewModel);

    void finishActivity();

    void displayFailure();

    void displaySuccess();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void selectedUserListDAta(String item);

    void SignOut();

    void goLogin();

    void goSongs();

    void goAddSongs();

    void isLogin();

    void fillUsersArray();
  }

  interface Model {
    String fetchData();
    void isLogin(RepositoryContract.IsUserLogin callback);
    void signOut(RepositoryContract.SignOut callback);
    void fillUsersArray(RepositoryContract.FillUsersArray callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(String user);

    UsersState getDataFromPreviousScreen();

    void goLogin();

    void goSongs();

    void goAddSongs();

    void goUserSong();
  }
}

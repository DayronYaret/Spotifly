package es.ulpgc.dayron.spotifly.login;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public class LoginPresenter implements LoginContract.Presenter {

  public static String TAG = LoginPresenter.class.getSimpleName();

  private WeakReference<LoginContract.View> view;
  private LoginViewModel viewModel;
  private LoginContract.Model model;
  private LoginContract.Router router;

  public LoginPresenter(LoginState state) {
    viewModel = state;
  }


  @Override
  public void signIn(String email, String pass) {
    model.signIn(email, pass, new RepositoryContract.LoginUser() {
      @Override
      public void onUserLogIn(boolean error) {
        Log.d("Login Presenter", "error"+error);
        if(error==false){
          router.goSongs();
        }else{
          viewModel.message="Password or username does not exist";
          view.get().displayData(viewModel);
        }
      }
    });
  }

  @Override
  public void onSuccess() {
    router.goSongs();
  }

  @Override
  public void OnError() {
    viewModel.message="Password or username does not exist";
    view.get().displayData(viewModel);
  }

  @Override
  public void goForgot() {
    router.goForgot();
  }

  @Override
  public void goRegister() {
    router.goRegister();
  }

  @Override
  public void injectView(WeakReference<LoginContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(LoginContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(LoginContract.Router router) {
    this.router = router;
  }
}

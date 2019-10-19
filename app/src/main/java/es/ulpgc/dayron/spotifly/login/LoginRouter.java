package es.ulpgc.dayron.spotifly.login;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.dayron.spotifly.app.AppMediator;
import es.ulpgc.dayron.spotifly.forgotPassword.ForgotPasswordActivity;
import es.ulpgc.dayron.spotifly.register.RegisterActivity;

public class LoginRouter implements LoginContract.Router {

  public static String TAG = LoginRouter.class.getSimpleName();

  private AppMediator mediator;

  public LoginRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, LoginActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(LoginState state) {
    mediator.setLoginState(state);
  }

  @Override
  public LoginState getDataFromPreviousScreen() {
    LoginState state = mediator.getLoginState();
    return state;
  }

  @Override
  public void goRegister() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, RegisterActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void goForgot() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ForgotPasswordActivity.class);
    context.startActivity(intent);
  }
}

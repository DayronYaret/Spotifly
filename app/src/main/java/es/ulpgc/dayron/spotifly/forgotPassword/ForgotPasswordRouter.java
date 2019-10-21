package es.ulpgc.dayron.spotifly.forgotPassword;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.dayron.spotifly.app.AppMediator;
import es.ulpgc.dayron.spotifly.login.LoginActivity;

public class ForgotPasswordRouter implements ForgotPasswordContract.Router {

  public static String TAG = ForgotPasswordRouter.class.getSimpleName();

  private AppMediator mediator;

  public ForgotPasswordRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ForgotPasswordActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(ForgotPasswordState state) {
    mediator.setForgotPasswordState(state);
  }

  @Override
  public ForgotPasswordState getDataFromPreviousScreen() {
    ForgotPasswordState state = mediator.getForgotPasswordState();
    return state;
  }

  @Override
  public void goLogin() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, LoginActivity.class);
    context.startActivity(intent);
  }
}

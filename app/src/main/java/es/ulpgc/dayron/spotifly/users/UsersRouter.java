package es.ulpgc.dayron.spotifly.users;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.dayron.spotifly.app.AppMediator;

public class UsersRouter implements UsersContract.Router {

  public static String TAG = UsersRouter.class.getSimpleName();

  private AppMediator mediator;

  public UsersRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UsersActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(UsersState state) {
    mediator.setUsersState(state);
  }

  @Override
  public UsersState getDataFromPreviousScreen() {
    UsersState state = mediator.getUsersState();
    return state;
  }
}

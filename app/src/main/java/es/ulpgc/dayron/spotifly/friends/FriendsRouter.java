package es.ulpgc.dayron.spotifly.friends;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class FriendsRouter implements FriendsContract.Router {

  public static String TAG = FriendsRouter.class.getSimpleName();

  private AppMediator mediator;

  public FriendsRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, FriendsActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(FriendsState state) {
    mediator.setFriendsState(state);
  }

  @Override
  public FriendsState getDataFromPreviousScreen() {
    FriendsState state = mediator.getFriendsState();
    return state;
  }
}

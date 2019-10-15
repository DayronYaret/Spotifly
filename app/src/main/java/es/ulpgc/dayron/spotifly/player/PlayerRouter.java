package es.ulpgc.dayron.spotifly.player;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.dayron.spotifly.app.AppMediator;

public class PlayerRouter implements PlayerContract.Router {

  public static String TAG = PlayerRouter.class.getSimpleName();

  private AppMediator mediator;

  public PlayerRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, PlayerActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(PlayerState state) {
    mediator.setPlayerState(state);
  }

  @Override
  public PlayerState getDataFromPreviousScreen() {
    PlayerState state = mediator.getPlayerState();
    return state;
  }
}

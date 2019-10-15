package es.ulpgc.dayron.spotifly.songs;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.dayron.spotifly.app.AppMediator;

public class SongsRouter implements SongsContract.Router {

  public static String TAG = SongsRouter.class.getSimpleName();

  private AppMediator mediator;

  public SongsRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, SongsActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(SongsState state) {
    mediator.setSongsState(state);
  }

  @Override
  public SongsState getDataFromPreviousScreen() {
    SongsState state = mediator.getSongsState();
    return state;
  }
}

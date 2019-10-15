package es.ulpgc.dayron.spotifly.addSongs;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.dayron.spotifly.app.AppMediator;

public class AddSongsRouter implements AddSongsContract.Router {

  public static String TAG = AddSongsRouter.class.getSimpleName();

  private AppMediator mediator;

  public AddSongsRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AddSongsActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(AddSongsState state) {
    mediator.setAddSongsState(state);
  }

  @Override
  public AddSongsState getDataFromPreviousScreen() {
    AddSongsState state = mediator.getAddSongsState();
    return state;
  }
}

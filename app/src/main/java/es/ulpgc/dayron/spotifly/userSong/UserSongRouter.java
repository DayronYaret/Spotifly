package es.ulpgc.dayron.spotifly.userSong;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.dayron.spotifly.app.AppMediator;

public class UserSongRouter implements UserSongContract.Router {

  public static String TAG = UserSongRouter.class.getSimpleName();

  private AppMediator mediator;

  public UserSongRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UserSongActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(UserSongState state) {
    mediator.setUserSongState(state);
  }

  @Override
  public UserSongState getDataFromPreviousScreen() {
    UserSongState state = mediator.getUserSongState();
    return state;
  }
}

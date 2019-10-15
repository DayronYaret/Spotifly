package es.ulpgc.dayron.spotifly.friendSong;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.dayron.spotifly.app.AppMediator;

public class FriendSongRouter implements FriendSongContract.Router {

  public static String TAG = FriendSongRouter.class.getSimpleName();

  private AppMediator mediator;

  public FriendSongRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, FriendSongActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(FriendSongState state) {
    mediator.setFriendSongState(state);
  }

  @Override
  public FriendSongState getDataFromPreviousScreen() {
    FriendSongState state = mediator.getFriendSongState();
    return state;
  }
}

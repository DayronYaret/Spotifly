package es.ulpgc.dayron.spotifly.userSong;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.dayron.spotifly.app.AppMediator;
import es.ulpgc.dayron.spotifly.player.PlayerActivity;

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
  public String getDataFromPreviousScreen() {
    String usuario = mediator.getUser();
    return usuario;
  }

  @Override
  public void passDataToPlayer(String cancion) {
    mediator.setSongsTitle(cancion);
  }

  @Override
  public void goSongs() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, PlayerActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}

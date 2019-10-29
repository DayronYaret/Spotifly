package es.ulpgc.dayron.spotifly.songs;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.dayron.spotifly.addSongs.AddSongsActivity;
import es.ulpgc.dayron.spotifly.app.AppMediator;
import es.ulpgc.dayron.spotifly.login.LoginActivity;
import es.ulpgc.dayron.spotifly.player.PlayerActivity;
import es.ulpgc.dayron.spotifly.users.UsersActivity;

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
  public void passDataToNextScreen(String title) {
    mediator.setSongsTitle(title);
  }

  @Override
  public SongsState getDataFromPreviousScreen() {
    SongsState state = mediator.getSongsState();
    return state;
  }

  @Override
  public void goLogin() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, LoginActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }


  @Override
  public void goAddSongs() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AddSongsActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void goPlayer() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, PlayerActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void goUsers() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UsersActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}

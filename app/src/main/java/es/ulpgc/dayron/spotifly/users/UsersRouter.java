package es.ulpgc.dayron.spotifly.users;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.dayron.spotifly.addSongs.AddSongsActivity;
import es.ulpgc.dayron.spotifly.app.AppMediator;
import es.ulpgc.dayron.spotifly.login.LoginActivity;
import es.ulpgc.dayron.spotifly.songs.SongsActivity;
import es.ulpgc.dayron.spotifly.userSong.UserSongActivity;

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
  public void passDataToNextScreen(String user) {
    mediator.setUser(user);
  }

  @Override
  public UsersState getDataFromPreviousScreen() {
    UsersState state = mediator.getUsersState();
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
  public void goSongs() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, SongsActivity.class);
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
  public void goUserSong() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UserSongActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}

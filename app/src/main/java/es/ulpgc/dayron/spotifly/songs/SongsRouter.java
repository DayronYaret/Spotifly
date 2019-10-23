package es.ulpgc.dayron.spotifly.songs;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.dayron.spotifly.addFriends.AddFriendsActivity;
import es.ulpgc.dayron.spotifly.addSongs.AddSongsActivity;
import es.ulpgc.dayron.spotifly.app.AppMediator;
import es.ulpgc.dayron.spotifly.friends.FriendsActivity;
import es.ulpgc.dayron.spotifly.login.LoginActivity;

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

  @Override
  public void goLogin() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, LoginActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void goFriends() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, FriendsActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void goAddFriends() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AddFriendsActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void goAddSongs() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AddSongsActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}

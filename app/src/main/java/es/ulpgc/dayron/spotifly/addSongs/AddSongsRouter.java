package es.ulpgc.dayron.spotifly.addSongs;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.dayron.spotifly.addFriends.AddFriendsActivity;
import es.ulpgc.dayron.spotifly.app.AppMediator;
import es.ulpgc.dayron.spotifly.friends.FriendsActivity;
import es.ulpgc.dayron.spotifly.login.LoginActivity;
import es.ulpgc.dayron.spotifly.songs.SongsActivity;

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
  public void goSongs() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, SongsActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void goLogin() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, LoginActivity.class);
    context.startActivity(intent);
  }
}

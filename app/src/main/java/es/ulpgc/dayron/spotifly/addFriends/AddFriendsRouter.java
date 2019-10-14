package es.ulpgc.dayron.spotifly.addFriends;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class AddFriendsRouter implements AddFriendsContract.Router {

  public static String TAG = AddFriendsRouter.class.getSimpleName();

  private AppMediator mediator;

  public AddFriendsRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AddFriendsActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(AddFriendsState state) {
    mediator.setAddFriendsState(state);
  }

  @Override
  public AddFriendsState getDataFromPreviousScreen() {
    AddFriendsState state = mediator.getAddFriendsState();
    return state;
  }
}

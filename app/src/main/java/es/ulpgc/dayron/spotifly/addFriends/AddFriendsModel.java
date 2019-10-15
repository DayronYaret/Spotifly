package es.ulpgc.dayron.spotifly.addFriends;

import android.util.Log;

import java.lang.ref.WeakReference;


public class AddFriendsModel implements AddFriendsContract.Model {

  public static String TAG = AddFriendsModel.class.getSimpleName();

  public AddFriendsModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}

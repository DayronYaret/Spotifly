package es.ulpgc.dayron.spotifly.friends;

import android.util.Log;

import java.lang.ref.WeakReference;


public class FriendsModel implements FriendsContract.Model {

  public static String TAG = FriendsModel.class.getSimpleName();

  public FriendsModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}

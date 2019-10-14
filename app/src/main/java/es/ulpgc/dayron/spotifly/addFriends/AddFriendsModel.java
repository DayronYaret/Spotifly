package es.ulpgc.dayron.spotifly.addFriends;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

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

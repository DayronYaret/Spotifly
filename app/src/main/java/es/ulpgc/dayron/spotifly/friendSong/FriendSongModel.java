package es.ulpgc.dayron.spotifly.friendSong;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class FriendSongModel implements FriendSongContract.Model {

  public static String TAG = FriendSongModel.class.getSimpleName();

  public FriendSongModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}

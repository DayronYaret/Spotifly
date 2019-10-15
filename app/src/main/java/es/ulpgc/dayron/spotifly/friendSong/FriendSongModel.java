package es.ulpgc.dayron.spotifly.friendSong;

import android.util.Log;

import java.lang.ref.WeakReference;


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

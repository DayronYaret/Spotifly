package es.ulpgc.dayron.spotifly.userSong;

import android.util.Log;

import java.lang.ref.WeakReference;



public class UserSongModel implements UserSongContract.Model {

  public static String TAG = UserSongModel.class.getSimpleName();

  public UserSongModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}

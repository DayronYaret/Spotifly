package es.ulpgc.dayron.spotifly.songs;

import android.util.Log;

import java.lang.ref.WeakReference;


public class SongsModel implements SongsContract.Model {

  public static String TAG = SongsModel.class.getSimpleName();

  public SongsModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}

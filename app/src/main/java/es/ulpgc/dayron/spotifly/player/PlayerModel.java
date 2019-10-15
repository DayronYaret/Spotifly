package es.ulpgc.dayron.spotifly.player;

import android.util.Log;

import java.lang.ref.WeakReference;


public class PlayerModel implements PlayerContract.Model {

  public static String TAG = PlayerModel.class.getSimpleName();

  public PlayerModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}

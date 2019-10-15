package es.ulpgc.dayron.spotifly.addSongs;

import android.util.Log;

import java.lang.ref.WeakReference;


public class AddSongsModel implements AddSongsContract.Model {

  public static String TAG = AddSongsModel.class.getSimpleName();

  public AddSongsModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}

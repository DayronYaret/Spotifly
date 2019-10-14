package es.ulpgc.dayron.spotifly.addSongs;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

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

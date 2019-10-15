package es.ulpgc.dayron.spotifly.register;

import android.util.Log;
import java.lang.ref.WeakReference;


public class RegisterModel implements RegisterContract.Model {

  public static String TAG = RegisterModel.class.getSimpleName();

  public RegisterModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}

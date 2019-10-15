package es.ulpgc.dayron.spotifly.forgotPassword;

import android.util.Log;
import java.lang.ref.WeakReference;

public class ForgotPasswordModel implements ForgotPasswordContract.Model {

  public static String TAG = ForgotPasswordModel.class.getSimpleName();

  public ForgotPasswordModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}

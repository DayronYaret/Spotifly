package es.ulpgc.dayron.spotifly.forgotPassword;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

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

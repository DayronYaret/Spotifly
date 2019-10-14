package es.ulpgc.dayron.spotifly.login;

import android.util.Log;

import java.lang.ref.WeakReference;


public class LoginModel implements LoginContract.Model {

  public static String TAG = LoginModel.class.getSimpleName();

  public LoginModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}

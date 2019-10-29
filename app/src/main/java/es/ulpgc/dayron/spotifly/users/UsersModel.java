package es.ulpgc.dayron.spotifly.users;

import android.util.Log;

import java.lang.ref.WeakReference;


public class UsersModel implements UsersContract.Model {

  public static String TAG = UsersModel.class.getSimpleName();

  public UsersModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}

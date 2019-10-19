package es.ulpgc.dayron.spotifly.register;

import android.util.Log;
import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;


public class RegisterModel implements RegisterContract.Model {

  public static String TAG = RegisterModel.class.getSimpleName();
  private RepositoryContract repository;

  public RegisterModel(RepositoryContract repository) {
    this.repository=repository;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public void register(String user, String email, String pass, RepositoryContract.RegisterUser callback) {
    repository.registerUser(user, email, pass, callback);
  }
}

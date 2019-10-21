package es.ulpgc.dayron.spotifly.forgotPassword;

import android.util.Log;
import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public class ForgotPasswordModel implements ForgotPasswordContract.Model {

  public static String TAG = ForgotPasswordModel.class.getSimpleName();
  private RepositoryContract repository;

  public ForgotPasswordModel(RepositoryContract repository) {
    this.repository=repository;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public void forgotPassword(String email, RepositoryContract.ForgotPassword callback) {
    repository.forgotPassword(email, callback);
  }
}

package es.ulpgc.dayron.spotifly.songs;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;


public class SongsModel implements SongsContract.Model {

  public static String TAG = SongsModel.class.getSimpleName();
  private RepositoryContract repository;
  public SongsModel(RepositoryContract repository) {
    this.repository=repository;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public void isLogin(RepositoryContract.IsUserLogin callback) {
    repository.checkLogin(callback);
  }

  @Override
  public void signOut(RepositoryContract.SignOut callback) {
    repository.signOut(callback);
  }
}

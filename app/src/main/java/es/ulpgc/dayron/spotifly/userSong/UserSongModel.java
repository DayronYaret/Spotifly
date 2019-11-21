package es.ulpgc.dayron.spotifly.userSong;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;


public class UserSongModel implements UserSongContract.Model {

  public static String TAG = UserSongModel.class.getSimpleName();
  private RepositoryContract repository;

  public UserSongModel(RepositoryContract repository) {
    this.repository=repository;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public void getUserSong(String usuario, RepositoryContract.GetUserSong callback) {
    repository.getUserSong(usuario, callback);
  }
}

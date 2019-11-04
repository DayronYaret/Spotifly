package es.ulpgc.dayron.spotifly.player;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;


public class PlayerModel implements PlayerContract.Model {

  public static String TAG = PlayerModel.class.getSimpleName();
  private RepositoryContract repository;
  public PlayerModel(RepositoryContract repository) {
  this.repository=repository;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public void getInfoSong(String titulo, RepositoryContract.GetInfoSong callback) {
    repository.getInfoSong(titulo, callback);
  }
}

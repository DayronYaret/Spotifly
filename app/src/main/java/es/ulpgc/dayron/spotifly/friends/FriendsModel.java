package es.ulpgc.dayron.spotifly.friends;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;


public class FriendsModel implements FriendsContract.Model {

  public static String TAG = FriendsModel.class.getSimpleName();
  private RepositoryContract repository;

  public FriendsModel(RepositoryContract repository) {
    this.repository=repository;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}

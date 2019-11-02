package es.ulpgc.dayron.spotifly.users;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;


public class UsersModel implements UsersContract.Model {

  public static String TAG = UsersModel.class.getSimpleName();
  private RepositoryContract repository;

  public UsersModel(RepositoryContract repository) {
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

  @Override
  public void fillUsersArray(RepositoryContract.FillUsersArray callback) {
    repository.fillUsersArray(callback);
  }
}

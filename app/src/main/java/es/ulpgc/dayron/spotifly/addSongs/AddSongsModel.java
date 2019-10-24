package es.ulpgc.dayron.spotifly.addSongs;

import android.net.Uri;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;


public class AddSongsModel implements AddSongsContract.Model {

  public static String TAG = AddSongsModel.class.getSimpleName();
  private RepositoryContract repository;

  public AddSongsModel(RepositoryContract repository) {
    this.repository=repository;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public void uploadSong(String title, String artist, Uri path, RepositoryContract.UploadSong callback) {
    repository.uploadSong(title, artist, path, callback);
  }
}

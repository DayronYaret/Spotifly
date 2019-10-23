package es.ulpgc.dayron.spotifly.addSongs;

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
}

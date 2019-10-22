package es.ulpgc.dayron.spotifly.songs;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.dayron.spotifly.R;

public class SongsActivity
    extends AppCompatActivity implements SongsContract.View {

  public static String TAG = SongsActivity.class.getSimpleName();

  private SongsContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_songs);

    // do the setup
    SongsScreen.configure(this);

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    int id = item.getItemId();
    switch (id) {
      case R.id.logOutOption:
        presenter.SignOut();
        presenter.goLogin();
        break;

      case R.id.friendsOption:
        presenter.goFriends();
        break;

      case R.id.addFriendsOption:
        presenter.goAddFriends();
        break;

      case R.id.songsOption:
        break;

      case R.id.addSongsOption:
        presenter.goAddSongs();
        break;
        default:
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.isLogin();
    presenter.fetchData();

  }

  @Override
  public void displayData(SongsViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
  }

  @Override
  public void injectPresenter(SongsContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

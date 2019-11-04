package es.ulpgc.dayron.spotifly.player;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.dayron.spotifly.R;

public class PlayerActivity
    extends AppCompatActivity implements PlayerContract.View {

  public static String TAG = PlayerActivity.class.getSimpleName();

  private PlayerContract.Presenter presenter;
  private TextView title, artist;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_player);
    title = findViewById(R.id.textViewSongName);
    artist = findViewById(R.id.textViewArtist);

    // do the setup
    PlayerScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchData();
  }

  @Override
  public void displayData(final PlayerViewModel viewModel) {
    //Log.e(TAG, "displayData()");
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        Log.d("player", viewModel.artist);
        title.setText(viewModel.title);
        artist.setText(viewModel.artist);
      }
    });

    // deal with the data
  }

  @Override
  public void displaySuccess() {

  }

  @Override
  public void displayFailure() {

  }

  @Override
  public void onBackPressed() {
    finish();
  }

  @Override
  public void injectPresenter(PlayerContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

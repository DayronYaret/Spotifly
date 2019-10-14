package es.ulpgc.dayron.spotifly.friendSong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.dayron.spotifly.R;

public class FriendSongActivity
    extends AppCompatActivity implements FriendSongContract.View {

  public static String TAG = FriendSongActivity.class.getSimpleName();

  private FriendSongContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_friend_song);

    // do the setup
    FriendSongScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchData();
  }

  @Override
  public void displayData(FriendSongViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.data)).setText(viewModel.data);
  }

  @Override
  public void injectPresenter(FriendSongContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

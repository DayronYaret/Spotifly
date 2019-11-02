package es.ulpgc.dayron.spotifly.userSong;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.dayron.spotifly.R;

public class UserSongActivity
    extends AppCompatActivity implements UserSongContract.View {

  public static String TAG = UserSongActivity.class.getSimpleName();

  private UserSongContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_song);

    // do the setup
    UserSongScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchData();
  }

  @Override
  public void displayData(UserSongViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
  }

  @Override
  public void injectPresenter(UserSongContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

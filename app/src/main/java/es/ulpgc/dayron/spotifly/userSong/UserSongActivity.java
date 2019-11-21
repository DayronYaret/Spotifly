package es.ulpgc.dayron.spotifly.userSong;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.dayron.spotifly.R;

public class UserSongActivity
    extends AppCompatActivity implements UserSongContract.View {

  public static String TAG = UserSongActivity.class.getSimpleName();

  private UserSongContract.Presenter presenter;
  private TextView user;
  private Button song;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_song);

    user = findViewById(R.id.textViewUserName);
    song = findViewById(R.id.buttonSong);

    song.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.goPlayer();
      }
    });

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
    user.setText(viewModel.usuario);
    song.setText(viewModel.cancion);
  }

  @Override
  public void displayFailure() {
    Toast.makeText(this, "Hubo un error", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void injectPresenter(UserSongContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

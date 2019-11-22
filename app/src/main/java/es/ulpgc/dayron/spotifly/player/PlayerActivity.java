package es.ulpgc.dayron.spotifly.player;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.dayron.spotifly.R;

import static android.media.MediaExtractor.MetricsConstants.FORMAT;

public class PlayerActivity
    extends AppCompatActivity implements PlayerContract.View {

  public static String TAG = PlayerActivity.class.getSimpleName();

  private PlayerContract.Presenter presenter;
  private TextView title, artist, progress, end;
  private MediaPlayer mp;
  private String url;
  private Button play, pause;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_player);
    title = findViewById(R.id.textViewSongName);
    artist = findViewById(R.id.textViewArtist);
    progress = findViewById(R.id.textViewStart);
    end=findViewById(R.id.textViewEnd);
    play=findViewById(R.id.buttonPlay);
    pause=findViewById(R.id.buttonPause);

    play.setEnabled(false);
    mp = new MediaPlayer();
    pause.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mp.pause();
        play.setEnabled(true);
        pause.setEnabled(false);
      }
    });
    play.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mp.start();
        pause.setEnabled(true);
        play.setEnabled(false);
      }
    });


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
    this.url=viewModel.url;
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
  public void displayFailure() {
    Toast.makeText(this, "Hubo un error", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void reproducirCancion(final String url) {
          Log.d("PlayerV", url);


              try {
                mp.setDataSource(url);
                mp.prepare();
                mp.start();
                int duracionMs = mp.getDuration();
                String FORMAT = "%2d,%02d";
                String  duracion =  String.format(FORMAT,
                    //Minutes
                    TimeUnit.MILLISECONDS.toMinutes(duracionMs) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duracionMs)),
                    //Seconds
                    TimeUnit.MILLISECONDS.toSeconds(duracionMs) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duracionMs)));
                end.setText(duracion);
              } catch (IOException e) {
              }

  }


  @Override
  public void onBackPressed() {
    mp.release();
    mp=null;
    finish();
  }

  @Override
  public void injectPresenter(PlayerContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

package es.ulpgc.dayron.spotifly.player;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
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
  private SeekBar seekBarProgress;
  private final Handler handler = new Handler();


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
    seekBarProgress = findViewById(R.id.seekBar);
    //Este on touch listener coge el valor donde se deja el seekbar y se lo pasa al mediaplayer para que reproduzca desde ahi
    seekBarProgress.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View view, MotionEvent motionEvent) {
        if(view.getId() == R.id.seekBar){

          /** Seekbar onTouch event handler. Method which seeks MediaPlayer to seekBar primary progress position*/
          if(mp.isPlaying()){
            SeekBar sb = (SeekBar)view;
            int playPositionInMilliseconds = (mp.getDuration() / 100) * sb.getProgress();
            mp.seekTo(playPositionInMilliseconds);
          }
        }
        return false;
      }
    });


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

    primarySeekBarProgressUpdater();
    // do the setup
    PlayerScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchData();
  }

  //Este metodo actualiza el valor del seekbar constantemente segun el progreso de la cancion
  private void primarySeekBarProgressUpdater() {
    seekBarProgress.setProgress((int)(((float)mp.getCurrentPosition()/mp.getDuration())*100)); // This math construction give a percentage of "was playing"/"song length"
    if (mp.isPlaying()) {
      Runnable notification = new Runnable() {
        public void run() {
          primarySeekBarProgressUpdater();
        }
      };
      handler.postDelayed(notification,1000);
    }
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
                //hasta el setText, pone la duracion de la cancion en uno de los textView
                int duracionMs = mp.getDuration();
                String FORMAT = "%2d,%02d";
                String  duracion =  String.format(FORMAT, //Esto es necesario para cambiar los milisegundos que te da getDuration a minutos y segundos
                    //Minutes
                    TimeUnit.MILLISECONDS.toMinutes(duracionMs) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duracionMs)),
                    //Seconds
                    TimeUnit.MILLISECONDS.toSeconds(duracionMs) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duracionMs)));
                end.setText(duracion);
              } catch (IOException e) {
              }
              runOnUiThread(new Runnable() {
                @Override
                public void run() {
                  if(mp!=null) {
                    //Este bloque pone en un textView el tiempo transcurrido de la cancion
                    int progresoMs = mp.getCurrentPosition();
                    String FORMAT = "%2d,%02d";
                    String duracion = String.format(FORMAT,
                        //Minutes
                        TimeUnit.MILLISECONDS.toMinutes(progresoMs) -
                            TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(progresoMs)),
                        //Seconds
                        TimeUnit.MILLISECONDS.toSeconds(progresoMs) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(progresoMs)));
                    progress.setText(duracion);
                    seekBarProgress.setMax(mp.getDuration() / 1000);
                    int mCurrentPosition = mp.getCurrentPosition() / 1000;
                    seekBarProgress.setProgress(mCurrentPosition);
                    handler.postDelayed(this, 1000); // actualiza el valor cada segundo
                  }
                }
              });

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

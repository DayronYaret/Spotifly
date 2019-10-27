package es.ulpgc.dayron.spotifly.addSongs;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import es.ulpgc.dayron.spotifly.R;

public class AddSongsActivity
    extends AppCompatActivity implements AddSongsContract.View {

  public static String TAG = AddSongsActivity.class.getSimpleName();

  private AddSongsContract.Presenter presenter;
  private EditText title, artist;
  private TextView fileName;
  private Button searchFile, cancel, submit;
  private Intent myFileIntent;
  private String songTitle, songArtist;
  private Uri path;
  private final int READ_EXTERNAL_STORAGE = 1;
  private ProgressBar progressBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_songs);
    askPermission(Manifest.permission.READ_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE);


    // do the setup
    AddSongsScreen.configure(this);


    title = findViewById(R.id.editTextTitle);
    artist = findViewById(R.id.editTextArtist);
    fileName = findViewById(R.id.textViewFileName);
    searchFile = findViewById(R.id.searchButton);
    cancel = findViewById(R.id.cancelButton);
    submit = findViewById(R.id.submitButton);
    progressBar = findViewById(R.id.progressbar_addSongs);


    cancel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        terminar();
      }
    });
    submit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startProgressBar();
        songTitle = title.getText().toString();
        songArtist = artist.getText().toString();
        presenter.uploadSong(songTitle, songArtist, path);
      }
    });
    searchFile.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        myFileIntent = new Intent(Intent.ACTION_GET_CONTENT);
        myFileIntent.setType("*/*");
        startActivityForResult(myFileIntent, 10);
      }
    });
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
        presenter.goSongs();
        break;

      case R.id.addSongsOption:
        break;
      default:
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    switch (requestCode) {
      case 10:

        if (resultCode == RESULT_OK) {
          Uri selectedsong = data.getData();
          path = selectedsong; //.getLastPathSegment() ultimo segmento del path, el nombre del archivo
          //String path = getApplicationContext().getFilesDir().getPath();
          fileName.setText(path.toString());
        }
        break;
    }

  }

  @Override
  protected void onResume() {
    super.onResume();


    // load the data
    presenter.fetchData();
  }

  @Override
  public void displayData(AddSongsViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data

  }

  @Override
  public void displayError() {
    Toast.makeText(this, "Hubo un error", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void displaySuccess() {
    Toast.makeText(this, "Cancion subida", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void terminar() {
    finish();
  }

  @Override
  public void injectPresenter(AddSongsContract.Presenter presenter) {
    this.presenter = presenter;
  }

  private void askPermission(String permission, int requestCode) {
    if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
    } else {
      Toast.makeText(this, "Ya tienes permisos", Toast.LENGTH_SHORT).show();
    }
  }

  private void startProgressBar() {
    progressBar.setVisibility(View.VISIBLE);
    progressBar.setEnabled(true);
  }

  private void stopProgressBar() {
    progressBar.setVisibility(View.INVISIBLE);
    progressBar.setEnabled(false);
  }

}

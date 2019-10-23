package es.ulpgc.dayron.spotifly.addSongs;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.dayron.spotifly.R;

public class AddSongsActivity
    extends AppCompatActivity implements AddSongsContract.View {

  public static String TAG = AddSongsActivity.class.getSimpleName();

  private AddSongsContract.Presenter presenter;
  private EditText title, artist;
  private TextView fileName;
  private Button searchFile, cancel, submit;
  private Intent myFileIntent;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_songs);

    // do the setup
    AddSongsScreen.configure(this);
    title=findViewById(R.id.editTextTitle);
    artist=findViewById(R.id.editTextArtist);
    fileName=findViewById(R.id.textViewFileName);
    searchFile=findViewById(R.id.searchButton);
    cancel=findViewById(R.id.cancelButton);
    submit = findViewById(R.id.submitButton);

    cancel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.goSongs();
      }
    });
    submit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //TODO: presenter.uploadSong();
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
    switch(requestCode){
      case 10:

        if(resultCode==RESULT_OK) {
          String path = data.getData().getPath();
          fileName.setText(path);
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
  public void injectPresenter(AddSongsContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

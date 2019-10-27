package es.ulpgc.dayron.spotifly.songs;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import es.ulpgc.dayron.spotifly.R;
import es.ulpgc.dayron.spotifly.app.Song;

public class SongsActivity
    extends AppCompatActivity implements SongsContract.View {

  public static String TAG = SongsActivity.class.getSimpleName();

  private SongsContract.Presenter presenter;
  private SongsAdapter listAdapter;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_songs);

    listAdapter = new SongsAdapter(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        String item = (String) view.getTag();
        presenter.selectSongListData(item);
      }
    });
    RecyclerView recyclerView = findViewById(R.id.songsList);
    recyclerView.setAdapter(listAdapter);

    // do the setup
    SongsScreen.configure(this);

    //songsItemArrayList = presenter.devolverArray();

    //presenter.fillSongsArray();


    //presenter.fetchData();

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
  public void displaySuccess() {
    Toast.makeText(this, "Exito al crear la lista", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void displayFailure() {
    Toast.makeText(this, "Fallo al crear la lista", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void displaySongs(SongsViewModel viewModel) {
    final ArrayList<String> canciones = viewModel.canciones;
    Log.d("Vista", canciones.toString());
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        listAdapter.setItems(canciones);
      }
    });


  }

  @Override
  public void injectPresenter(SongsContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

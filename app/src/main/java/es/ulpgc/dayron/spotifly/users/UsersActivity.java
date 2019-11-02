package es.ulpgc.dayron.spotifly.users;


import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import es.ulpgc.dayron.spotifly.R;

public class UsersActivity
    extends AppCompatActivity implements UsersContract.View {

  public static String TAG = UsersActivity.class.getSimpleName();

  private UsersContract.Presenter presenter;
  private UsersAdapter listAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_users);

    listAdapter = new UsersAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String item = (String) view.getTag();
        presenter.selectedUserListDAta(item);
      }
    });
    RecyclerView recyclerView = findViewById(R.id.userList);
    recyclerView.setAdapter(listAdapter);

    // do the setup
    UsersScreen.configure(this);
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

      case R.id.usersOption:
        break;

      case R.id.songsOption:
        presenter.goSongs();
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
  public void displayData(UsersViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
  }

  @Override
  public void displayUsers(UsersViewModel viewModel) {
    final ArrayList<String> usuarios = viewModel.users;
    Log.d("Vista2", usuarios.toString());
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        listAdapter.setItems(usuarios);
      }
    });
  }

  @Override
  public void finishActivity() {
    finish();
  }

  @Override
  public void displayFailure() {
    Toast.makeText(this, "Fallo al crear la lista", Toast.LENGTH_SHORT).show();

  }

  @Override
  public void displaySuccess() {
    Toast.makeText(this, "Exito al crear la lista", Toast.LENGTH_SHORT).show();

  }

  @Override
  public void injectPresenter(UsersContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

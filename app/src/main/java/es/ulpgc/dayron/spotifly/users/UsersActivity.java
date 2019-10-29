package es.ulpgc.dayron.spotifly.users;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.dayron.spotifly.R;

public class UsersActivity
    extends AppCompatActivity implements UsersContract.View {

  public static String TAG = UsersActivity.class.getSimpleName();

  private UsersContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_users);

    // do the setup
    UsersScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchData();
  }

  @Override
  public void displayData(UsersViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
  }

  @Override
  public void injectPresenter(UsersContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

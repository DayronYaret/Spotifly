package es.ulpgc.dayron.spotifly.friends;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.dayron.spotifly.R;

public class FriendsActivity
    extends AppCompatActivity implements FriendsContract.View {

  public static String TAG = FriendsActivity.class.getSimpleName();

  private FriendsContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_friends);

    // do the setup
    FriendsScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchData();
  }

  @Override
  public void displayData(FriendsViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
  }

  @Override
  public void injectPresenter(FriendsContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

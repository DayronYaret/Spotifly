package es.ulpgc.dayron.spotifly.addFriends;


import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.dayron.spotifly.R;

public class AddFriendsActivity
    extends AppCompatActivity implements AddFriendsContract.View {

  public static String TAG = AddFriendsActivity.class.getSimpleName();

  private AddFriendsContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_friends);

    // do the setup
    AddFriendsScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchData();
  }

  @Override
  public void displayData(AddFriendsViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data

  }

  @Override
  public void injectPresenter(AddFriendsContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

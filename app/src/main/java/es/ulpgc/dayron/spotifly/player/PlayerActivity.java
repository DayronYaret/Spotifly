package es.ulpgc.dayron.spotifly.player;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.dayron.spotifly.R;

public class PlayerActivity
    extends AppCompatActivity implements PlayerContract.View {

  public static String TAG = PlayerActivity.class.getSimpleName();

  private PlayerContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_player);

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
  public void displayData(PlayerViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.data)).setText(viewModel.data);
  }

  @Override
  public void injectPresenter(PlayerContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

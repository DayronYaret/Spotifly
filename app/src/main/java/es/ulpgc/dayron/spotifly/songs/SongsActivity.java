package es.ulpgc.dayron.spotifly.songs;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.dayron.spotifly.R;

public class SongsActivity
    extends AppCompatActivity implements SongsContract.View {

  public static String TAG = SongsActivity.class.getSimpleName();

  private SongsContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_songs);

    // do the setup
    SongsScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchData();
  }

  @Override
  public void displayData(SongsViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.data)).setText(viewModel.data);
  }

  @Override
  public void injectPresenter(SongsContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

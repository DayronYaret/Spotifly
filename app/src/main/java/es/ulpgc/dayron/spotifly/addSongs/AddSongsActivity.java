package es.ulpgc.dayron.spotifly.addSongs;


import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.dayron.spotifly.R;

public class AddSongsActivity
    extends AppCompatActivity implements AddSongsContract.View {

  public static String TAG = AddSongsActivity.class.getSimpleName();

  private AddSongsContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_songs);

    // do the setup
    AddSongsScreen.configure(this);
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

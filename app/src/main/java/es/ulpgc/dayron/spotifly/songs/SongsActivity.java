package es.ulpgc.dayron.spotifly.songs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.dayron.spotifly.R;

public class SongsActivity
    extends AppCompatActivity implements SongsContract.View {

  public static String TAG = SongsActivity.class.getSimpleName();

  private SongsContract.Presenter presenter;
  private Button logout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_songs);

    // do the setup
    SongsScreen.configure(this);
    logout=findViewById(R.id.buttonLogout);

    logout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.SignOut();
        presenter.goLogin();

      }
    });

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
  public void injectPresenter(SongsContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

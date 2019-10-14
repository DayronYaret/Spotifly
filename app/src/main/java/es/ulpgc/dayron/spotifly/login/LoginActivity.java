package es.ulpgc.dayron.spotifly.login;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.dayron.spotifly.R;

public class LoginActivity
    extends AppCompatActivity implements LoginContract.View {

  public static String TAG = LoginActivity.class.getSimpleName();

  private LoginContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    // do the setup
    LoginScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchData();
  }

  @Override
  public void displayData(LoginViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    //((TextView) findViewById(R.id.data)).setText(viewModel.data);
  }

  @Override
  public void injectPresenter(LoginContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

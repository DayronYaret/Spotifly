package es.ulpgc.dayron.spotifly.register;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.dayron.spotifly.R;

public class RegisterActivity
    extends AppCompatActivity implements RegisterContract.View {

  public static String TAG = RegisterActivity.class.getSimpleName();

  private RegisterContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);

    // do the setup
    RegisterScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchData();
  }

  @Override
  public void displayData(RegisterViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data

  }

  @Override
  public void injectPresenter(RegisterContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

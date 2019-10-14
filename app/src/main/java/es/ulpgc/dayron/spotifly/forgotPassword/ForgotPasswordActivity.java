package es.ulpgc.dayron.spotifly.forgotPassword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.dayron.spotifly.R;

public class ForgotPasswordActivity
    extends AppCompatActivity implements ForgotPasswordContract.View {

  public static String TAG = ForgotPasswordActivity.class.getSimpleName();

  private ForgotPasswordContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_forgot_password);

    // do the setup
    ForgotPasswordScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchData();
  }

  @Override
  public void displayData(ForgotPasswordViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.data)).setText(viewModel.data);
  }

  @Override
  public void injectPresenter(ForgotPasswordContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

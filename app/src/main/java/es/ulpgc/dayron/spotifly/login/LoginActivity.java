package es.ulpgc.dayron.spotifly.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.dayron.spotifly.R;
import es.ulpgc.dayron.spotifly.app.Checker;

public class LoginActivity
    extends AppCompatActivity implements LoginContract.View {

  public static String TAG = LoginActivity.class.getSimpleName();

  private LoginContract.Presenter presenter;
  private TextView forgotPassword, register;
  private Button go;
  private EditText username, password;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    // do the setup
    LoginScreen.configure(this);
    forgotPassword = findViewById(R.id.textViewPassword);
    register = findViewById(R.id.registro);
    go = findViewById(R.id.buttonLogin);
    username = findViewById(R.id.user);
    password = findViewById(R.id.password);

    //listeners
    go.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        if (Checker.validateUsername(username) && Checker.validatePassword(password)) {
          String user = username.getText().toString();
          String pass = password.getText().toString();
          presenter.signIn(user, pass);
        }
      }
    });

    forgotPassword.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.goForgot();
      }
    });

    register.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.goRegister();
      }
    });
  }

  @Override
  protected void onResume(){
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

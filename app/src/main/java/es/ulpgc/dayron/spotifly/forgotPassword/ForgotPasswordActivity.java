package es.ulpgc.dayron.spotifly.forgotPassword;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.dayron.spotifly.R;

public class ForgotPasswordActivity
    extends AppCompatActivity implements ForgotPasswordContract.View {

  public static String TAG = ForgotPasswordActivity.class.getSimpleName();

  private ForgotPasswordContract.Presenter presenter;
  private Button cancel, submit;
  private EditText email;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_forgot_password);

    // do the setup
    ForgotPasswordScreen.configure(this);
    cancel = findViewById(R.id.cancelButton);
    submit = findViewById(R.id.submitButton);
    email = findViewById(R.id.editTextEmail);

    cancel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onBackPressed();
      }
    });
    submit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String userEmail = email.getText().toString();
        if (userEmail.equals("")) {
          Toast.makeText(ForgotPasswordActivity.this, "Por favor, rellene el campo correo electronico", Toast.LENGTH_SHORT).show();
        } else {
          presenter.forgotPassword(userEmail);
        }
      }
    });
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
  }

  @Override
  public void displaySuccess() {
    Toast.makeText(this, "Se ha enviado correctamente el email", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void displayError() {
    Toast.makeText(this, "El usuario es incorrecto", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void injectPresenter(ForgotPasswordContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

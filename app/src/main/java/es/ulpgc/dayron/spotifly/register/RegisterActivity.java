package es.ulpgc.dayron.spotifly.register;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.dayron.spotifly.R;

public class RegisterActivity
    extends AppCompatActivity implements RegisterContract.View {

  public static String TAG = RegisterActivity.class.getSimpleName();

  private RegisterContract.Presenter presenter;
  private EditText username, email, pass, rpass;
  private Button cancel, register;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);

    // do the setup
    RegisterScreen.configure(this);
    username=findViewById(R.id.editTexUsert);
    email = findViewById(R.id.editTextCorreo);
    pass = findViewById(R.id.editTextClave1);
    rpass=findViewById(R.id.editTextClave2);
    cancel=findViewById(R.id.cancelButton);
    register=findViewById(R.id.registerButton);


    //listener

    cancel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onBackPressed();
      }
    });
    register.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String user = username.getText().toString();
        String userEmail = email.getText().toString();
        String userPass = pass.getText().toString();
        String userPass2 = rpass.getText().toString();
        if(user.isEmpty() || userEmail.isEmpty() || userPass.isEmpty() || userPass2.isEmpty()){
          Toast.makeText(RegisterActivity.this, "Por favor, rellene todos los campos", Toast.LENGTH_SHORT).show();
        }
        else if(userPass.equals(userPass2)){
          presenter.register(user, userEmail, userPass);
        }else{
          Toast.makeText(RegisterActivity.this, "Por favor, introduzca bien la misma contraseña", Toast.LENGTH_SHORT).show();
        }
      }
    });
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  public void displayData(RegisterViewModel viewModel) {
    //Log.e(TAG, "displayData()");
    Toast.makeText(this, "Usuario añadido correctamente", Toast.LENGTH_SHORT).show();
    onBackPressed();

  }

  @Override
  public void displayError() {
    Toast.makeText(this, "No se ha podido añadir el usuario, cambie el email y el usuario por favor", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void injectPresenter(RegisterContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

package es.ulpgc.dayron.spotifly.login;

import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.lang.ref.WeakReference;

import androidx.annotation.NonNull;
import es.ulpgc.dayron.spotifly.app.RepositoryContract;


public class LoginModel implements LoginContract.Model {

  public static String TAG = LoginModel.class.getSimpleName();
  private LoginContract.Presenter presenter;
  private FirebaseAuth mAuth;
  private RepositoryContract repository;


  public LoginModel(RepositoryContract repository) {
    this.mAuth=FirebaseAuth.getInstance();
    this.repository=repository;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public void signIn(String email, String pass, RepositoryContract.LoginUser callback) {
    repository.loginUser(email, pass, callback);
  }

}

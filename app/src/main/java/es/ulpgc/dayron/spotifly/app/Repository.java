package es.ulpgc.dayron.spotifly.app;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Repository implements RepositoryContract {

  private static Repository INSTANCE;
  private FirebaseAuth mAuth = FirebaseAuth.getInstance();
  private Context context;

  public static RepositoryContract getInstance(Context context) {
    if(INSTANCE == null){
      INSTANCE = new Repository(context);
    }
    return INSTANCE;
  }
  private Repository(Context context) {
    this.context = context;
  }

  @Override
  public void loginUser(String email, String pass, final LoginUser callback) {
    mAuth.signInWithEmailAndPassword(email, pass).
        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
              // Sign in success, update UI with the signed-in user's information
              callback.onUserLogIn(false);
            } else {
              // If sign in fails, display a message to the user.
              callback.onUserLogIn(true);
            }
          }
        });
  }

  @Override
  public void registerUser(final String user, final String email, final String pass, final RegisterUser callback) {

    FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        if(dataSnapshot.child("usuarios").hasChild(user.toLowerCase())){
          callback.onUserRegister(true);
        }else{
          mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
              if (task.isSuccessful()){
                String uId= mAuth.getUid();
                User usuario = new User(user, email, uId);
                FirebaseDatabase.getInstance().getReference().child("usuarios").child(user.toLowerCase()).setValue(usuario).addOnCompleteListener(new OnCompleteListener<Void>() {
                  @Override
                  public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                      callback.onUserRegister(false);
                    }else{
                      callback.onUserRegister(true);
                    }
                  }
                });
              }else{
                callback.onUserRegister(true);
              }
            }
          });
        }
      }

      @Override
      public void onCancelled(@NonNull DatabaseError databaseError) {

      }
    });
  }

  @Override
  public void checkLogin(IsUserLogin callback) {
    mAuth=FirebaseAuth.getInstance();
    if(mAuth.getCurrentUser()!=null){
      callback.isUserLogin(true);

    }else{
      callback.isUserLogin(false);
    }
  }

  @Override
  public void signOut(SignOut callback) {
    mAuth=FirebaseAuth.getInstance();
    mAuth.signOut();
    if(mAuth.getCurrentUser()==null){
      callback.userSignOut(true);
    }else{
      callback.userSignOut(false);
    }
  }

  @Override
  public void forgotPassword(final String email, final ForgotPassword callback) {
    mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
      @Override
      public void onComplete(@NonNull Task<Void> task) {
        if (task.isSuccessful()) {
          Log.d("Repo", "funka y se supone que envio el correo");
          // successful operation
          callback.onForgotPassword(false);
        } else {
          Log.d("Repo", email);
          callback.onForgotPassword(true);
        }
      }
    });
  }
  }

package es.ulpgc.dayron.spotifly.app;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

import androidx.annotation.NonNull;


public class Repository implements RepositoryContract {

  private static Repository INSTANCE;
  private FirebaseAuth mAuth = FirebaseAuth.getInstance();
  private Context context;
  private FirebaseStorage storage = FirebaseStorage.getInstance();
  private StorageReference storageReference = storage.getReference();
  private String url;
  private DatabaseReference songsDataRefActivitySongs;
  private ArrayList<String> songList;

  public static RepositoryContract getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new Repository(context);
    }
    return INSTANCE;
  }

  private Repository(Context context) {
    this.context = context;
    this.songList = new ArrayList<>();
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
        if (dataSnapshot.child("usuarios").hasChild(user.toLowerCase())) {
          callback.onUserRegister(true);
        } else {
          mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
              if (task.isSuccessful()) {
                String uId = mAuth.getUid();
                User usuario = new User(user, email, uId);
                FirebaseDatabase.getInstance().getReference().child("usuarios").child(user.toLowerCase()).setValue(usuario).addOnCompleteListener(new OnCompleteListener<Void>() {
                  @Override
                  public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                      callback.onUserRegister(false);
                    } else {
                      callback.onUserRegister(true);
                    }
                  }
                });
              } else {
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
    mAuth = FirebaseAuth.getInstance();
    if (mAuth.getCurrentUser() != null) {
      callback.isUserLogin(true);

    } else {
      callback.isUserLogin(false);
    }
  }

  @Override
  public void signOut(SignOut callback) {
    mAuth = FirebaseAuth.getInstance();
    mAuth.signOut();
    if (mAuth.getCurrentUser() == null) {
      callback.userSignOut(true);
    } else {
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

  @Override
  public void uploadSong(final String title, final String artist, Uri path, final UploadSong callback) {
    Uri file = Uri.fromFile(new File(path.getPath()));
    final StorageReference songRef = storageReference.child("songs/" + file.getLastPathSegment());
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    UploadTask uploadTask = songRef.putFile((file));
    uploadTask.addOnFailureListener(new OnFailureListener() {
      @Override
      public void onFailure(@NonNull Exception e) {
        callback.onUploadSong(true);
      }
    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
      @Override
      public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
        callback.onUploadSong(false);
      }
    });
    Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
      @Override
      public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
        if (!task.isSuccessful()) {
          throw task.getException();
        }

        // Continue with the task to get the download URL
        return songRef.getDownloadUrl();
      }
    }).addOnCompleteListener(new OnCompleteListener<Uri>() {
      @Override
      public void onComplete(@NonNull Task<Uri> task) {
        if (task.isSuccessful()) {
          Uri downloadUri = task.getResult();
          url = downloadUri.toString();
          Song cancion = new Song(url, title, artist);
          Log.d("Repo", cancion.getArtist());
          Log.d("Repo", cancion.getTitle());
          Log.d("Repo", cancion.getUrl());
          songsDataRefActivitySongs.child(title).setValue(cancion).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
              callback.onUploadSong(false);
            }
          });
        } else {
          Log.d("Repo", "No se consiguió la url");
        }
      }
    });
  }

  @Override
  public ArrayList<String> fillSongsArray(final FillSongsArray callback) {
    if(songsDataRefActivitySongs!=null){
      return null;
    }

    songsDataRefActivitySongs = FirebaseDatabase.getInstance().getReference().child("songs");
    songsDataRefActivitySongs.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        songList.clear();
        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
          String songTitle = (String) dataSnapshot1.child("title").getValue();
          Log.d("Repo", songTitle);
          songList.add(songTitle);
        }
        Log.d("Repo", songList.toString());
        callback.onFillSongsArray(false, songList);
      }

      @Override
      public void onCancelled(@NonNull DatabaseError databaseError) {

      }
    });
    return songList;
  }

}

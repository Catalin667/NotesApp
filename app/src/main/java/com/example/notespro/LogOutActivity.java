package com.example.notespro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogOutActivity extends AppCompatActivity {

    Button logOutButton;
    FirebaseAuth firebaseAuth =  FirebaseAuth.getInstance();

    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

    GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);

        logOutButton = findViewById(R.id.log_out_button_google);

        // Initialize sign in client
//        googleSignInClient = GoogleSignIn.getClient(LogOutActivity.this, GoogleSignInOptions.DEFAULT_SIGN_IN);

//        logOutButton.setOnClickListener(view -> {
//            // Sign out from google
//            googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
//                @Override
//                public void onComplete(@NonNull Task<Void> task) {
//                    // Check condition
//                    if (task.isSuccessful()) {
//                        // When task is successful sign out from firebase
//                        firebaseAuth.signOut();
//                        // Display Toast
//                        Toast.makeText(getApplicationContext(), "Logout successful", Toast.LENGTH_SHORT).show();
//                        // Finish activity
//                        finish();
//                    }
//                }
//            });
//        });


    }
}
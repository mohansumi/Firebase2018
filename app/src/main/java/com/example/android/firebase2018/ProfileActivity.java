package com.example.android.firebase2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    private TextView profileEmail;

    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        profileEmail = findViewById(R.id.profileEmail);

        profileEmail.setText(user.getEmail());
    }

    public void signOut(View view){
       auth.signOut();
       finish();

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}

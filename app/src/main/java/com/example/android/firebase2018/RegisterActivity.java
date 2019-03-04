package com.example.android.firebase2018;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText e1, e2;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        e1 = findViewById(R.id.etRegisterEmail);
        e2 = findViewById(R.id.etRegisterPassword);

        auth = FirebaseAuth.getInstance();
    }

    public void createUser(View view) {
        if (e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty()){
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        } else {
            String email = e1.getText().toString();
            String password = e2.getText().toString();

            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "User created successfully", Toast.LENGTH_SHORT).show();

                                Intent i = new Intent(RegisterActivity.this, ProfileActivity.class);
                                startActivity(i);

                            } else {
                                Toast.makeText(RegisterActivity.this, "User could not be created", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}

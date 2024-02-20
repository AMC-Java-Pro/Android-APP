package com.example.amc_java;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login_screen extends AppCompatActivity {
    Button button;
    TextView resign;
    EditText email, password;
    FirebaseAuth auth;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressBar progressBar;

    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {

            Intent intent = new Intent(login_screen.this, home_screen.class);
            startActivity(intent);
            finish();
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logbutton);
        resign = findViewById(R.id.resignup);
        email = findViewById(R.id.editTextLogEmail);
        password = findViewById(R.id.editTextLogPassword);



        resign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), signin_screen.class);
                startActivity(intent);
                finish();

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = email.getText().toString();
                String pass = password.getText().toString();

                if (TextUtils.isEmpty(Email) || TextUtils.isEmpty(pass)){

                    Toast.makeText(login_screen.this, "e-mail and Password can't be empty", Toast.LENGTH_SHORT).show();

                }else if (!Email.matches(emailPattern)) {

                    email.setError("Enter valid e-mail");

                } else if (password.length()<6) {

                    password.setError("Must be more than 6 character");
                    Toast.makeText(login_screen.this, "Password needs to be longer than 6 character", Toast.LENGTH_SHORT).show();

                }else {

                    auth.signInWithEmailAndPassword(Email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                            if (task.isSuccessful()) {

                                try {
                                    Intent intent = new Intent(login_screen.this, home_screen.class);
                                    startActivity(intent);
                                    finish();

                                }catch (Exception e) {

                                    Toast.makeText(login_screen.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                                }

                            } else {

                                Toast.makeText(login_screen.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }
            }
        });


    }
}
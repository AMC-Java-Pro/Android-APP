package com.example.amc_java;

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
import com.google.firebase.database.DatabaseReference;


public class signin_screen extends AppCompatActivity {

    TextView relog;
    EditText si_username, si_email, si_password, si_repassword;
    Button si_signup;
    FirebaseAuth auth;
    DatabaseReference databaseReference;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressBar progressBar;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = auth.getCurrentUser();
        if(currentUser != null) {

            Intent intent = new Intent(getApplicationContext(), home_screen.class);
            startActivity(intent);
            finish();

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_screen);

        auth = FirebaseAuth.getInstance();
        relog = findViewById(R.id.relogin);
        si_username = findViewById(R.id.signupUsername);
        si_email = findViewById(R.id.sigupemail);
        si_password = findViewById(R.id.sigupPassword);
        si_repassword = findViewById(R.id.siguppassword);
        si_signup = findViewById(R.id.signupbutton);
        progressBar = findViewById(R.id.progressbar);


        relog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(signin_screen.this, login_screen.class);
                startActivity(intent);
                finish();

            }
        });

        si_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);

                String namee = si_username.getText().toString();
                String emaill = si_email.getText().toString();
                String Password = si_password.getText().toString();
                String cPassword = si_repassword.getText().toString();

                if ( TextUtils.isEmpty(namee) || TextUtils.isEmpty(emaill) ||
                        TextUtils.isEmpty(Password) || TextUtils.isEmpty(cPassword)) {

                    Toast.makeText(signin_screen.this, "Please enter valid Information", Toast.LENGTH_SHORT).show();

                } else if (!emaill.matches(emailPattern)) {

                    si_email.setError("Enter a valid email");

                } else if (Password.length()<6) {

                    si_password.setError("Password must be 6 character or more");

                } else if (!Password.equals(cPassword)) {

                    si_password.setError("Password doesn't match");

                }else {

                    auth.createUserWithEmailAndPassword(emaill, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            progressBar.setVisibility(View.GONE);

                            if (task.isSuccessful()){

                                Toast.makeText(signin_screen.this, "Account created", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), home_screen.class);
                                startActivity(intent);
                                finish();

                            }else {

                                Toast.makeText(signin_screen.this, "Authentication failed", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
                }

            }
        });

    }

}
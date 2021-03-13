package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edEmail,edPassword;
    Button btSignIn;

    String email,pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edEmail = findViewById(R.id.editEmail);
        edPassword = findViewById(R.id.editPassword);
        btSignIn = findViewById(R.id.buttonSignin);

        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = "admin1@mail.com";
                pwd = "123";

                if (email.equals(edEmail.getText().toString()) && pwd.equals(edPassword.getText().toString())) {

                    Toast t = Toast.makeText(getApplicationContext(),
                            "Login Sukses", Toast.LENGTH_LONG);
                    t.show();

                } else if (email.equals(edEmail.getText().toString())  && !pwd.equals(edPassword.getText().toString())) {

                    Toast t = Toast.makeText(getApplicationContext(),
                            "Password Salah", Toast.LENGTH_LONG);
                    t.show();

                } else if (!email.equals(edEmail.getText().toString()) && pwd.equals(edPassword.getText().toString())) {

                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email Salah", Toast.LENGTH_LONG);
                    t.show();

                } else {

                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password Salah", Toast.LENGTH_LONG);
                    t.show();

                }

            }
        });

    }
}
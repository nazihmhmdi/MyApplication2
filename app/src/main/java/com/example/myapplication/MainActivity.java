package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    EditText edEmail,edPassword;
    Button btSignIn;
    TextView tvDaftar;
    TextInputLayout hEmail, hPassword;

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

    /*@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar)
        {
            Intent i = new Intent(getApplicationContext(), ActivityDaftar.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edEmail = findViewById(R.id.editEmail);
        edPassword = findViewById(R.id.editPassword);
        btSignIn = findViewById(R.id.buttonSignin);
        tvDaftar = findViewById(R.id.textDaftar);
        hEmail = findViewById(R.id.layoutEmail);
        hPassword = findViewById(R.id.layoutPassword);
        tvDaftar = findViewById(R.id.textDaftar);

        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String eml = "admin@mail.com";
                String pwd = "123456";

                if (edEmail.getText().toString().isEmpty() && edPassword.getText().toString().isEmpty()) {
                    hEmail.setError("Email Cannot Be Empty");
                    hPassword.setError("Password Cannot Be Empty");
                } else if (edEmail.getText().toString().isEmpty()) {
                    hEmail.setError("Email Cannot Be Empty");
                    hPassword.setErrorEnabled(false);
                } else if ( edPassword.getText().toString().isEmpty()) {
                     hPassword.setError("Password Cannot Be Empty");
                     hEmail.setErrorEnabled(false);
                } else if ( edPassword.getText().length() < 6) {
                    hPassword.setError("Password minimal lenght is 6");
                    hEmail.setErrorEnabled(false);
                } else if (edEmail.getText().toString().equals(eml) && edPassword.getText().toString().equals(pwd)) {
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), Home_Activity.class));
                } else {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Wrong Email or Password", Toast.LENGTH_LONG);
                    t.show();
                    hEmail.setErrorEnabled(false);
                    hPassword.setErrorEnabled(false);
                }

                /*
                if (email.isEmpty() || pass.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email atau Password Tidak Boleh Kosong!", Toast.LENGTH_LONG);
                    t.show();
                } else {

                    if (email.equals(eml) && pass.equals(pwd)) {

                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses", Toast.LENGTH_LONG);
                        t.show();

                        Bundle b = new Bundle();
                        b.putString("a", email.trim());
                        b.putString("b", pass.trim());

                        Intent i = new Intent(getApplicationContext(), Home_Activity.class);
                        i.putExtras(b);
                        startActivity(i);

                    } else {

                        Toast t = Toast.makeText(getApplicationContext(),
                                "Email atau Password Salah", Toast.LENGTH_LONG);
                        t.show();

                    }
                }
                 */
            }
        });

        tvDaftar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view1) {
                Intent i = new Intent(getApplicationContext(), ActivityDaftar.class);
                startActivity(i);
            }
        });
    }
}

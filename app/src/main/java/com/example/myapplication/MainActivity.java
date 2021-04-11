package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edEmail,edPassword;
    Button btSignIn;

    String email,pass;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar)
        {
            Intent i = new Intent(getApplicationContext(), ActivityDaftar.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

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

                email = edEmail.getText().toString();
                pass = edPassword.getText().toString();

                String eml = "admin@mail.com";
                String pwd = "123";

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
            }
        });
    }
}

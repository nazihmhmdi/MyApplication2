package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ActivityDaftar extends AppCompatActivity {

    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtRepass;

    FloatingActionButton fab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                name = edtNama.getText().toString();

                if (edtNama.getText().toString().isEmpty() ||
                    edtAlamat.getText().toString().isEmpty() ||
                    edtEmail.getText().toString().isEmpty() ||
                    edtPassword.getText().toString().isEmpty() ||
                    edtRepass.getText().toString().isEmpty())
                {
                    Snackbar.make(view, "Data cannot be empty!", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    if (edtPassword.getText().toString().equals(edtRepass.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "Registered Successfully!",
                                Toast.LENGTH_LONG).show();

//                        Bundle b = new Bundle();
//
//                        b.putString("c", name.trim());

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
//                        i.putExtras(b);
                        startActivity(i);
                    }
                    else
                    {
                        Snackbar.make(view, "Your password and confirmation password do not match!",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
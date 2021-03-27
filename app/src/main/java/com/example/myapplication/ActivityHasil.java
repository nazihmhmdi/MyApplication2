package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityHasil extends AppCompatActivity {

    TextView txEmail, txPassword, txName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        txEmail = findViewById(R.id.tvEmail);
        txPassword = findViewById(R.id.tvPassword);
        txName = findViewById(R.id.tvName);

        Bundle bundle = getIntent().getExtras();

        String email = bundle.getString("a");
        String pass = bundle.getString("b");
        String name = bundle.getString("c");

        txEmail.setText(email);
        txPassword.setText(pass);
        txName.setText(name);
    }
}
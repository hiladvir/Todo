package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Enter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        EditText username= findViewById(R.id.etname);
        String usernameText = username.getText().toString();
        Log.d("username:",username.getText().toString());

        EditText password= findViewById(R.id.etpass);
        String passwordText = password.getText().toString();
        Log.d("password:",password.getText().toString());




        }

    public void gologin(View view) {
        EditText username= findViewById(R.id.etname);
        String usernameText = username.getText().toString();
        EditText password= findViewById(R.id.etpass);
        String passwordText = password.getText().toString();


        if (true) {
            Intent Enterintent = new Intent(Enter.this, New.class);
            startActivity(Enterintent);

        }

        else {
            Toast.makeText(getApplicationContext(),"שם משתמש והסיסמה שגויים", Toast.LENGTH_SHORT).show();
        }
    }
}
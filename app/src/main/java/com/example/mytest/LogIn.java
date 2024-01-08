package com.example.mytest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LogIn extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
     }
    public void goLogin(View view) {
        EditText username= findViewById(R.id.etname);
        String usernameText = username.getText().toString();
        EditText password= findViewById(R.id.etpass);
        String passwordText = password.getText().toString();
        if (usernameText.equals("a") && passwordText.equals("a"))
            startToDoActivity();
        else
            Toast.makeText(getApplicationContext(),"שם משתמש והסיסמה שגויים", Toast.LENGTH_SHORT).show();
    }
    private void startToDoActivity(){
        Intent enterIntent = new Intent(LogIn.this, ToDoActivity.class);
        startActivity(enterIntent);
    }
}
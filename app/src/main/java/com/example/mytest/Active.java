package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Active extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active);
    }

    public void loginButton(View view) {
        Intent myIntent = new Intent(getApplicationContext(), Active.class);
        startActivity(myIntent);
    }
    public void backButton(View view) {
        Intent myIntent = new Intent(Active.this, New.class);
        startActivity(myIntent);
    }
}
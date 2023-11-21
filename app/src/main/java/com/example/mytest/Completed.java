package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Completed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed);
        Intent intent= getIntent();
        if (intent!= null){
            String taskTitle= intent.getStringExtra("taskTitle");
            String taskDescription= intent.getStringExtra("taskDescription");

        }
    }


}
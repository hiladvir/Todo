package com.example.mytest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ToDoActivity extends AppCompatActivity  {
    String [] Data= {"hello"};
    int counter= 0;
    ViewPager2 tabPager;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        tabPager = findViewById(R.id.viewPager);
        tabLayout= findViewById(R.id.tabLayout);
        //getSupportActionBar().hide();
        tabPager.setAdapter(new FragmentsAdapter(this));
        TabLayoutMediator tabLayoutMediator= new TabLayoutMediator(tabLayout, tabPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:{
                        tab.setText("all");
                        break;
                    }
                    case 1:{
                        tab.setText("active");
                        break;
                    }
                    case 2:{
                        tab.setText("completed");
                        break;
                    }
                }
            }
        }); tabLayoutMediator.attach();
    }
    public void btnback2(View view) {
        Intent myIntent = new Intent(ToDoActivity.this, LogIn.class);
        startActivity(myIntent);
    }
}

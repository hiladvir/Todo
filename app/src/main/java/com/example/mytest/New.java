package com.example.mytest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.LinkedList;

public class New extends AppCompatActivity  {

    String [] Data= {"hello"};
    int counter= 0;
    public TaskAdapter taskAdapter;
    ViewPager2 viewPager2;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);





        viewPager2 = findViewById(R.id.viewPager);
        tabLayout= findViewById(R.id.tabLayout);
        //getSupportActionBar().hide();

        viewPager2.setAdapter(new fragmentsAdapter(this));
        TabLayoutMediator tabLayoutMediator= new TabLayoutMediator(tabLayout, viewPager2,
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




    public void onDialogPositiveClick(Task data) {
        taskAdapter.tasks.add(data);
        taskAdapter.notifyDataSetChanged();
    }
    public void activeButton(View view) {
        Intent myIntent = new Intent(New.this, Active.class);
        startActivity(myIntent);
    }
    public void btnback2(View view) {
        Intent myIntent = new Intent(New.this, Enter.class);
        startActivity(myIntent);
    }
    public void comButton(View view) {
        Intent myIntent = new Intent(getApplicationContext(), Completed.class);
        startActivity(myIntent);
    }
}

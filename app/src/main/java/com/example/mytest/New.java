package com.example.mytest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;

public class New extends AppCompatActivity implements MyDialogListener {
    String [] Data= {"hello"};
    int counter= 0;
    public TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Button button = (Button) findViewById(R.id.btnadd);
        button.setOnClickListener(view -> openDialog());

        ArrayList<Task>tasks=new ArrayList<>();
        RecyclerView recyclerView= findViewById(R.id.recyclerviewlist);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        taskAdapter = new TaskAdapter(tasks);
        recyclerView.setAdapter(taskAdapter);
        //List<String> tasks= new LinkedList<>();
        //tasks.add ("Code it");
        RecyclerView recyclerView1= findViewById(R.id.recyclerviewlist);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
//        findViewById(R.id.btnadd).setOnClickListener(view -> {
//          //  tasks.add(data[counter%3]);
//            counter++;
//            taskAdapter.notifyItemInserted(tasks.size()-1);
//        });



    }
    public void openDialog(){
        dialog dialog= new dialog();
        dialog.show(getSupportFragmentManager(),"dialog");

    }

    @Override
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
    @Override
   public void onDialogNegativeClick() {


        }

    private class List<T> {
    }
}

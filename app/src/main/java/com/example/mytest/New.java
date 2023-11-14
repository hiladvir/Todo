package com.example.mytest;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class New extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Button button = (Button) findViewById(R.id.btnadd);
        button.setOnClickListener(view -> openDialog());

        ArrayList<Task>tasks=new ArrayList<>();
        for (int i=0; i<10; i++){
            tasks.add(new Task("לעשות קניות בסופר",
                    "לקנות חלב, שוקולד וסוכר ",
                    "true"));






        }
        RecyclerView recyclerView= findViewById(R.id.recyclerviewlist);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        TaskAdapter taskAdapter= new TaskAdapter(tasks);
        recyclerView.setAdapter(taskAdapter);
    }
    public void openDialog(){
        dialog dialog= new dialog();
        dialog.show(getSupportFragmentManager(),"dialog");

    }
}
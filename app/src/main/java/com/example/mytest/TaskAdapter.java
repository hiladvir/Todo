package com.example.mytest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.PSource;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    List<String> items;


    public ArrayList<Task> tasks;
    private FragmentManager fm;
    public TaskAdapter(ArrayList<Task>tasks, FragmentManager fm){
        this.tasks = tasks;
        this.fm = fm;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View taskview= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritemlist, parent,false);
        TaskViewHolder vh = new TaskViewHolder(taskview);
        vh.linkAdapter(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Task currentTask= tasks.get(position);
        holder.nameTextview.setText(currentTask.getTaskName());
        holder.desTextview.setText(currentTask.getTaskDescription());
        holder.dateTextview.setText(currentTask.getDate());
        ((CheckBox) holder.btncompleted).setChecked(currentTask.isCompleted());

        holder.btncompleted.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
               // tasks.get(position).setCompleted(true);
               // EditText editText1= view.findViewById(R.id.etdis);
                Bundle result= new Bundle();
                result.putString("date", holder.dateTextview.getText().toString());
                result.putString("description", holder.desTextview.getText().toString());
                fm.setFragmentResult("datafromall", result);



        };

        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextview;
        public TextView desTextview;
        public  TextView dateTextview;
        public boolean isCompletedBoolean;
        public Button btncompleted;
        private TaskAdapter adapter;




        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextview= itemView.findViewById(R.id.tvnametask);
            desTextview= itemView.findViewById(R.id.tvdescription);
            isCompletedBoolean= ((CheckBox) itemView.findViewById(R.id.btncompleted)).isChecked();
            dateTextview= itemView.findViewById(R.id.etdate2);
           btncompleted = itemView.findViewById(R.id.btncompleted);
           itemView.findViewById(R.id.btndelete).setOnClickListener(view ->{
               adapter.tasks.remove(getAdapterPosition());
               adapter.notifyItemRemoved(getAdapterPosition());

           } );
        }
        public void linkAdapter(TaskAdapter adapter){
            this.adapter = adapter;
        }
    }




}

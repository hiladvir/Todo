package com.example.mytest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    public ArrayList<Task> tasks;
    public TaskAdapter(ArrayList<Task>tasks){
        this.tasks= tasks;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View taskview= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritemlist, parent,false);
        return new TaskViewHolder(taskview);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task currentTask= tasks.get(position);
        holder.nameTextview.setText(currentTask.getTaskName());
        holder.desTextview.setText(currentTask.getTaskDescription());
        holder.dateTextview.setText(currentTask.getDate());
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

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextview= itemView.findViewById(R.id.tvnametask);
            desTextview= itemView.findViewById(R.id.tvdescription);
            isCompletedBoolean= itemView.findViewById(R.id.btncompleted).isOpaque();
            dateTextview= itemView.findViewById(R.id.etdate2);
        }
    }




}

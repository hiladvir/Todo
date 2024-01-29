package com.example.mytest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    public ArrayList<Task> tasks;
    private final FragmentManager fragmentManager;
    public TaskAdapter(ArrayList<Task>tasks, FragmentManager fragmentManager){
        this.tasks = tasks;
        this.fragmentManager = fragmentManager;
    }
    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View taskview= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritemlist, parent,false);
        TaskViewHolder viewHolder = new TaskViewHolder(taskview);
        viewHolder.linkAdapter(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Task currentTask= tasks.get(position);
        //holder.nameView.setText(currentTask.getTaskName());
        holder.descView.setText(currentTask.getTaskDescription());
        holder.dateView.setText(currentTask.getDate());
        holder.timeView.setText(currentTask.getTaskTime());
        ((CheckBox) holder.completedBtn).setChecked(currentTask.isCompleted());
        holder.completedBtn.setOnClickListener(view -> {
            Bundle result= new Bundle();
            result.putString("date", holder.dateView.getText().toString());
            result.putString("time", holder.timeView.getText().toString());
            result.putString("description", holder.descView.getText().toString());
            fragmentManager.setFragmentResult("datafromall", result);
            fragmentManager.setFragmentResult("delete_task",result);
    });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
    public Task getTask(String date, String desc, String time) {
        for(Task task : tasks){
            if(task.getTaskDescription().equals(desc) &&
                task.getDate().equals(date) && task.getTaskTime().equals(time))
                return task;
        }
        return null;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {

        public TextView descView;
        public  TextView dateView;
        public TextView timeView;
        public boolean isCompleted;
        public Button completedBtn;
        private TaskAdapter adapter;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            descView = itemView.findViewById(R.id.tvdescription);
            isCompleted= ((CheckBox) itemView.findViewById(R.id.btncompleted)).isChecked();
            dateView = itemView.findViewById(R.id.etdate2);
            timeView = itemView.findViewById(R.id.ettime);
            completedBtn = itemView.findViewById(R.id.btncompleted);
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

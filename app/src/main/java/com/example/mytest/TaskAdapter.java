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
        holder.nameTextview.setText(currentTask.getTaskName());
        holder.desTextview.setText(currentTask.getTaskDescription());
        holder.dateTextview.setText(currentTask.getDate());
        ((CheckBox) holder.btncompleted).setChecked(currentTask.isCompleted());
        holder.btncompleted.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Bundle result= new Bundle();
                result.putString("date", holder.dateTextview.getText().toString());
                result.putString("description", holder.desTextview.getText().toString());
                fragmentManager.setFragmentResult("datafromall", result);
                fragmentManager.setFragmentResult("delete_task",result);
        }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
    public Task getTask(String date, String desc) {
        for(Task task : tasks){
            if(task.getTaskDescription().equals(desc) &&
                task.getDate().equals(date))
                return task;
        }
        return null;
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

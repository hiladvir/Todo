package com.example.mytest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    List<String> items;
    private SharedViewModel viewModel;
    private EditText editText;

    public ArrayList<Task> tasks;
    public TaskAdapter(ArrayList<Task>tasks){
        this.tasks= tasks;
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
        holder.btncompleted.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                viewModel.setTasks(editText.getText());


                Intent intent= new Intent(view.getContext(), Completed.class);
                intent.putExtra("taskTitle", tasks.get(position).getTaskName());
                intent.putExtra("taskDescription",tasks.get(position).getTaskDescription());
                intent.putExtra("taskDate", tasks.get(position).getDate());
            }
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
            isCompletedBoolean= itemView.findViewById(R.id.btncompleted).isOpaque();
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

package com.example.mytest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class activeFragments extends Fragment {
    private TaskAdapter taskAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("new_active_task", this, (requestKey, result) -> {
            String date = result.getString("date");
            String desc = result.getString("description");
            addTask(new Task("", desc, date, false));
        });

        getParentFragmentManager().setFragmentResultListener("delete_task", this, (requestKey, result) -> {
            String date = result.getString("date");
            String desc = result.getString("description");
            Task task = taskAdapter.getTask(date, desc);
            deleteTask(task);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_active_fragments, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerviewlist3);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Task> tasks = new ArrayList<>();
        taskAdapter = new TaskAdapter(tasks, getParentFragmentManager());
        recyclerView.setAdapter(taskAdapter);
        
        return view;
    }

    @SuppressLint("NotifyDataSetChanged")
    private void addTask(Task task) {
        taskAdapter.tasks.add(task);
        taskAdapter.notifyDataSetChanged();
    }
    @SuppressLint("NotifyDataSetChanged")
    private void deleteTask(Task task) {
        taskAdapter.tasks.remove(task);
        taskAdapter.notifyDataSetChanged();
    }
}


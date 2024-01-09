package com.example.mytest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
public class ComFragments extends Fragment {

    TaskAdapter taskAdapter;

    public ComFragments() {
        // Required empty public constructor
    }

    public static ComFragments newInstance(List<Task> tasks) {
        ComFragments fragment = new ComFragments();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_com_fragments, container, false);
        ArrayList<Task> task = new ArrayList<>();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerviewlistcom);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        taskAdapter = new TaskAdapter(task, getParentFragmentManager());
        recyclerView.setAdapter(taskAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getParentFragmentManager().setFragmentResultListener("datafromall", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                String date= result.getString("date");
                String desc= result.getString("description");
                addTask(new Task("", desc, date, true));
            }
        });
        return view;
    }

    private void addTask(Task task) {
        taskAdapter.tasks.add(task);
        taskAdapter.notifyDataSetChanged();
    }
}
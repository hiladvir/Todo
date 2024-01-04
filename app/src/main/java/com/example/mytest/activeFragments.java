package com.example.mytest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link activeFragments#newInstance} factory method to
 * create an instance of this fragment.
 */
public class activeFragments extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TaskAdapter taskAdapter;


    public activeFragments() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment activeFragments.
     */
    // TODO: Rename and change types and number of parameters
    public static activeFragments newInstance(String param1, String param2) {
        activeFragments fragment = new activeFragments();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_active_fragments, container, false);
        ArrayList<Task> tasks = new ArrayList<>();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerviewlist3);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        taskAdapter = new TaskAdapter(tasks, getParentFragmentManager());
        recyclerView.setAdapter(taskAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        taskAdapter.notifyDataSetChanged();


        getParentFragmentManager().setFragmentResultListener("new_active_task", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                String date= result.getString("date");
                String desc= result.getString("description");

                addTask(new Task("", desc, date, false));
            }
        });

        getParentFragmentManager().setFragmentResultListener("delete_task", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String date= result.getString("date");
                String desc= result.getString("description");
                Task task = taskAdapter.getTask(date, desc);
                deleteTask(task);



            }
        });
        
        return view;
    }


    private void addTask(Task task) {
        taskAdapter.tasks.add(task);
        taskAdapter.notifyDataSetChanged();
    }
    private void deleteTask(Task task) {
        taskAdapter.tasks.remove(task);
        taskAdapter.notifyDataSetChanged();
    }



}


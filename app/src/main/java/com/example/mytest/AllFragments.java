package com.example.mytest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
public class AllFragments extends Fragment implements MyDialogListener {
    TaskAdapter taskAdapter;
    public AllFragments() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void openDialog() {
        AddTaskDialog addTaskDialog = new AddTaskDialog();
        addTaskDialog.show(getChildFragmentManager(), "dialog");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_fragments, container, false);

        // setting up add button
        Button button = (Button) view.findViewById(R.id.btnadd);
        button.setOnClickListener(buttonView -> openDialog());

        // configuring recycler view
        RecyclerView recyclerView = view.findViewById(R.id.recyclerviewlist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // setting up adapter
        ArrayList<Task> tasks = new ArrayList<>();
        taskAdapter = new TaskAdapter(tasks, getParentFragmentManager());
        recyclerView.setAdapter(taskAdapter);

        return view;
    }

    @Override
    public void onDialogPositiveClick(Task data) {
        taskAdapter.tasks.add(data);
        taskAdapter.notifyDataSetChanged();

        Bundle result = new Bundle();
        result.putString("date", data.getDate());
        result.putString("description", data.getTaskDescription());
        getParentFragmentManager().setFragmentResult("new_active_task", result);
    }

    @Override
    public void onDialogNegativeClick() {

    }
    private void receiveData(){
        if(getArguments()!= null&& getArguments().containsKey("key")){
            String data= getArguments().getString("key");
        }
    }



}
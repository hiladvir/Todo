package com.example.mytest;

import android.app.Dialog;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link allFragments#newInstance} factory method to
 * create an instance of this fragment.
 */
public class allFragments extends Fragment implements MyDialogListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TaskAdapter taskAdapter;
    private SharedViewModel viewModel;

    public allFragments() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment allFragments.
     */
    // TODO: Rename and change types and number of parameters
    public static allFragments newInstance(String param1, String param2) {
        allFragments fragment = new allFragments();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

}
    public void openDialog() {
        dialog dialog = new dialog();
        dialog.show(getChildFragmentManager(), "dialog");
    }

    private FragmentManager getSupportFragmentManager() {


        return null;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle args= getArguments();
       if (args!= null){
            String value= args.getString("key", null);
        }

        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_fragments, container, false);
        ArrayList<Task> tasks = new ArrayList<>();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerviewlist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        Button button = (Button) view.findViewById(R.id.btnadd);
        button.setOnClickListener(buttonView ->
                openDialog());
        taskAdapter = new TaskAdapter(tasks);
        recyclerView.setAdapter(taskAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onDialogPositiveClick(Task data) {
        taskAdapter.tasks.add(data);
        taskAdapter.notifyDataSetChanged();
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
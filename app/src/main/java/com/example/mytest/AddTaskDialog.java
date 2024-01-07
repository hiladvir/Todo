package com.example.mytest;

import android.app.Dialog;
import android.app.Notification;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class AddTaskDialog extends AppCompatDialogFragment {

    private MyDialogListener onSaveClickListener;
    private String taskDescription;
    private String taskdate;
    private String taskName;
    private Boolean taskisCompleted;
    private Bundle bundle;
    private Notification note;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder= new AlertDialog.Builder(requireActivity());




        LayoutInflater inflater= getActivity().getLayoutInflater();
        View view= inflater.inflate(R.layout.layoutdialog,null);
        onSaveClickListener = (MyDialogListener) getParentFragment();
        builder.setView(view)
                .setTitle("הוספת משימה")
                .setNegativeButton("ביטול", (dialogInterface, i) -> {
                    onSaveClickListener.onDialogNegativeClick();
                })
                .setPositiveButton("שמירה", (dialogInterface, i) -> {
                    EditText editTextDis = view.findViewById(R.id.etdis);
                    EditText editTextDate = view.findViewById(R.id.etdate);
                    taskDescription =editTextDis.getText().toString();
                    taskdate= editTextDate.getText().toString();
                    Task task = new Task("", taskDescription, taskdate, false);
                    // get data
                    onSaveClickListener.onDialogPositiveClick(task);

                });


        EditText editTextdis = view.findViewById(R.id.etdis);
        EditText editTextdate = view.findViewById(R.id.etdate);

        //checkBox.i
        return builder.create();
    }
    private void sendDataToReceiver(String data){
        Bundle bundle= new Bundle();
        bundle.putString("task_name", taskDescription);
        bundle.putString("task_date", taskdate);
        //bundle.putString("task_date", taskdate);


        setArguments(bundle);
    }

}

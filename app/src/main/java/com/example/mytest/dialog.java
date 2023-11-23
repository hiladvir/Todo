package com.example.mytest;

import android.app.ActivityManager;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Objects;

public class dialog extends AppCompatDialogFragment {

    private MyDialogListener onSaveClickListener;
    private String taskDescription;
    private String taskdate;
    private String taskName;
    private Boolean taskisCompleted;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder= new AlertDialog.Builder(requireActivity());

        LayoutInflater inflater= getActivity().getLayoutInflater();
        View view= inflater.inflate(R.layout.layoutdialog,null);
        onSaveClickListener = (MyDialogListener) getActivity();
        builder.setView(view)
                .setTitle("Add task")
                .setNegativeButton("cancel", (dialogInterface, i) -> {
                    onSaveClickListener.onDialogNegativeClick();
                })
                .setPositiveButton("save", (dialogInterface, i) -> {
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
}
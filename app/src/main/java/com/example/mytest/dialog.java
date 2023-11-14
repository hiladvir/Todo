package com.example.mytest;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Objects;

public class dialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder= new AlertDialog.Builder(requireActivity());

        LayoutInflater inflater= getActivity().getLayoutInflater();
        View view= inflater.inflate(R.layout.layoutdialog,null);

        builder.setView(view)
                .setTitle("Add task")
                .setNegativeButton("cancel", (dialogInterface, i) -> {

                })
                .setPositiveButton("save", (dialogInterface, i) -> {

                });
        EditText editTextdis = view.findViewById(R.id.etdis);
        EditText editTextdate = view.findViewById(R.id.etdate);
        return builder.create();
    }
}

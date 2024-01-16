package com.example.mytest;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class AddTaskDialog extends AppCompatDialogFragment {
    private MyDialogListener onSaveClickListener;
    private String taskDescription;
    TextView tvDate;
    TextView tvTime;
    private Button dateBtn;
    private Button timeBtn;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder= new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater= getActivity().getLayoutInflater();
        View view= inflater.inflate(R.layout.layoutaddtaskdialog,null);
        onSaveClickListener = (MyDialogListener) getParentFragment();
        builder.setView(view)
                .setTitle("הוספת משימה")
                .setNegativeButton("ביטול", (dialogInterface, i) -> {
                    onSaveClickListener.onDialogNegativeClick();
                })
                .setPositiveButton("שמירה", (dialogInterface, i) -> {
                    EditText editTextDis = view.findViewById(R.id.etDesc);
                   TextView editTextDate = view.findViewById(R.id.tvDate);
                   TextView editTextTime = view.findViewById(R.id.tvTime);
                   taskDescription =editTextDis.getText().toString();
                   String tvDate = editTextDate.getText().toString();
                   String tvTime = editTextTime.getText().toString();
                    Task task = new Task("", taskDescription, tvDate, tvTime, false);
                    // get data
                    onSaveClickListener.onDialogPositiveClick(task);
                });
        //checkBox.i
        dateBtn = view.findViewById(R.id.dateBtn);
        tvDate = view.findViewById(R.id.tvDate);
        timeBtn = view.findViewById(R.id.timeBtn);
       tvTime = view.findViewById(R.id.tvTime);
        dateBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                openDateDialog();
            }
        });
        return builder.create();
    }
    public void openDateDialog(){
        DatePickerDialog dialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                tvDate.setText(String.valueOf(year) + "." + String.valueOf(month + 1) + "." + String.valueOf(day));
            }
        }, 2004, 12, 14);

        dialog.show();


        timeBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                openTimeDialog();
            }
        });

    }
    public void openTimeDialog(){
        TimePickerDialog dialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker timePicker, int Hour, int Minute) {
                tvTime.setText(String.valueOf(Hour)+":"+ String.valueOf(Minute));

            }
        },16, 12,false);

        dialog.show();

    };

}


package com.example.mytest;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
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

import java.util.Calendar;
import java.util.Date;

public class AddTaskDialog extends AppCompatDialogFragment {
    private MyDialogListener onSaveClickListener;
    private String taskDescription;
    TextView tvDate;
    TextView tvTime;
    private Button dateBtn;
    private Button timeBtn;

    private Date date;
    private int hour;
    private int minutes;
    private int desiredTimeMillis;


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
                    setNotificationAlarm(date,hour,minutes);
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
                date = new Date(year, month, day);
            }
        }, 2023, 12, 14);

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
            public void onTimeSet(TimePicker timePicker, int hourOnTimeSet, int minuteOnTimeSet) {
                tvTime.setText(String.valueOf(hourOnTimeSet)+":"+ String.valueOf(minuteOnTimeSet));
                hour = hourOnTimeSet;
                minutes = minuteOnTimeSet;
            }
        },16, 12,false);
        dialog.show();
    };

    public void setNotificationAlarm(Date date, int hour, int minutes) {
        AlarmManager manager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
        Calendar cal_alarm = Calendar.getInstance();

        cal_alarm.set(Calendar.YEAR, date.getYear());
        cal_alarm.set(Calendar.MONTH, date.getMonth());
        cal_alarm.set(Calendar.DAY_OF_MONTH, date.getDay());
        cal_alarm.set(Calendar.HOUR_OF_DAY, hour);
        cal_alarm.set(Calendar.MINUTE, minutes);
        cal_alarm.set(Calendar.SECOND, 0);

        Intent myIntent = new Intent(getContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 0, myIntent, PendingIntent.FLAG_MUTABLE);
        manager.set(
                AlarmManager.RTC_WAKEUP
                ,cal_alarm.getTimeInMillis()
                ,pendingIntent);
    }
}


package com.example.mytest;

import android.widget.TextView;

public class Task {
    private String taskName;
    private String taskDescription;
    private String taskDate;
    private String taskTime;
    private boolean isCompleted;

    public Task(String taskName, String taskDescription, String taskDate, String taskTime, Boolean isCompleted) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDate = taskDate;
        this.taskTime = taskTime;
        this.isCompleted  = isCompleted;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean newState) {isCompleted = newState;}

    public String getDate() {return taskDate;}
    public String getTaskTime() {return taskTime;}


}



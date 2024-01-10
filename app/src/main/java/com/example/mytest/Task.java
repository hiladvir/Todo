package com.example.mytest;

public class Task {
    private String taskName;
    private String taskDescription;
    private String taskDate;
    private boolean isCompleted;

    public Task(String taskName, String taskDescription,String taskDate, Boolean isCompleted) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDate = taskDate;
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


}



package com.example.mytest;

public class Task {
    private String taskName;
    private String taskDescription;
    private boolean isCompleted;


    public Task(String taskName, String taskDescription, String isCompleted) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.isCompleted = Boolean.parseBoolean(isCompleted);
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

    private class string {
    }
}



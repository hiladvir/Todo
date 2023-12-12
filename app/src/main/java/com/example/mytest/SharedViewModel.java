package com.example.mytest;

import android.text.Editable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Collections;
import java.util.List;

public class SharedViewModel extends ViewModel {
    private List<Task> tasks = Collections.emptyList();

    public void setTasks(CharSequence input){
       // tasks.set(input);
    }
    public List<Task> getTasks(){
        return tasks;
    }

    public void setTasks(Editable tasks) {
    }
}

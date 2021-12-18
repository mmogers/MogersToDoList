package lv.example.mogerstodolist;

import java.util.ArrayList;
import java.util.List;

public class Task {
    //Fields to model Task Object
    private int taskId;
    private boolean priority;
    private String date;
    private String task;
    private boolean isCompleted;

    //constructor


    public Task() {
    }

    //accessors and modifiers
    //modifiers
    public void setTaskId (int id){
        taskId = id;
    }

    public void setPriority(boolean p){
        priority = p;
    }

    public void setDate(String d){
        date = d;
    }

    public void setTask(String t){
        task =t;
    }

    public void setCompleted(boolean c){
        isCompleted = c;
    }
    //accessors

    public int getId(){
        return taskId;
    }

    public boolean getPriority(){
        return priority;
    }

    public String getDate(){
        return date;
    }

    public String getTaskDetails(){
        return task;
    }

    public boolean getCompleted(){
        return isCompleted;
    }

    //provides a string of a class
    public String toString(){
        String result = "";

        if (priority){
            result+= "Priority: ";
        }
        result += task + " " + date;

        return result;
    }
    //Nadejus'eto zddes'!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //Populate the list










}//end class Task

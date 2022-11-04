package app.morax.Model.Base;

import java.util.ArrayList;

// A class modeling a day which contains the tasks in the day and the details of it.
public class Day {
    private String month;
    private String day;
    private String year;

    private ArrayList<Task> taskList;

    public Day() {
        taskList = new ArrayList<>();
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void addTask(Task t) {
        this.taskList.add(t);
    }
}

package Morax.Base;

import java.util.ArrayList;

public class Category {

    private String name;
    private int priority;
    private double color;
    private int timeAlloc;
    private int timeUsed;

    private ArrayList<Task> tasks;

    public Category(String name, int priority, double color, int timeAlloc){
        this.name = name;
        this.priority = priority;
        this.color = color;
        this.timeAlloc = timeAlloc;
        this.timeUsed = 0;

        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a task to the category if there is enough remaining time
     * @param t a task object
     */
    public void addTask(Task t){
        if (!(this.timeLeft() >= t.getEstTime())) throw new IllegalArgumentException("cannot allocate enough time to task");
        this.timeUsed = this.timeUsed + t.getEstTime();
        this.tasks.add(t);
    }

    /**
     * removes the specified task
     * @param t a task object
     */
    public void removeTask(Task t){
        if (!this.hasTask(t)) return;
        this.timeUsed = this.timeUsed - t.getEstTime();
        this.tasks.remove(t);
    }

    /**
     * removes the task at index i
     * @param i an integer
     */
    public void removeTask(int i){
        if (i > this.tasks.size()) throw new IllegalArgumentException("index out of range");

        this.timeUsed = this.timeUsed - this.tasks.get(i).getEstTime();
        this.tasks.remove(i);
    }

    /**
     * A method to test if the category has a specific task
     * @param t a task object
     * @return true if the category contains the task object false otherwise
     */
    public boolean hasTask(Task t){
        for (Task task : this.tasks){
            if (task.equals(t)) return true;
        }
        return false;
    }

    /**
     * returns the remaining amount of allocated time
     * @return the remaining amount of allocated time left for tasks
     */
    public int timeLeft(){ return this.timeAlloc - this.timeUsed; }

    public String getName(){ return this.name; }
    public int getPriority(){ return this.priority; }
    public int getTimeAlloc(){ return this.timeAlloc; }
    public double getColor(){ return this.color; }
    public int getTimeUsed(){ return this.timeUsed; }
    public int getAmountTasks(){ return this.tasks.size(); }
    public ArrayList<Task> getTasks(){
        return this.tasks;
    }

    public void setName(String n){ this.name = n; }
    public void setPriority(int p){ this.priority = p; }
    public void setTimeAlloc(int t){ this.timeAlloc = t; }
    public void setColor(double c){ this.color = c; }
}

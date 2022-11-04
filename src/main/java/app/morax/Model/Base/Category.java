package app.morax.Model.Base;

import java.util.ArrayList;

public class Category {

    private String name;
    private int priority;
    private double color;
    //time allocated to the category in hours
    private int timeAlloc;
    //amount of allocated time used in hours
    private int timeUsed;

    private ArrayList<Task> taskList;

    public Category(String name, int priority, double color, int timeAlloc){
        this.name = name;
        this.priority = priority;
        this.color = color;
        this.timeAlloc = timeAlloc;
        this.timeUsed = 0;

        this.taskList = new ArrayList<Task>();
    }

    /**
     * Adds a task to the category if there is enough remaining time
     * @param t a task object
     */
    public void addTask(Task t){
        if (!(this.timeLeft() >= t.getTime())) throw new IllegalArgumentException("Cannot allocate enough time to task");
        this.timeUsed = this.timeUsed + t.getTime();
        this.taskList.add(t);
    }

    /**
     * removes the specified task
     * @param t a task object
     */
    public void removeTask(Task t){
        if (!this.hasTask(t)) return;
        this.timeUsed = this.timeUsed - t.getTime();
        this.taskList.remove(t);
    }

    /**
     * removes the task at index i
     * @param i an integer
     */
    public void removeTask(int i){
        if (i > this.taskList.size()) throw new IllegalArgumentException("index out of range");

        this.timeUsed = this.timeUsed - this.taskList.get(i).getTime();
        this.taskList.remove(i);
    }

    /**
     * A method to test if the category has a specific task
     * @param t a task object
     * @return true if the category contains the task object false otherwise
     */
    public boolean hasTask(Task t){
        for (Task task : this.taskList){
            if (task.equals(t)) return true;
        }
        return false;
    }

    /**
     * returns the remaining amount of allocated time
     * @return the remaining amount of allocated time left for tasks in hours
     */
    public int timeLeft(){ return this.timeAlloc - this.timeUsed; }

    public String getName(){ return this.name; }
    public int getPriority(){ return this.priority; }
    public int getTimeAlloc(){ return this.timeAlloc; }
    public double getColor(){ return this.color; }
    public int getTimeUsed(){ return this.timeUsed; }
    public int getAmountTasks(){ return this.taskList.size(); }
    public ArrayList<Task> getTasks(){
        return this.taskList;
    }

    public void setName(String n){ this.name = n; }
    public void setPriority(int p){ this.priority = p; }
    public void setTimeAlloc(int t){ this.timeAlloc = t; }
    public void setColor(double c){ this.color = c; }

    public String toString(){
        return this.name + "\n" +
                this.timeAlloc + "\n" +
                this.priority + "\n" +
                this.color;
    }

    public void sortTaskList(int attNum){
        int n = taskList.size();
        switch (attNum) {
            case 1:
                System.out.println("NAME\n");
                for(int i = 0; i < n; i++) {
                    for(int j = i + 1; j < n; j++) {
                        if (((taskList.get(i)).getName()).compareTo((taskList.get(i)).getName()) > 0){
                            Task temp = (taskList.get(i));
                            taskList.set(i, (taskList.get(j)));
                            taskList.set(j, temp);
                        }
                    }
                }
                break;
            case 2:
                System.out.println("LOCATION\n");
                for(int i = 0; i < n; i++) {
                    for(int j = i + 1; j < n; j++) {
                        if (((taskList.get(i)).getLocation()).compareTo((taskList.get(i)).getLocation()) > 0){
                            Task temp = (taskList.get(i));
                            taskList.set(i, (taskList.get(j)));
                            taskList.set(j, temp);
                        }
                    }
                }
                break;
            case 3:
                System.out.println("DATE\n");
                for(int i = 0; i < n; i++) {
                    for(int j = i + 1; j < n; j++) {
                        if (((taskList.get(i)).getDate()).compareTo((taskList.get(i)).getDate()) < 0){
                            Task temp = (taskList.get(i));
                            taskList.set(i, (taskList.get(j)));
                            taskList.set(j, temp);
                        }
                    }
                }
                break;
            default:
                System.out.println("Invalid Number Entered\n");
                break;
        }
    }

    //test cases
    public static void main(String[] args){
        Category c = new Category("Test", 2, 1, 30);
        int errors = 0;
        //test 1
        if (!c.getName().equals("Test")) {
            errors ++;
            System.out.println("Error in test case 1");
        }
        //test 2
        if (c.getPriority() != 2){
            errors ++;
            System.out.println("Error in test case 2");
        }
        //test 3
        if (c.getTimeAlloc() != 30){
            errors ++;
            System.out.println("Error in test case 3");
        }
        //test 4
        if (c.timeLeft() != 30){
            errors ++;
            System.out.println("Error in test case 4");
        }
        //test 5
        if (c.getTimeUsed() != 0){
            errors ++;
            System.out.println("Error in test case 5");
        }
        //test 6
        Task t = new Task("TestTask", 1);
        c.addTask(t);
        if (c.getTimeUsed() != 1){
            errors ++;
            System.out.println("Error in test case 6");
        }
        //test 7
        if (c.timeLeft() != 29){
            errors ++;
            System.out.println("Error in test case 7");
        }
        //test 8
        if (!c.getTasks().get(0).equals(t)){
            errors ++;
            System.out.println("Error in test case 8");
        }
        //test 9
        if (c.getAmountTasks() != 1){
            errors ++;
            System.out.println("Error in test case 9");
        }
        //test 10
        Task t2 = new Task("TaskTooLong", 30);
        try {c.addTask(t2);} catch (IllegalArgumentException e){
            if (!e.getMessage().equals("Cannot allocate enough time to task")){
                errors ++;
                System.out.println("Error in test case 10");
            }
        }

        System.out.println(errors + " test cases failed");
        System.out.println("Testing done");
    }
}

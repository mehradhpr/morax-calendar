
package Morax.Base;

import Morax.Tasks.Task;

import java.util.ArrayList;

/**
 * A Basic list of tasks.
 */
public class BasicTaskList
{
    /** The name of the list */
    private String name;

    /** An array list for the tasks being tracked */
    private ArrayList<Task> taskList;

    /**
     * Init BasicTaskList
     * @param listName name of list
     * @param initCap initial capacity
     * @precond listName != null, and initCap is positive integer
     */
    public BasicTaskList(String listName, int initCap)
    {
        this.name = listName;
        this.taskList = new ArrayList<Task>(initCap);
    }

    /**
     * Return name of list
     * @return the name of the list
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * set name of list
     * @param newName the name to change to
     */
    public void setName(String newName)
    {
        this.name = newName;
    }

    /**
     * add task to list
     * @param tas task to be added
     */
    public void addTask(Task tas)
    {
        this.taskList.add(tas);
    }

    /**
     * remove a task from the list
     * @param taskName name of task to remove
     */
    public void removeTask(String taskName, Task[] taskList)
    {
        for(int i = 0; i < taskList.length; i++){
            if(((taskList[i]).getName()).equals(taskName)){
                this.taskList.remove(i);
                System.out.println("Task removed.");
                return;
            }
        }
        System.out.println("Task not found. Nothing removed.");
    }

    /**
     * Return a task
     * @param taskName task to get
     */
    public Task getTask(String taskName)
    {
        for(int i = 0; i <= this.taskList.size(); i++){
            if(this.taskList.get(i).getName() == taskName){
                return this.taskList.get(i);
            }
        }
        return null;
    }

    /**
     * String of all tasks
     */
    public String getTaskList()
    {
        return this.taskList.toString();
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


}


package Morax.Base;

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
    public void removeTask(String taskName)
    {
        for(int i = 0; i <= this.taskList.size(); i++){
            if(this.taskList.get(i).getName() == taskName){
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


}

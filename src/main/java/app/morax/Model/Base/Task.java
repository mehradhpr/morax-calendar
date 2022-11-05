
package app.morax.Model.Base;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * Model for a generic task within the system
 */
public class Task {

    /** Task Name */
    private String name;
    private String location;
    private LocalDateTime date;
    
    private int time;
    private ArrayList<Category> categories;

    /**
     * Initialize a task
     *
     * @param taskName the person's name
     */
    public Task(String taskName) {
        this.name = taskName;
        this.location = null;
        this.date = null;
        this.categories = new ArrayList<Category>();
    }
    public Task(String taskName, String taskLocation) {
        this.name = taskName;
        this.location = taskLocation;
        this.date = null;
        this.categories = new ArrayList<Category>();
    }
    public Task(String taskName, LocalDateTime taskDate) {
        this.name = taskName;
        this.location = null;
        this.date = taskDate;
        this.categories = new ArrayList<Category>();
    }
    public Task(String taskName, String taskLocation, LocalDateTime taskDate) {
        this.name = taskName;
        this.location = taskLocation;
        this.date = taskDate;
        this.categories = new ArrayList<Category>();
    }

    public Task(String taskName, int time){
        this.name = taskName;
        this.time = time;
    }

    /**
     * Return task's name variable
     *
     * @return task name
     */
    public String getName() {
        return this.name;
    }
    public String getLocation() {
        return this.location;
    }
    public LocalDateTime getDate() {
        return this.date;
    }

    /**
     * Edit the name of the task
     *
     * @param newName the name to be set
     */
    public void setName(String newName) {
        this.name = newName;
    }
    public void setDate(LocalDateTime newDate) {
        this.date = newDate;
    }
    public void setLocation(String newLocation) {
        this.location = newLocation;
    }

    /**
     * Return a string of the task's information
     *
     * @return string - task info
     */
    public String toString() {
        return ("\nTask: " + this.name +
                "\nLocation: " + this.location +
                "\nDate: " + this.date + "\n");
    }

    public int getTime(){
        return this.time;
    }

    public void addCategory(Category cat){
        this.categories.add(cat);
    }
    public void removeCategory(Category cat){
        this.categories.remove(cat);
    }
}

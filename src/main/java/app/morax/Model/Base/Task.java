
package app.morax.Model.Base;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Model for a generic task within the system
 */
public class Task implements Serializable {

    /** Task Name */
    private String name;
    private String location;
    private LocalDateTime date;

    //measured in hours
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
                "\nDate: " + this.date +
                "\nCategory: " + this.categories + "\n");
    }


    public int getTime(){
        return this.time;
    }

    public void addCategory(Category cat){
        this.categories.add(cat);
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void removeCategory(Category cat){
        this.categories.remove(cat);
    }
}

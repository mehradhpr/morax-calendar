
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
    private Category category;

    /**
     * Initialize a task
     *
     * @param taskName the person's name
     */
    public Task(String taskName) {
        this.name = taskName;
        this.location = null;
        this.date = null;
    }
    public Task(String taskName, String taskLocation) {
        this.name = taskName;
        this.location = taskLocation;
        this.date = null;
    }
    public Task(String taskName, LocalDateTime taskDate) {
        this.name = taskName;
        this.location = null;
        this.date = taskDate;
    }
    public Task(String taskName, String taskLocation, LocalDateTime taskDate) {
        this.name = taskName;
        this.location = taskLocation;
        this.date = taskDate;
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
                "\nCategory: " + this.category + "\n");
    }


    public int getTime(){
        return this.time;
    }

    public void setCategory(Category cat){
        this.category = cat;
    }

    public Category getCategory() {
        return category;
    }

    public void removeCategory(Category cat){
        this.category = null;
    }

    public boolean hasCategory() {
        return category != null;
    }
}

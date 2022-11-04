
package Morax.Tasks;

import java.util.Date;

/**
 * Model for a generic task within the system
 */
public class Task {

    /** Task Name */
    private String name;
    private String location;
    private Date date;

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
    public Task(String taskName, Date taskDate) {
        this.name = taskName;
        this.location = null;
        this.date = taskDate;
    }
    public Task(String taskName, String taskLocation, Date taskDate) {
        this.name = taskName;
        this.location = taskLocation;
        this.date = taskDate;
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
    public Date getDate() {
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
    public void setDate(Date newDate) {
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
}


package Morax.Base;
/**
 * Model for a generic task within the system
 */
public class Task {

    /** Task Name */
    private String name;
    //estimated amount of time that a task will take
    private int estTime;

    /**
     * Initialize a task
     *
     * @param taskName the tasks name
     */
    public Task(String taskName) {
        this.name = taskName;
        this.estTime = 0;
    }

    /**
     * Initialize a task
     * @param taskName this name of the task
     * @param estimatedTime the estimated time that the task will take to complete
     */
    public Task(String taskName, int estimatedTime){
        this.name = taskName;
        this.estTime = estimatedTime;
    }

    /**
     * Return task's name variable
     *
     * @return task name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Edit the name of the task
     *
     * @param newName the name to be set
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Return a string of the task's information
     *
     * @return string - task info
     */
    public String toString() {
        return ("\nTask: " + this.name + "\n");
    }

    public void setEstTime(int estimatedTime){ this.estTime = estimatedTime; }
    public int getEstTime(){ return this.estTime; }
}

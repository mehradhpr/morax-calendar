
package Morax.Tasks;
/**
 * Model for a generic task within the system
 */
public class Task {

    /** Task Name */
    private String name;

    /**
     * Initialize a task
     *
     * @param taskName the person's name
     */
    public Task(String taskName) {
        this.name = taskName;
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
}

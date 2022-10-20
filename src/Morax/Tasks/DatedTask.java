
package Morax.Tasks;

import java.util.*;

/**
 * Extends Task into Deadline type
 */
public class DatedTask extends Task {

    /** Date variables */
    private Date taskDate;

    /**
     * Initialize an appointment task
     * @param name  name of appointment
     * @param date  date of appointment (form: YYYY, MM, DD, HR, MN)
     */
    public DatedTask(String name, Calendar date) {
        super(name);
        this.taskDate = date.getTime();
    }

    /**
     * Return date of deadline
     *
     * @return date
     */
    public Date getDate() {
        return this.taskDate;
    }

    /**
     * Change date of deadline
     *
     * @param newDate date to change to
     */
    public void setDate(Date newDate){
        this.taskDate = newDate;
    }
}


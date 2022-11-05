
package Morax.Tasks;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Extends Task into Deadline type
 */
public class DatedTask extends Task {

    /** Date variables */
    private LocalDateTime taskDate;

    /**
     * Initialize an appointment task
     * @param name  name of appointment
     * @param date  date of appointment (form: YYYY, MM, DD, HR, MN)
     */
    public DatedTask(String name, LocalDateTime date) {
        super(name);
        this.taskDate = date;
    }

    /**
     * Return date of deadline
     *
     * @return date
     */
    public LocalDateTime getDate() {
        return this.taskDate;
    }

    /**
     * Change date of deadline
     *
     * @param newDate date to change to
     */
    public void setDate(LocalDateTime newDate){
        this.taskDate = newDate;
    }
}


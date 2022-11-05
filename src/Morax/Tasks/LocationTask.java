
package Morax.Tasks;

import Morax.Base.Person;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Extends Task into Appointment type
 */
public class LocationTask extends DatedTask {

    /** location of appointment */
    private String appointmentLocation;

    /**
     * Initialize an appointment task
     * @param name  name of appointment
     * @param date  date of appointment (form: YYYY, MM, DD, HR, MN)
     * @param location place of appointment, or n/a
     */
    public LocationTask(String name, LocalDateTime date, String location) {
        super(name, date);
        this.appointmentLocation = location;
    }

    /**
     * Return location
     *
     * @return location
     */
    public String getLocation() {
        return this.appointmentLocation;
    }

    /**
     * Change location of appointment
     *
     * @param newLocation location to change to
     */
    public void setLocation(String newLocation){
        this.appointmentLocation = newLocation;
    }
}

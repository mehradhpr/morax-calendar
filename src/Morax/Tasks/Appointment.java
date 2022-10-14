
package Morax.Tasks;

import Morax.Base.Person;
import Morax.Base.Task;

import java.util.*;

/**
 * Extends Task into Appointment type
 */
public class Appointment extends DatedTask {

    /** Date variables */
    private Date appointmentDate;
    /** list of other people at this appointment */
    private LinkedList<Person> appointmentPeople ;
    /** location of appointment */
    private String appointmentLocation;

    /**
     * Initialize an appointment task
     * @param name  name of appointment
     * @param date  date of appointment (form: YYYY, MM, DD, HR, MN)
     * @param location place of appointment, or n/a
     */
    public Appointment(String name, Calendar date, String location) {
        super(name, date);
        this.appointmentLocation = location;
        appointmentPeople = new LinkedList<>();
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

    /**
     * Add a person attending the appointment
     *
     * @param pers new person being added
     */
    public void addPerson(Person pers){
        this.appointmentPeople.addLast(pers);
    }

    /**
     * Remove a person from the appointment
     *
     * @param personName person being removed
     */
    public void removePerson(String personName){
        boolean done = false;
        ListIterator<Person> iter= this.appointmentPeople.listIterator();
        while (iter.hasNext() && !done){
            if (iter.next().getName().equals(personName)){
                iter.remove();
                done = true;
            }
        }
    }
}

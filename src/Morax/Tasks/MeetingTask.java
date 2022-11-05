
package Morax.Tasks;

import Morax.Base.Person;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Extends Task into Appointment type
 */
public class MeetingTask extends LocationTask {

    /** list of other people at this appointment */
    private LinkedList<Person> appointmentPeople ;

    /**
     * Initialize an appointment task
     * @param name  name of appointment
     * @param date  date of appointment (form: YYYY, MM, DD, HR, MN)
     * @param location place of appointment, or n/a
     */
    public MeetingTask(String name, LocalDateTime date, String location) {
        super(name, date, location);
        appointmentPeople = new LinkedList<>();
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

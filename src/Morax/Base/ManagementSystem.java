
package Morax.Base;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * The system to access taskList through
 */
public class ManagementSystem {

    /** the taskList */
    private BasicTaskList taskList;
    /** list of people */
    private TreeMap<String, Person> personMap;

    /**
     * Initialize an instance of StudentResidenceSystem
     *
     * @param listName  the name of the residence
     * @param initialCap the initial capacity of the arrayList
     * @precond lastName != null
     */
    public ManagementSystem(String listName, int initialCap){
        this.taskList = new BasicTaskList(listName, initialCap);
        personMap = new TreeMap<>();
    }

    /**
     * add task to list
     * @param taskName task to add
     */
    public void addTask(String taskName)
    {
        return;
    }

    /**
     * Remove task from list
     */
    public void removeTask()
    {
        return;
    }

    /**
     * add person to system
     */
    public void addPerson()
    {
        return;
    }

    /**
     * Remove person from system
     */
    public void removePerson()
    {
        return;
    }

    /**
     * add a person to a task
     */
    public void addTaskPerson()
    {
        return;
    }

    /**
     * Remove person from task
     */
    public void removeTaskPerson()
    {
        return;
    }

    /**
     * Print the current state of the system
     */
    public void systemState()
    {
        return;
    }

    /**
     * UI (as of now lol)
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        try {
            int[] newt = {1,2,3};
            for (int i = 0; i < newt.length; i++){
                System.out.print(newt[i] + " ");
            }
            System.out.print("\n");
            newt[3] = 4;
            newt = Arrays.copyOf(newt, newt.length +1);
            newt[3] = 4;
            for (int i = 0; i < newt.length; i++){
                System.out.print(newt[i] + " ");
            }
            System.out.print("\n");

            System.out.print("List Name: ");
            String listName = in.next();
            String junk = in.nextLine();
            System.out.print("Initial Capacity: ");
            int initC = in.nextInt();
            junk = in.nextLine();
            ManagementSystem Morax = new ManagementSystem(listName, initC);

            int tFunction = 0;
            while (tFunction != 1) {
                try {
                    System.out.print("OPTIONS:\n" +
                            "1. Close System\n" +
                            "2. Add Task\n" +
                            "3. Remove Task\n" +
                            "4. Add Person\n" +
                            "5. Remove Person\n" +
                            "6. Add Person to Task\n" +
                            "7. Remove Person from Task\n" +
                            "8. Print System State\n" +
                            "Choose an option (type 1-8): ");
                    tFunction = in.nextInt();
                    junk = in.nextLine();
                    switch (tFunction) {
                        case 1:
                            System.out.println("Closing System");
                            break;
                        case 2:
                            System.out.println("NOT IMPLEMENTED YET");
                            break;
                        case 3:
                            System.out.println("NOT IMPLEMENTED YET");
                            break;
                        case 4:
                            System.out.println("NOT IMPLEMENTED YET");
                            break;
                        case 5:
                            System.out.println("NOT IMPLEMENTED YET");
                            break;
                        case 6:
                            System.out.println("NOT IMPLEMENTED YET");
                            break;
                        case 7:
                            System.out.println("NOT IMPLEMENTED YET");
                            break;
                        case 8:
                            System.out.println("NOT IMPLEMENTED YET");
                            break;
                        default:
                            System.out.println("Invalid Number Entered");
                            break;
                    }
                } catch (InputMismatchException exception) {
                    System.out.println("Invalid input Entered");
                }
            }
        }
        catch(IllegalArgumentException exception){
            System.out.println("IllegalArgument Entered");
        }
        catch(InputMismatchException exception){
            System.out.println("InputMismatch Entered");
        }
    }
}


package Morax.Base;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * The system to access taskList through
 */
public class ManagementSystem {

    /** the taskList */
    private ArrayList<Category> taskList;

    /** list of people */
    private TreeMap<String, Person> people;

    /** list of subscribers to notify when the model has changed **/
    private ArrayList<ModelListener> subscribers;

    /**
     * Initialize an instance of ManagementSystem
     */
    public ManagementSystem(){
        this.taskList = new ArrayList<>();
        //this is the default category that tasks are put into
        this.taskList.add(new Category("UnCategorized", 0, 0, 100));

        this.people = new TreeMap<>();
        this.subscribers = new ArrayList<>();
    }

    /**
     * add task to list
     * @param t task to add
     */
    public void addTask(Task t)
    {
        this.taskList.get(0).addTask(t);
    }

    public void addTask(Task t, Category c) throws IllegalArgumentException{
        if (!this.categoryExists(c)) throw new IllegalArgumentException("Category: " + c.getName() + " does not exist");

        for (Category category : taskList){
            if (category.getName().equals(c.getName())) category.addTask(t);
        }
    }

    /**
     * Checks if a category exists
     * @param c a category object
     * @return true if the category exists in ManagementSystem false otherwise
     */
    public boolean categoryExists(Category c){
        return this.taskList.contains(c);
    }
    /**
     * Remove task from list
     */
    public void removeTask(Task t)
    {
        for (Category c : taskList){
            c.removeTask(t);
        }
    }

    /**
     * add person to system
     */
    public void addPerson(Person p)
    {
        this.people.put(p.getName(), p);
    }

    /**
     * Remove person from system
     */
    public void removePerson(Person p)
    {
        this.people.remove(p.getName());
    }

    /**
     * add a person to a task
     */
    public void addTaskPerson(Person p, Task t)
    {
        p.addTask(t);
    }

    /**
     * Remove person from task
     */
    public void removeTaskPerson(Person p, Task t)
    {
        p.removeTask(t.getName());
    }

    /**
     * Print the current state of the system
     */
    public void systemState()
    {
    }

    /**
     * add a subsciber to the model so that we may update them when the model changes
     * @param s a subscriber to the model
     */
    public void addSubscriber(ModelListener s) { this.subscribers.add(s);}

    /**
     * update subscribers
     */
    public void updateSubscribers(){
        for (ModelListener s : this.subscribers){
            s.modelChanged();
        }
    }


    public ArrayList<Task> getTasks(){
        ArrayList<Task> out = new ArrayList<>();
        for (Category c : taskList){
            out.addAll(c.getTasks());
        }
        return out;
    }

    public ArrayList<Category> getCategories(){
        return this.taskList;
    }

    public void addCategory(Category c){
        if (this.categoryExists(c)) throw new IllegalArgumentException("Category already exists");

        this.taskList.add(c);
    }

    public void removeCategory(Category c)
    {
        removeCategory(c, true);
    }

    private void removeCategory(Category c, boolean safe)
    {
        if (safe){
            for (Task t : c.getTasks()){
                this.taskList.get(0).addTask(t);
            }
        }
        this.taskList.remove(c);
    }
    /**
     * UI (as of now lol)
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("List Name: ");
            String listName = in.next();
            in.nextLine();
            System.out.print("Initial Capacity: ");
            int initC = in.nextInt();
            in.nextLine();
            ManagementSystem Morax = new ManagementSystem();

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
                    in.nextLine();
                    switch (tFunction) {
                        case 1:
                            System.out.println("Closing System");
                            break;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
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


package app.morax.Model.Base;

import app.morax.Interface.ModelListener;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * The system to access taskList through
 */
public class MainModel {

    /** the taskList */
    private ArrayList<Category> taskList;

    /** list of people */
    private TreeMap<String, Person> people;

    /** list of subscribers to notify when the model has changed **/
    private ArrayList<ModelListener> subscribers;

    /**
     * Initialize an instance of ManagementSystem
     */
    public MainModel(){
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
        updateSubscribers();
    }

    public void addTask(Task t, Category c) throws IllegalArgumentException{
        if (!this.categoryExists(c)) throw new IllegalArgumentException("Category: " + c.getName() + " does not exist");

        for (Category category : taskList){
            if (category.getName().equals(c.getName())) category.addTask(t);
        }

        updateSubscribers();
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
            s.update();
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
        ArrayList<Category> c = new ArrayList<>();
        for (int i = 1; i < taskList.size(); i++){
            c.add(this.taskList.get(i));
        }

        return c;
    }

    public void addCategory(Category c){
        if (this.categoryExists(c)) throw new IllegalArgumentException("Category already exists");

        this.taskList.add(c);
        updateSubscribers();
    }

    public void removeCategory(Category c)
    {
        removeCategory(c, true);
        updateSubscribers();
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
        MainModel model = new MainModel();
        int errors = 0;
        //test case 1
        if (model.taskList.get(0) == null){
            System.out.println("Error in test case 1");
            errors ++;
        }
        //test case 2
        Category c1 = new Category("Blue", 1, 2, 3);
        model.addCategory(c1);
        if (!model.taskList.get(1).equals(c1)){
            System.out.println("Error in test case 2");
            errors ++;
        }
        //test case 3
        if (!model.getCategories().contains(c1)){
            System.out.println("Error in test case 3");
            errors ++;
        }
        //test case 4
        Task t1 = new Task("hello");
        model.addTask(t1);
        if (model.getTasks().size() != 1){
            System.out.println("Error in test case 4");
            errors ++;
        }
        //test case 5
        if (!model.getTasks().get(0).equals(t1)){
            System.out.println("Error in test case 5");
            errors ++;
        }
        //test case 6
        if (model.getCategories().get(0).getTasks().size() != 0){
            System.out.println("Error in test case 6");
            errors ++;
        }
        //test case 7
        model.removeCategory(c1);
        if (model.getCategories().contains(c1)){
            System.out.println("Error in test case 7");
            errors ++;
        }

        System.out.println(errors + " test cases failed\nTesting Complete.");
    }

    public ArrayList<Task> sortTaskList(int attNum){
        ArrayList<Task> tasks = new ArrayList<>(this.getTasks());
        int n = this.getTasks().size();
        switch (attNum) {
            case 1:
                System.out.println("NAME\n");
                for(int i = 0; i < n; i++) {
                    for(int j = i + 1; j < n; j++) {
                        if (((tasks.get(i)).getName()).compareTo((tasks.get(i)).getName()) > 0){
                            Task temp = (tasks.get(i));
                            tasks.set(i, (tasks.get(j)));
                            tasks.set(j, temp);
                        }
                    }
                }
                break;
            case 2:
                System.out.println("LOCATION\n");
                for(int i = 0; i < n; i++) {
                    for(int j = i + 1; j < n; j++) {
                        if (((tasks.get(i)).getLocation()).compareTo((tasks.get(i)).getLocation()) > 0){
                            Task temp = (tasks.get(i));
                            tasks.set(i, (tasks.get(j)));
                            tasks.set(j, temp);
                        }
                    }
                }
                break;
            case 3:
                System.out.println("DATE\n");
                for(int i = 0; i < n; i++) {
                    for(int j = i + 1; j < n; j++) {
                        if (((tasks.get(i)).getDate()).compareTo((tasks.get(i)).getDate()) < 0){
                            Task temp = (tasks.get(i));
                            tasks.set(i, (tasks.get(j)));
                            tasks.set(j, temp);
                        }
                    }
                }
                break;
            default:
                System.out.println("Invalid Number Entered\n");
                break;
        }

        return tasks;
    }
}

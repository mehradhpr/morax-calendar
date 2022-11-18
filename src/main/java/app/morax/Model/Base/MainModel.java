
package app.morax.Model.Base;

import app.morax.Interface.ModelListener;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * The system to access taskList through
 */
public class MainModel implements Serializable {

    /** the taskList */
    private ArrayList<Category> taskList;

    // a list of finished tasks
    private Category finishedTasks;

    /** list of people */
    private TreeMap<String, Person> people;

    //is transient because we do NOT want to save it
    /** list of subscribers to notify when the model has changed **/
    private transient ArrayList<ModelListener> subscribers;

    /**
     * Initialize an instance of ManagementSystem
     */
    public MainModel(){
        this.taskList = new ArrayList<>();
        //this is the default category that tasks are put into
        this.taskList.add(new Category("UnCategorized", 0, 0, 100));

        this.people = new TreeMap<>();
        this.subscribers = new ArrayList<>();
        this.addCategory(new Category("Work", 1, 1, 20));

        this.finishedTasks = new Category("Finished", 0, 0, -1);
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
     * TODO
     * add person to system
     */
    public void addPerson(Person p)
    {
        this.people.put(p.getName(), p);
    }

    /**
     * TODO
     * Remove person from system
     */
    public void removePerson(Person p)
    {
        this.people.remove(p.getName());
    }

    /**
     * TODO
     * add a person to a task
     */
    public void addTaskPerson(Person p, Task t)
    {
        p.addTask(t);
    }

    /**
     * TODO
     * Remove person from task
     */
    public void removeTaskPerson(Person p, Task t)
    {
        p.removeTask(t.getName());
    }

    /**
     * TODO
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

    /**
     * returns a list of all tasks
     * @return a list of tasks
     */
    public ArrayList<Task> getTasks(){
        ArrayList<Task> out = new ArrayList<>();
        for (Category c : taskList){
            out.addAll(c.getTasks());
        }
        return out;
    }

    /**
     * returns a list of the categories that the system contains
     * @return a list of categories
     */
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

    /**
     * Removes a category from the system
     * @param c the category to be removed
     */
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
        if (!model.taskList.get(2).equals(c1)){
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
        //test case 8
        if (model.categoryExists(c1)){
            System.out.println("Error in test case 8");
            errors ++;
        }
        //test case 9
        model.addCategory(c1);
        if (!model.categoryExists(c1)){
            System.out.println("Error in test case 9");
            errors ++;
        }
        //test case 10
        Task t2 = new Task("test2");
        model.addTask(t2, c1);
        if (!c1.getTasks().contains(t2)){
            System.out.println("Error in test case 10");
            errors ++;
        }
        //test case 11
        try{
            model.addCategory(c1);
            errors++;
            System.out.println("Error in test case 11");
        }catch (IllegalArgumentException ignored){}

        //Test saving to and loading from a file
        model.saveToFile("testSave");
        model = MainModel.loadFromFile("testSave");

        //test case 12
        if (model.taskList.size() != 3){
            System.out.println("Error in test case 12");
            errors ++;
        }
        //test case 13
        if (model.taskList.get(2).getTasks().size() != 1){
            System.out.println("Error in test case 13");
            errors ++;
        }

        //test case 14
        if (model.getTasks().size() != 2){
            System.out.println("Error in test case 14");
            errors ++;
        }

        System.out.println(errors + " test cases failed\nTesting Complete.");
    }

    //Jordan's code that I uploaded
    public ArrayList<Task> sortTaskList(int attNum){
        ArrayList<Task> tasks = this.getTasks();
        int n = tasks.size();
        switch (attNum) {
            case 0:
                for(int i = 0; i < n; i++) {
                    for(int j = i + 1; j < n; j++) {
                        if (((tasks.get(i)).getName()).compareTo((tasks.get(j)).getName()) > 0){
                            Task temp = (tasks.get(i));
                            tasks.set(i, (tasks.get(j)));
                            tasks.set(j, temp);
                        }
                    }
                }
                break;
            case 1:
                String zString = "zzzzzzzzzzzzzzzzzzzzzzzz";
                for(int i = 0; i < n; i++) {
                    for(int j = i + 1; j < n; j++) {
                        if((((tasks.get(i)).getLocation()) != null) && (((tasks.get(j)).getLocation()) != null)) {
                            if (((tasks.get(i)).getLocation()).compareTo((tasks.get(j)).getLocation()) > 0) {
                                Task temp = (tasks.get(i));
                                tasks.set(i, (tasks.get(j)));
                                tasks.set(j, temp);
                            }
                        }
                        else if((((tasks.get(i)).getLocation()) == null) && (((tasks.get(j)).getLocation()) != null)) {
                            if (zString.compareTo((tasks.get(j)).getLocation()) > 0) {
                                Task temp = (tasks.get(i));
                                tasks.set(i, (tasks.get(j)));
                                tasks.set(j, temp);
                            }
                        }
                        else if((((tasks.get(i)).getLocation()) != null) && (((tasks.get(j)).getLocation()) == null)) {
                            if (((tasks.get(i)).getLocation()).compareTo(zString) > 0){
                                Task temp = (tasks.get(i));
                                tasks.set(i, (tasks.get(j)));
                                tasks.set(j, temp);
                            }
                        }
                        else{
                            Task temp = (tasks.get(i));
                            tasks.set(i, (tasks.get(j)));
                            tasks.set(j, temp);
                        }
                    }
                }
                break;
            case 2:
                LocalDateTime lateDate = LocalDateTime.of(9999, 12, 30, 23, 59);
                for(int i = 0; i < n; i++) {
                    for(int j = i + 1; j < n; j++) {
                        if((((tasks.get(i)).getDate()) != null) && (((tasks.get(j)).getDate()) != null)) {
                            tasks.get(i).getDate().getYear();
                            if (((tasks.get(i)).getDate()).isAfter(tasks.get(j).getDate())) {
                                Task temp = (tasks.get(i));
                                tasks.set(i, (tasks.get(j)));
                                tasks.set(j, temp);
                            }
                        }
                        else if((((tasks.get(i)).getDate()) == null) && (((tasks.get(j)).getDate()) != null)) {
                            if (lateDate.isAfter(tasks.get(j).getDate())){
                                Task temp = (tasks.get(i));
                                tasks.set(i, (tasks.get(j)));
                                tasks.set(j, temp);
                            }
                        }
                        else if((((tasks.get(i)).getDate()) != null) && (((tasks.get(j)).getDate()) == null)) {
                            if (((tasks.get(i)).getDate()).isAfter(lateDate)) {
                                Task temp = (tasks.get(i));
                                tasks.set(i, (tasks.get(j)));
                                tasks.set(j, temp);
                            }
                        }
                        else{
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

    /**
     * Called to move a task move the active tasks list to the finished tasks list
     * @param t
     */
    public void taskComplete(Task t){
        Category c;
        while (t.getCategories().size() > 0){
            c = t.getCategories().get(0);

            c.removeTask(t);
            t.removeCategory(c);
        }

        this.finishedTasks.addTask(t);
    }

    /**
     * reads data from a file to create a new MainModel object
     * @param path the files path
     * @return a mainModel object
     */
    public static MainModel loadFromFile(String path){
        MainModel fromDisk = null;

        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(file);
            fromDisk = (MainModel) objectIn.readObject();
            file.close();
            objectIn.close();

            //we do not save the subscribers list, so we need to initialize it
            fromDisk.subscribers = new ArrayList<>();

            System.out.println("The Object has successfully been read");
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        return fromDisk;
    }

    /**
     * Saves this object to a file
     * @param path the files path
     */
    public void saveToFile(String path){

        try {
            FileOutputStream file = new FileOutputStream(path, false);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(this);
            out.close();
            file.close();
            System.out.println("The Object  was successfully written");
        }
        catch (Exception e){
            System.out.println(e.toString());
        };
    }

}

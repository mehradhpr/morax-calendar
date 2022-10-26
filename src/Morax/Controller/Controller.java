package Morax.Controller;

import Morax.Base.ManagementSystem;

import java.awt.event.ActionEvent;

public class Controller {
    private ManagementSystem model;

    private Controller instance;

    private Controller() { }

    public Controller getInstance(){
        if (instance == null) instance = new Controller();
        return instance;
    }

    public void setModel(ManagementSystem m) { this.model = m;}

    public void createPerson(ActionEvent e)
    {

    }

    public void removePerson()
    {

    }

    public void addTask(){

    }
}

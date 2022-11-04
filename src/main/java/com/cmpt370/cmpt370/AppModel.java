package com.cmpt370.cmpt370;

import com.cmpt370.cmpt370.Base.ManagementSystem;

import java.util.ArrayList;

public class AppModel extends ManagementSystem {
    private ArrayList<ModelListener> subscribers;
    AppModel() {
        super();
    }



    public void addSubscribers(ModelListener sub) {
        subscribers.add(sub);
    }

    public void notifySubscribers() {
        for (ModelListener sub : subscribers) {
            sub.update();
        }
    }
}

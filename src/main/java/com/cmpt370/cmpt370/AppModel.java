package com.cmpt370.cmpt370;

import java.util.ArrayList;

public class AppModel {
    private ArrayList<ModelListener> subscribers;
    AppModel() {}



    public void addSubscribers(ModelListener sub) {
        subscribers.add(sub);
    }

    public void notifySubscribers() {
        for (ModelListener sub : subscribers) {
            sub.update();
        }
    }
}

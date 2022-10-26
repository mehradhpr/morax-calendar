package com.cmpt370.cmpt370;

public interface ModelListener {
    void update();
    void setModel(AppModel model);
    void associateHandler(Controller controller);
}

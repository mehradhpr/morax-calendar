package app.morax.Interface;

import app.morax.Model.Base.MainModel;

public interface Controller {
    void setModel(MainModel model);

    void setView(ModelListener view);
}

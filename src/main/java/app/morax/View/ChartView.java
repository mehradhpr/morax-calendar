package app.morax.View;

import app.morax.Interface.ModelListener;
import app.morax.Model.Base.Category;
import app.morax.Model.Base.MainModel;
import app.morax.Model.Base.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import java.time.LocalDateTime;

public class ChartView  extends StackPane implements ModelListener {

    private MainModel model;
    private final BarChart<String, Number> chart;
    private final ObservableList<String> dates;

    public ChartView(){
        //creating a chart

        //dates that the chart has
        dates = FXCollections.observableArrayList();

        //populate the list with the last fourteen days
        LocalDateTime now = LocalDateTime.now();
        for (int d = 13; d >= 0; d--){
            LocalDateTime day = now.minusDays(d);
            dates.add(day.getMonth().toString() + " " + day.getDayOfMonth());
        }

        //setup xAxis
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(dates);
        xAxis.setLabel("Date");

        //setup yAxis of the chart
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Number of Tasks");

        //setup chart
        chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Tasks Complete");

        this.getChildren().add(chart);
    }

    @Override
    public void update() {
        //reset the chart data
        chart.getData().clear();

        //make new data for the chart
        //the tasks completed on that day
        int tasksComplete;
        XYChart.Series<String, Number> data;

        for (Category c:model.getCategories()){

            data = new XYChart.Series<>();
            data.setName(c.getName());

            //check how many tasks were completed each day for this category
            for (String date: dates){

                tasksComplete = 0;

                for (Task t:model.getFinishedTasks()){
                    String taskDate = t.getDate().getMonth() + " " + t.getDate().getDayOfMonth();
                    if (t.getCategory().getName().equals(c.getName()) && taskDate.equals(date)) tasksComplete ++;
                }

                data.getData().add(new XYChart.Data<>(date, tasksComplete));
            }

            chart.getData().add(data);
        }
    }

    @Override
    public void setModel(MainModel model) {
        this.model = model;
        this.update();
    }
}

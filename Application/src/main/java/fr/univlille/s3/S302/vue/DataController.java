package fr.univlille.s3.S302.vue;

import fr.univlille.s3.S302.model.*;
import javafx.fxml.FXML;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tooltip;
import javafx.util.Pair;


import java.util.Map;
import java.util.Objects;

public class DataController {


    @FXML
    ScatterChart<String , Number> chart;

    Map<Coordonnee, Iris> data;

    DataManager<Data> dataManager = new DataManager<>();

    @FXML
    public void initialize() {
        chart.setTitle("Scatter Chart");
        dataManager.loadData("iris.csv");


        // set limit to the chart dynamicaly
        chart.getXAxis().setAutoRanging(true);
        chart.getYAxis().setAutoRanging(true);
        chart.setAnimated(false);

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        for (Data f : dataManager.getDataList()) {
            Pair<String, Number> choosenAttributes = f.getChoosenAttributes();
            //Coordonnee c = new Coordonnee(choosenAttributes.getKey(), choosenAttributes.getValue());
            System.out.println(choosenAttributes.getKey() + " " + choosenAttributes.getValue());
            series.getData().add(new XYChart.Data<>(choosenAttributes.getKey(), choosenAttributes.getValue()));


        }
        chart.getData().add(series);

        for (final XYChart.Series<String, Number> s : chart.getData()) {
            for (final XYChart.Data<String, Number> data : s.getData()) {
                Tooltip tooltip = new Tooltip();
                tooltip.setText(data.getXValue() + " : " + data.getYValue());
                tooltip.setShowDuration(javafx.util.Duration.seconds(10));
                tooltip.setShowDelay(javafx.util.Duration.seconds(0));
                Tooltip.install(data.getNode(), tooltip);
            }
        }

    }

}

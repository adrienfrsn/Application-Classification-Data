package fr.univlille.s3.S302.vue;

import fr.univlille.s3.S302.model.*;
import javafx.fxml.FXML;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.util.Pair;


import java.util.Map;
import java.util.Objects;

public class DataController {


    @FXML
    ScatterChart<?, ?> chart;

    Map<Coordonnee, Iris> data;

    DataManager<Data> dataManager = new DataManager<>();

    @FXML
    public void initialize() {
        chart.setTitle("Scatter Chart");
        dataManager.loadData("iris.csv");
        XYChart.Series series = new XYChart.Series<>();

        for (Data f : dataManager.getDataList()) {
            Pair<?, ?> choosenAttributes = f.getChoosenAttributes();
            //Coordonnee c = new Coordonnee(choosenAttributes.getKey(), choosenAttributes.getValue());
            System.out.println(choosenAttributes.getKey() + " " + choosenAttributes.getValue());
            series.getData().add(new XYChart.Data<>(choosenAttributes.getKey(), choosenAttributes.getValue()));
        }
        chart.getData().add(series);

    }

}

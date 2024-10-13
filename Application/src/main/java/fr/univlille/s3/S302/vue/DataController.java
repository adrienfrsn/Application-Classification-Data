package fr.univlille.s3.S302.vue;

import fr.univlille.s3.S302.model.Coordonnee;
import fr.univlille.s3.S302.model.DataManager;
import fr.univlille.s3.S302.model.FormatDonneeBrut;
import fr.univlille.s3.S302.model.Iris;
import javafx.fxml.FXML;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;


import java.util.Map;

public class DataController {


    @FXML
    ScatterChart<?, ?> chart;

    Map<Coordonnee, Iris> data;

    DataManager<FormatDonneeBrut> dataManager = new DataManager<>();

    @FXML
    public void initialize() {
        chart.setTitle("Scatter Chart");
        dataManager.loadData("iris.csv");
        XYChart.Series series = new XYChart.Series<>();

        for (FormatDonneeBrut f : dataManager.getDataList()) {
            Coordonnee c = new Coordonnee(f.getSepalLength(), f.getSepalWidth());
            //data.put(c, new Iris(f.getSpecies()));
            series.getData().add(new XYChart.Data<>(c.getX()+"", c.getY()));
        }
        chart.getData().add(series);

    }

}

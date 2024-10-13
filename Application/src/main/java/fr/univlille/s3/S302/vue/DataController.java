package fr.univlille.s3.S302.vue;

import fr.univlille.s3.S302.model.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tooltip;
import javafx.util.Pair;


import java.util.*;

public class DataController {


    @FXML
    ScatterChart<String , Number> chart;

    List<Pair<XYChart.Data<String, Number>, Data>> data ;

    private Map<String, String> categorieColor = new HashMap<>();

    DataManager<Data> dataManager = new DataManager<>();

    @FXML
    public void initialize() {
        data = new ArrayList<>();
        categorieColor.put("Unknown", "black");

        chart.setTitle("Scatter Chart");
        dataManager.loadData("iris.csv");


        // set limit to the chart dynamicaly
        chart.getXAxis().setAutoRanging(true);
        chart.getYAxis().setAutoRanging(true);
        chart.setAnimated(false);

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        for (Data f : dataManager.getDataList()) {
            Pair<String, Number> choosenAttributes = f.getChoosenAttributes();
            Coordonnee c = new Coordonnee(Double.parseDouble(choosenAttributes.getKey()), choosenAttributes.getValue().doubleValue());
            XYChart.Data<String , Number> node = new XYChart.Data<>(choosenAttributes.getKey(), choosenAttributes.getValue());
            data.add(new Pair<>(node, f));
            series.getData().add(node);
        }
        chart.getData().add(series);

        for (final XYChart.Series<String, Number> s : chart.getData()) {
            for (final XYChart.Data<String, Number> data : s.getData()) {
                Data d = getNode(data);
                Tooltip tooltip = new Tooltip();
                tooltip.setText(d.getCategory() + "\n" + data.getXValue() + " : " + data.getYValue());
                tooltip.setShowDuration(javafx.util.Duration.seconds(10));
                tooltip.setShowDelay(javafx.util.Duration.seconds(0));
                Tooltip.install(data.getNode(), tooltip);
                data.getNode().setOnMouseEntered(event -> {
                    data.getNode().setScaleX(1.5);
                    data.getNode().setScaleY(1.5);
                });
                data.getNode().setOnMouseExited(event -> {
                    data.getNode().setScaleX(1);
                    data.getNode().setScaleY(1);
                });

                setNodeColor(data.getNode(), d.getCategory());

            }
        }



    }

    private Data getNode(XYChart.Data<String, Number> data) {
        for (Pair<XYChart.Data<String, Number>, Data> d : this.data) {
            if (d.getKey() == data) {
                return d.getValue();
            }
        }
        return null;
    }

    public void setNodeColor(Node node, String category) {
        if (node == null) {
            return;
        }
        if (!categorieColor.containsKey(category)) {
            String color = "rgb(" + (int) (Math.random() * 256) + "," + (int) (Math.random() * 256) + "," + (int) (Math.random() * 256) + ")";
            categorieColor.put(category, color);
        }

        node.setStyle("-fx-background-color: " + categorieColor.get(category) + ";");
    }

}

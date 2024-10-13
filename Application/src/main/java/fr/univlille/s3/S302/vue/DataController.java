package fr.univlille.s3.S302.vue;

import fr.univlille.s3.S302.model.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;
import javafx.util.Pair;


import java.util.*;

public class DataController {


    @FXML
    ScatterChart<String , Number> chart;
    
    @FXML
    ComboBox<String> xCategory;
    
    @FXML
    ComboBox<String> yCategory;

    @FXML
    private Button categoryBtn;

    List<Pair<XYChart.Data<String, Number>, Data>> data ;

    private Map<String, String> categorieColor = new HashMap<>();

    DataManager<Data> dataManager = new DataManager<>();

    @FXML
    public void initialize() {
        data = new ArrayList<>();
        categorieColor.put("Unknown", "black");

        chart.setTitle("Scatter Chart");
        dataManager.loadData("iris.csv");

        chart.getXAxis().setAutoRanging(true);
        chart.getYAxis().setAutoRanging(true);
        chart.setAnimated(false);

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        constructChart(series);

        setChartStyle();

        updateCategories();

        xCategory.setUserData(xCategory.getItems().get(0));
        yCategory.setUserData(yCategory.getItems().get(1));

        categoryBtn.setOnAction(event -> {
            for (Pair<XYChart.Data<String, Number>, Data> d: data) {
                Data f = d.getValue();
                f.setChoosenAttributes(new Pair<>(xCategory.getValue(), yCategory.getValue()));
            }
            update();
        });



    }

    private void update() {
        updateChart();
        setChartStyle();
    }

    private void setChartStyle() {
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

    private void updateChart() {
        chart.getData().clear();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        List<Pair<XYChart.Data<String, Number>, Data>> tmp = new ArrayList<>(this.data);
        for (Pair<XYChart.Data<String, Number>, Data> d : tmp) {
            Data f = d.getValue();
            Pair<String, Number> choosenAttributes = f.getChoosenAttributes();
            XYChart.Data<String , Number> node = new XYChart.Data<>(choosenAttributes.getKey(), choosenAttributes.getValue());
            series.getData().add(node);
            data.remove(d);
            data.add(new Pair<>(node, f));

        }
        chart.getData().add(series);

    }

    private void constructChart(XYChart.Series<String, Number> series) {
        chart.getData().clear();
        for (Data f : dataManager.getDataList()) {
            Pair<String, Number> choosenAttributes = f.getChoosenAttributes();
            Coordonnee c = new Coordonnee(Double.parseDouble(choosenAttributes.getKey()), choosenAttributes.getValue().doubleValue());
            XYChart.Data<String , Number> node = new XYChart.Data<>(choosenAttributes.getKey(), choosenAttributes.getValue());
            data.add(new Pair<>(node, f));
            series.getData().add(node);
        }
        chart.getData().add(series);
    }

    private Data getNode(XYChart.Data<String, Number> data) {
        for (Pair<XYChart.Data<String, Number>, Data> d : this.data) {
            if (d.getKey() == data) {
                return d.getValue();
            }
        }
        return null;
    }
    
    private Set<String> getAttributes() {
       return  this.dataManager.getAttributes();
    }
    
    private void updateCategories() {
        xCategory.getItems().clear();
        yCategory.getItems().clear();
        xCategory.getItems().addAll(getAttributes());
        yCategory.getItems().addAll(getAttributes());
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

    public void addNode(Data data) {
        // TODO
    }

}

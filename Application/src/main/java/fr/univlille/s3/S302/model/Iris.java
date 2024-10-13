package fr.univlille.s3.S302.model;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Iris implements Data {
    private final double sepalLength;
    private final double sepalWidth;
    private final double petalLength;
    private final double petalWidth;
    private String variety;
    private Coordonnee coordonnee;
    public  Pair<String, String> choosenAttributes;

    public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String variety) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.variety = variety;
        this.choosenAttributes = new Pair<>("sepalLength", "sepalWidth");
    }

    public double getSepalLength() {
        return sepalLength;
    }

    public double getSepalWidth() {
        return sepalWidth;
    }

    public double getPetalLength() {
        return petalLength;
    }

    public double getPetalWidth() {
        return petalWidth;
    }

    public String getSpecies() {
        return variety;
    }

    @Override
    public String toString() {
        return "Iris{" +
                "sepalLength=" + sepalLength +
                ", sepalWidth=" + sepalWidth +
                ", petalLength=" + petalLength +
                ", petalWidth=" + petalWidth +
                ", species='" + variety + '\'' +
                '}';
    }

    @Override
    public Map<String, Number> getattributes() {
        Map<String, Number> attributes = new HashMap<>();
        attributes.put("sepalLength", sepalLength);
        attributes.put("sepalWidth", sepalWidth);
        attributes.put("petalLength", petalLength);
        attributes.put("petalWidth", petalWidth);
        return attributes;
    }

    @Override
    public String getCategory() {
        return variety;
    }

    @Override
    public void setCategory(String category) {
        variety = category;
    }

    @Override
    public Pair<String, Number> getChoosenAttributes() {
        Map<String, Number> attributes = this.getattributes();
        return new Pair<>(attributes.get(choosenAttributes.getKey())+"", attributes.get(choosenAttributes.getValue()));
    }



    public void setChoosenAttributesKey(Pair<String, String> ch) {
        if (ch.getKey().equals(ch.getValue())) {
            System.err.println("Les attributs choisis doivent être différents");
            return;
            //throw new IllegalArgumentException("Les attributs choisis doivent être différents");
        }
        Map<String, Number> attributes = this.getattributes();
        if (!attributes.containsKey(ch.getKey()) || !attributes.containsKey(ch.getValue())) {
            System.err.println("Les attributs choisis ne sont pas valides");
            return;
            //throw new IllegalArgumentException("Les attributs choisis ne sont pas valides");
        }
        this.choosenAttributes = ch;
    }

    public Pair<String, String> getChoosenAttributesKey() {
        return new Pair<>(choosenAttributes.getKey(), choosenAttributes.getValue());
    }
}

package fr.univlille.s3.S302.model;

import javafx.util.Pair;

import java.util.Map;
import java.util.NoSuchElementException;

public interface Data {

    public Map<String, Number> getattributes();

    public String getCategory();

    public void setCategory(String category);

    public Pair<String, Number> getChoosenAttributes();

    public Pair<String, String> getChoosenAttributesKey();

    public void setChoosenAttributesKey(Pair<String, String> choosenAttributes) throws IllegalArgumentException, NoSuchElementException;


}

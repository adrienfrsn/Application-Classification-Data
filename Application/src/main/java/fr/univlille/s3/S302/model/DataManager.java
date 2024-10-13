package fr.univlille.s3.S302.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataManager<E extends Data> {
    public static final String PATH = "iris.csv";
    private List<E> dataList;

    public DataManager(List<E> dataList) {
        this.dataList = dataList;
    }

    public DataManager() {
        this(new ArrayList<>());
    }

    public List<E> getDataList() {
        return dataList;
    }

    public void setDataList(List<E> dataList) {
        this.dataList = dataList;
    }

    public void addData(E data) {
        dataList.add(data);
    }

    public void removeData(E data) {
        dataList.remove(data);
    }

    public void loadData(String path) {
        try {
            List<FormatDonneeBrut> tmp = DataLoader.charger(path);
            for (FormatDonneeBrut f : tmp) {
                dataList.add((E) FormatDonneeBrut.createObject(f));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void classifyData(E data) {
        // TODO
    }

    public static void main(String[] args) {
        DataManager<FormatDonneeBrut> dataManager = new DataManager<>();
        dataManager.loadData(PATH);
        System.out.println(dataManager.getDataList());
    }

}

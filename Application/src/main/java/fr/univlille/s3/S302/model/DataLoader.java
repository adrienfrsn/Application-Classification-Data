package fr.univlille.s3.S302.model;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.List;

public class DataLoader {

    public static List<FormatDonneeBrut> charger(String fileName) throws FileNotFoundException {
        System.out.println("Chargement du fichier " + fileName);
        InputStream input = DataLoader.class.getResourceAsStream(fileName);
        if (input == null) {
            if (new File(fileName).exists()) {
                input = new FileInputStream(fileName);
            } else {
                throw new FileNotFoundException("Fichier non trouvé");
            }
        }


        return csvToList(input);

    }

    private static List<FormatDonneeBrut> csvToList(InputStream input) throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(input))) {

            CsvToBean<FormatDonneeBrut> csvToBean = new CsvToBeanBuilder<FormatDonneeBrut>(reader)
                    .withSeparator(',')
                    .withType(FormatDonneeBrut.class)
                    .build();

            List<FormatDonneeBrut> records = csvToBean.parse();
            return records;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new FileNotFoundException("Fichier non trouvé");
    }

    public static Iris createObject(FormatDonneeBrut f) {
        return new Iris(f.getSepalLength(), f.getSepalWidth(), f.getPetalLength(), f.getPetalWidth(), f.getSpecies());
    }

}

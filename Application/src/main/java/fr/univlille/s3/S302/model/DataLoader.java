package fr.univlille.s3.S302.model;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataLoader {

    public static List<FormatDonneeBrut> charger(String fileName) throws IOException {
        InputStream input = DataLoader.class.getResourceAsStream(fileName);
        if (input == null) {
            throw new FileNotFoundException("Fichier non trouvé");
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(input))) {

            // Création de CsvToBeanBuilder
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

    /*public static void main(String[] args) {
        try {
            List<FormatDonneeBrut> donneesBrutes = charger(FILE_NAME);
            System.out.println(donneesBrutes);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }$/

    /*public static double normaliser_0_1 (double valeur, double min, double max) {
        return (valeur - min) / (max - min);
    }*/

    /*public static List<Iris> irisesNormalisees (List<FormatDonneeBrut> donnees) {
        double min = 0;
        double max = 0;
        for (FormatDonneeBrut f : donnees) {
            double score = f.getScore();
            if (score < min) {
                min = score;
            }
            if (score > max) {
                max = score;
            }
        }
        List<Iris> irises = new ArrayList<>();
        for (FormatDonneeBrut f : donnees) {
            double scoreNormalise = normaliser_0_1(f.getScore(), min, max);
            Iris p = createObject(f, scoreNormalise);
            irises.add(p);
        }
        return irises;
    }*/
}

module fr.univlille.s3.S302 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.opencsv;

    opens fr.univlille.s3.S302.vue to javafx.fxml;
    exports fr.univlille.s3.S302.vue;
}
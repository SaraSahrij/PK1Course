module pk {
    requires java.desktop;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;

    opens Praktikum to javafx.base;
    opens GUI to javafx.controls, javafx.base, javafx.graphics;
}
package GUI;

import Praktikum.Bild;
import Praktikum.Medienverwaltung_Typsicheren;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class BildErfassungView extends Stage {
    private Bild bild;
    private Medienverwaltung_Typsicheren mv;


    public BildErfassungView(Stage stage, Bild bild, Medienverwaltung_Typsicheren mv) {
        super();
        this.initOwner(stage);
        this.initModality(Modality.WINDOW_MODAL);
        this.bild = bild;
        this.mv = mv;
    }

    public void showView() {
        VBox vbox = new VBox(15);
        vbox.setLayoutX(10);
        vbox.setLayoutY(10);

        HBox hBoxTitle = new HBox(20);
        Label labelTitle = new Label("Titel");
        TextField txTitle = new TextField();
        hBoxTitle.getChildren().addAll(labelTitle, txTitle);

        HBox hBoxOrt = new HBox(20);
        Label labelOrt = new Label("Ort");
        TextField txOrt = new TextField();
        hBoxOrt.getChildren().addAll(labelOrt, txOrt);

        HBox hBoxJahr = new HBox(20);
        Label labelJahr = new Label("Jahr");
        TextField txJahr = new TextField();
        hBoxJahr.getChildren().addAll(labelJahr, txJahr);

        HBox hBoxButtons = new HBox(50);
        hBoxButtons.setAlignment(Pos.CENTER);
        Button btnNeu = new Button("Neu");
        Button btnCancel = new Button("Abbrechen");
        hBoxButtons.getChildren().addAll(btnNeu, btnCancel);


        vbox.getChildren().addAll(hBoxTitle, hBoxOrt, hBoxJahr, hBoxButtons);

        Pane p = new Pane();
        p.getChildren().add(vbox);
        Scene scene = new Scene(p, 300, 220);

        this.setTitle("Bilderfassung");
        this.setScene(scene);
        this.show();


        btnNeu.setOnAction((SaveEvent) -> {
            String title = txTitle.getText();
            String ort = txOrt.getText();
            int jahr = Integer.parseInt(txJahr.getText());
            bild.setTitle(title);
            bild.setOrt(ort);
            bild.setJahr(jahr);

            mv.aufnahme(bild);
            MessageView.create(this, "Hinweis", "Bild wurde Erfolgreich hinzugefügt" ).showView();
            this.close();

        });
        btnCancel.setOnAction(AbbrechenEvent -> {
            this.close();
        });
    }
}

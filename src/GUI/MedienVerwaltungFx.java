package GUI;

import Praktikum.Bild;
import Praktikum.Medienverwaltung_Typsicheren;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class MedienVerwaltungFx  extends Application {

    private Medienverwaltung_Typsicheren mv;
    @Override
    public void start(Stage stage) throws Exception {
        mv = new Medienverwaltung_Typsicheren();

        Button audioBtn = new Button("Audio aufnehmen");
        Button bildBtn = new Button("Bild aufnehmen");
        Button showBtn = new Button("Liste anzeigen");


        bildBtn.setOnAction((ActionEvent) -> {
            BildErfassungView bildErfassungView = new BildErfassungView(stage, new Bild(), mv);
            bildErfassungView.showView();
        });

        showBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mv.zeigeMedien();
            }
        });

        VBox vb=new VBox(15);
        vb.getChildren().addAll(audioBtn, bildBtn, showBtn);
        vb.setLayoutX(20);
        vb.setLayoutY(20);

        Pane p = new Pane();
        p.getChildren().add(vb);

        Scene s = new Scene(p , 200, 200);
        stage.setScene(s);
        stage.setTitle("Medienverwaltung");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

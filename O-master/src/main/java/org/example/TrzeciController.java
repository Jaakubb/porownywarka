package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TrzeciController {

    @FXML private TextField poletekstowe;
    @FXML private Label ocena;

    private static EntityManager eM;
    private EntityManagerFactory eMF;

    public int a = 0;

   // @FXML
   // public void getPoletekstowe{

    @FXML public void initialize() {

        eMF = Persistence.createEntityManagerFactory("default");
        eM = eMF.createEntityManager();

    }

    public float ocena( ) {
String f = poletekstowe.getText();
        Waga w = eM.find(Waga.class, 1);
        Auta auto = eM.find(Auta.class, Integer.parseInt(f));
        float oc = 0;
        w.getPrzyspieszenie();
        oc = (((float) (auto.getPredkosc() - 100)) / 200 * w.getPredkosc()) + ((((float) auto.getPrzyspiesznie() - 1) / 9 * w.getPrzyspieszenie())) + ((((float) (auto.getRocznik()) - 2000) / 22 * w.getRocznikp()));
        oc = oc/w.suma_wag();
        return oc;
    }


    @FXML
    protected void powrot2(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        primaryStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Stage nextStage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());


        nextStage.setTitle("1");
        nextStage.setScene(scene);
        nextStage.show();
    }

    @FXML
    protected void ok(){
        ocena.setText(Float.toString(ocena()));
    }
}

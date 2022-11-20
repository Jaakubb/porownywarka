package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;



public class CzwartyController {


    @FXML private TextField poletekstowe1;
    @FXML private TextField poletekstowe2;
    @FXML private TextField poletekstowe3;
    @FXML private TextField poletekstowe4;
    @FXML private TextField poletekstowe5;

    private static EntityManager eM;
    private EntityManagerFactory eMF;

    @FXML public void initialize() {

        eMF = Persistence.createEntityManagerFactory("default");
        eM = eMF.createEntityManager();

    }

    Auta auta = new Auta();

    @FXML
    protected void dodaj(){
        String pred = poletekstowe2.getText();
        auta.setPredkosc(Integer.parseInt(pred));

        auta.setKolor(poletekstowe4.getText());

        String prz = poletekstowe3.getText();
        auta.setPrzyspiesznie(Integer.parseInt(prz));

        auta.setMarka(poletekstowe1.getText());

        String rocz = poletekstowe5.getText();
        auta.setRocznik(Integer.parseInt(rocz));

        eM.getTransaction().begin();
        eM.persist(auta);
        eM.getTransaction().commit();
    }


    @FXML
    protected void powrot4(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        primaryStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage nextStage = new Stage();
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        nextStage.setTitle("1");
        nextStage.setScene(scene);
        nextStage.show();
    }
}

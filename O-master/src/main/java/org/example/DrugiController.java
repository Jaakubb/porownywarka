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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static org.example.Main.listaWszystkichAut;

public class DrugiController {

    private EntityManagerFactory eMF;
    private EntityManager eM;
    public  String l ;
    @FXML
    private Label lista;
    public static String listaWszystkichAut(EntityManager eM) {
        List<Auta> autka = eM.createQuery("SELECT e FROM Auta e").getResultList();
        String s = "";
        for (int i = 0; i < autka.size(); i++) {
            s += autka.get(i).getId() + "    " + autka.get(i).getKolor() + "    " + autka.get(i).getMarka() + "    " + autka.get(i).getPredkosc() + "    " + autka.get(i).getPrzyspiesznie() + "    " + autka.get(i).getRocznik() + "\n";
        }
        return s;
    }

    @FXML public void initialize(){

        eMF = Persistence.createEntityManagerFactory("default");
        eM = eMF.createEntityManager();
        l = (listaWszystkichAut(eM));
        lista.setText(l);


    }

    @FXML
    protected void powrot1(ActionEvent event) throws IOException {
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

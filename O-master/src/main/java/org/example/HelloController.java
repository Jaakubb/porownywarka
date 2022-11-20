package org.example;

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

public class HelloController {

    public int a=0;
    public boolean b;
    private EntityManagerFactory eM;

    public HelloController(){
        eM = Persistence.createEntityManagerFactory("default");
    }

    @FXML private Label welcomeText;
    @FXML private TextField poletekstowe;

    @FXML
    public void getPoletekstowe() {
        a+=Integer.parseInt(poletekstowe.getText());
        poletekstowe.setText("");
    }

    @FXML
    protected void onHelloButtonClick() {
        String str = poletekstowe.getText();
        try {
            int liczba = Integer.parseInt(str);

            welcomeText.setText(Integer.toString(liczba*2));

        }
        catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

    }
    @FXML
    protected void button(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        primaryStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("drugi-view.fxml"));
        Stage nextStage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());



        nextStage.setTitle("1");
        nextStage.setScene(scene);
        nextStage.show();
    }

    @FXML
    protected void button2(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        primaryStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("trzeci-view.fxml"));
        Stage nextStage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());


        nextStage.setTitle("2");
        nextStage.setScene(scene);
        nextStage.show();
    }
    @FXML
    protected void daut(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        primaryStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("czwarty-view.fxml"));
        Stage nextStage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());


        nextStage.setTitle("2");
        nextStage.setScene(scene);
        nextStage.show();
    }


}
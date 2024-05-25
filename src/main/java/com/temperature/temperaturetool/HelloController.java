package com.temperature.temperaturetool;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public Label welcomeText;

    @FXML
    private ChoiceBox<String > choiceBox;

    @FXML
    private TextField textField;

    @FXML
    private Button convertButton;

    public static  final String C_TO_F="Celsius to Fahrenheit";
    public static  final String F_TO_C="Fahrenheit to  Celsius";

    @Override
    public void initialize(URL Location, ResourceBundle resourceBundle){

        choiceBox.getItems().add(C_TO_F);
        choiceBox.getItems().add(F_TO_C);


        choiceBox.setValue(C_TO_F);

        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                System.out.println(t1);
            }
        });


        convertButton.setOnAction(ActionEvent->{
            System.out.println("Button clicked");
        });

    }
}
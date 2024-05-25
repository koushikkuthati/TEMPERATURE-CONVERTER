package com.temperature.temperaturetool;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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

    public boolean isC_TO_F=true;

    @Override
    public void initialize(URL Location, ResourceBundle resourceBundle){

        choiceBox.getItems().add(C_TO_F);
        choiceBox.getItems().add(F_TO_C);


        choiceBox.setValue(C_TO_F);

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            if(t1.equals(C_TO_F)){
                isC_TO_F=true;

            }else {
                isC_TO_F=false;
            }
        });

        convertButton.setOnAction(ActionEvent->{
            convert();
        });



    }
    private void convert(){

        String input=textField.getText();
        Float enteredInput=0.0f;
        try
        {
            enteredInput=Float.parseFloat(input);
        }catch (Exception ex){
            warnUser();
            return;
        }


        float newTemperature=0.0f;

        if(isC_TO_F){
            newTemperature=(enteredInput*9/5)+32;


        }else {
            newTemperature=(enteredInput-32)*5/9;
        }
        display(newTemperature);


    }

    private void warnUser() {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occured");
        alert.setHeaderText("Invalid Temperature Entered");

        alert.setContentText("Please enter a valid temperature : ");
        alert.show();
    }

    private void display(float newTemperature) {
        String unit=isC_TO_F? "F" : "C";
        System.out.println("the new temperature is : "+newTemperature+unit);

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("the new temperature is : "+newTemperature+unit);
        alert.show();
    }
}
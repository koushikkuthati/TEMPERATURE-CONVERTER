package com.temperature.temperaturetool;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");

    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Pane rootnode=fxmlLoader.load();

        MenuBar menuBar=createMenu();
        rootnode.getChildren().add(0,menuBar);
        Scene scene = new Scene( rootnode);

        stage.setTitle("Temperature Converter");



        stage.setScene(scene);
        stage.show();
        System.out.println("start");
    }

    private MenuBar createMenu() {

        Menu FileMenu=new Menu("File");
        MenuItem newMenuItem=new MenuItem("New");
        newMenuItem.setOnAction(ActionEvent-> System.out.println("New item is clicked"));
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        SeparatorMenuItem separatorMenuItem1=new SeparatorMenuItem();

        MenuItem quitMenuItem=new MenuItem("Quit");
        quitMenuItem.setOnAction(ActionEvent->{
            Platform.exit();
            System.exit(0);
        });

        Menu HelpMenu=new Menu("Help");
        MenuItem aboutHelpMenu=new MenuItem("about");

        aboutHelpMenu.setOnAction(ActionEvent-> {
            aboutApp();
        });

        FileMenu.getItems().addAll(newMenuItem,separatorMenuItem1,quitMenuItem);
        HelpMenu.getItems().addAll(aboutHelpMenu);

        MenuBar menuBar=new MenuBar();

        menuBar.getMenus().addAll(FileMenu,HelpMenu);
        return menuBar;


    }

    private void aboutApp() {
        Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First Desktop Application");
        alertDialog.setHeaderText("Learning JavaFX");
        alertDialog.setContentText(" I am koushik and i am best java game developer.");


        ButtonType yesbtn=new ButtonType("yes");
        ButtonType nobtn=new ButtonType("No");

        alertDialog.getButtonTypes().setAll(yesbtn,nobtn);


        Optional<ButtonType> clickedbtn=alertDialog.showAndWait();

        if(clickedbtn.isPresent()&&clickedbtn.get().equals(yesbtn)){
            System.out.println("Yes button is clicked");

        }else {
            System.out.println("No button is clicked");
        }


        alertDialog.show();

    }


    @Override
    public void stop() throws Exception {
        System.out.println("stop");
    }
}




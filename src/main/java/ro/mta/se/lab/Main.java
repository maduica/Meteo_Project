package ro.mta.se.lab;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ro.mta.se.lab.controller.Vreme_Controller;
import ro.mta.se.lab.model.Location;
import ro.mta.se.lab.model.Vreme_info;
import java.io.IOException;

public class Main extends Application {
    private ObservableList<Location>locations_= FXCollections.observableArrayList();
    public static void main(String[] args)
    {
        launch(args);
    }



    public void start(Stage primaryStage)  {
        FXMLLoader loader = new FXMLLoader();
        try {
            Vreme_info vinfo_=new Vreme_info("src/main/resources/inputFile.txt");
            loader.setLocation(this.getClass().getResource("/view/ViewVreme.fxml"));
            locations_=vinfo_.getLocations_();
            loader.setController(new Vreme_Controller(locations_,vinfo_.getCountries_()));
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package ro.mta.se.lab.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import ro.mta.se.lab.model.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.util.Vector;

/**
 * @author Duica Marius
 * Clasa aceasta formeaza legatura dintre model si view (controller pentru
 * modelul MVC)
 */

public class Vreme_Controller {
    /**
     * Membrii clasei Vreme_Controller:
     * ->countries_ reprezinta lista de tari ce vor fi afisate
     * ->locations_ reprezinta lista de orase ce vor fi afisate
     * -> choosen_Country_ reprezinta tara aleasa de catre utilizator
     * ->choosen_City_ reprezinta orasul ales de catre utilizator
     * ->id_ rerezinta id-ul obtinut in urma alegerii localitatii
     * ->labelurile vor afisa datele extrase in urma interogarii serverului
     */
    private ObservableList<Location> locations_;
    private ObservableList<String> countries_= FXCollections.observableArrayList();
    private String choosen_Country_;
    private String choosen_City_;
    private String id_;

    @FXML
    private ImageView forReplace;
    @FXML
    private ComboBox<String> countryComboB;
    @FXML
    private ComboBox<String>cityComB;
    @FXML
    private Label temp_;
    @FXML
    private Label temp_min_;
    @FXML
    private Label temp_max_;
    @FXML
    private Label wind_;
    @FXML
    private Label pressure_;
    @FXML
    private Label action_;
    @FXML
    private Label date_;

    public Vreme_Controller(ObservableList<Location> loc, Vector<String> co) {
        this.locations_ = loc;
        this.countries_.addAll(co);
    }

    @FXML
    public void findDatas() throws IOException {
        if (this.choosen_Country_ != null && this.choosen_City_ != null) {
            for (int i = 0; i < this.locations_.size(); i++) {
                if (this.locations_.get(i).getLocationCountry_().equals(this.choosen_Country_) &&
                        this.locations_.get(i).getLocation_Name_().equals(this.choosen_City_)) {
                    this.id_ = this.locations_.get(i).getId_();
                }
            }

            WebConnect webRequest_ = new WebConnect( this.id_);
            JsonAnalyzer jsonService = new JsonAnalyzer(webRequest_.getMyjsonFile_());

            MyUtils util = new MyUtils();
            //crearea unui obiect Weather
            Weather w = new Weather(jsonService.get_TEMP_(), jsonService.getWindSpeed_(), jsonService.pressure(), jsonService.get_max_TEMP_(),
                    jsonService.get_min_TEMP_(), jsonService.get_Action(),jsonService.get_icon());

            this.temp_.setText("Now: "+w.getTemperature_()+"\u00B0"+"C");
            this.wind_.setText(w.getWind_speed());
            this.temp_min_.setText("Minim: "+w.getMinTemp_()+"\u00B0"+"C");
            this.temp_max_.setText("Maxim: "+w.getMaxTemp_()+"\u00B0"+"C");
            this.pressure_.setText("Pressure: "+w.getPressure_()+"atm");
            this.date_.setText(util.returnCurrentDate_());
            this.wind_.setText("Wind: "+w.getWind_speed()+"m/s");

            util.markToFile(util.returnCurrentDate_(),this.choosen_Country_,this.choosen_City_,w.getAction_(),w.getWind_speed(),w.getPressure_(),w.getTemperature_());
            Image img;
            img=new Image("https://openweathermap.org/img/wn/"+w.getIcon_()+"@2x.png");
            this.forReplace.setImage(img);

        }
    }


    //afisarea tarilor in interfata grafica
    @FXML
    private void selectCo()
    {
        this.countryComboB.getItems().clear();
       for(int i=0;i<this.countries_.size();i++)
       {
           this.countryComboB.getItems().add(this.countries_.get(i));
       }
    }


    @FXML
    private void choosenCo()
    {
        this.choosen_Country_=this.countryComboB.getValue();
    }

    //afisarea localitatilor in interfata grafica
    @FXML
    private void selectCi()
    {
        this.cityComB.getItems().clear();
        for(int i=0;i<this.locations_.size();i++)
        {
            if(this.choosen_Country_.equals(this.locations_.get(i).getLocationCountry_()))
            {
                this.cityComB.getItems().add(this.locations_.get(i).getLocation_Name_());
            }
        }
    }

    @FXML
    private void choosenCi()
    {
        this.choosen_City_=this.cityComB.getValue();
    }

}



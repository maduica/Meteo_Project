package ro.mta.se.lab.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import ro.mta.se.lab.model.Location;
import ro.mta.se.lab.model.WebConnect;

import java.io.IOException;
import java.util.Vector;

public class Vreme_Controller {
    private ObservableList<Location> locations_;
    private ObservableList<String> countries_= FXCollections.observableArrayList();

    private String choosen_Country_;
    private String choosen_City_;
    private String id_;

    @FXML
    private ComboBox<String> countryComboB;

    @FXML
    private ComboBox<String>cityComB;


    public Vreme_Controller(ObservableList<Location> loc, Vector<String> co) {
        this.locations_ = loc;
        this.countries_.addAll(co);
    }

    @FXML
    public void findDatas() throws IOException {
        if(this.choosen_Country_!=null && this.choosen_City_!=null)
        {
            for(int i=0;i<this.locations_.size();i++)
            {
                if(this.locations_.get(i).getLocationCountry_().equals(this.choosen_Country_) &&
                    this.locations_.get(i).getLocation_Name_().equals(this.choosen_City_))
                {
                    this.id_=this.locations_.get(i).getId_();
                }
            }

            WebConnect webRequest_=new WebConnect(this.choosen_City_,this.choosen_Country_,this.id_);
            System.out.println(webRequest_.getMyjsonFile_());
        }
    }

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



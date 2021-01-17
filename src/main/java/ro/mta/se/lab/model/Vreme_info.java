package ro.mta.se.lab.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author Duica Marius
 * cu ajutorul acestei clase obtinem atat localitatile cat si tarile
 * pe care le putem obtine cu ajutorul functiilor specifice de get
 */
public class Vreme_info {
    private ObservableList<Location> locations_ = FXCollections.observableArrayList();
    private Vector<String> countries_;
    private String filename_;


    public Vreme_info(String filename) throws FileNotFoundException {
        this.filename_ = filename;
        initiateLocations();
    }

    private void initiateLocations() throws FileNotFoundException {
        String fileContent = new Scanner(new File(this.filename_)).useDelimiter("\\Z").next();

        String[] parts = fileContent.split("\n");
        this.countries_ = new Vector<String>(parts.length - 1);
        MyUtils util=new MyUtils();
        for (int i = 0; i < parts.length; i++) {
            if (i > 0) {
                String[] littleparts = parts[i].split(" +");
                Location loc = new Location(littleparts[0], littleparts[1], littleparts[2]);
                this.locations_.add(loc);
                if (util.checkExist_(this.countries_, littleparts[2]) == 0) {
                    this.countries_.add(littleparts[2]);
                }
            }
        }

        //ordonarea alfabetica a tarilor
        Collections.sort(this.countries_);
    }

    //functii de get pentru tari si orase
    public ObservableList<Location> getLocations_() {
        return locations_;
    }

    public Vector<String> getCountries_() {
        return countries_;
    }
}

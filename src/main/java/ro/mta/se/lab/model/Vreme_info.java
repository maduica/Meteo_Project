package ro.mta.se.lab.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Vreme_info {
    private ObservableList<Location> locations_ = FXCollections.observableArrayList();
    private Vector<String> countries_;
    private String filename_;


    public Vreme_info(String filename) throws FileNotFoundException {
        this.filename_ = filename;
        initiateLocations();
    }

    public int checkExist_(Vector<String> words, String forSearch) {

        int ok = 0;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(forSearch)) {
                ok++;
                break;
            }
        }
        return ok;
    }

    private void initiateLocations() throws FileNotFoundException {
        String fileContent = new Scanner(new File(this.filename_)).useDelimiter("\\Z").next();

        String[] parts = fileContent.split("\n");
        this.countries_ = new Vector<String>(parts.length - 1);

        //obtinerea locatiilor
        for (int i = 0; i < parts.length; i++) {
            if (i > 0) {
                String[] littleparts = parts[i].split(" +");
                Location loc = new Location(littleparts[0], littleparts[1], littleparts[2]);
                this.locations_.add(loc);
                if (checkExist_(this.countries_, littleparts[2]) == 0) {
                    this.countries_.add(littleparts[2]);
                }
            }
        }
      //  System.out.println(this.locations_.size()+" "+this.countries_.size());
    }

    public ObservableList<Location> getLocations_() {
        return locations_;
    }

    public Vector<String> getCountries_() {
        return countries_;
    }
}

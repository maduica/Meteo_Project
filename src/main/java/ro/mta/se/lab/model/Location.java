package ro.mta.se.lab.model;

public class Location {
    private String id_;
    private String location_Name_;
    private String locationC_;

    public Location(String id, String locName,String locC)
    {
        this.id_=id;
        this.location_Name_=locName;
        this.locationC_=locC;
    }

    public String getId_() {
        return id_;
    }

    public String getLocation_Name_() {
        return location_Name_;
    }

    public String getLocationCountry_() {
        return locationC_;
    }

}

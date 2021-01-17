package ro.mta.se.lab.model;


/**
 * aceasta clasa este creata pentru a ne usura lucrul cu localitatile
 * location_Name_ reprezinta numele localitatii, locationC_ numele tarii de care apartine
 * iar id_ este identificatorul specificc localitatii
 */
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

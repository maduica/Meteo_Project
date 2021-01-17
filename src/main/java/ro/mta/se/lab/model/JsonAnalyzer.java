package ro.mta.se.lab.model;


import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Duica Marius
 * Clasa cu care vom parsa stringul jsonFile_ obtinut in urma interoarii serverului.
 * Aceasta clasa este alcatuita exclusiv din functii de get prin care obtinem datele necesare pentru
 * afisarea in GUI.
 */

public class JsonAnalyzer {
    String jsonFile_;

    public JsonAnalyzer(String j)
    {
        this.jsonFile_=j;
    }

    public String get_TEMP_(){

        JSONObject obj=new JSONObject(this.jsonFile_);
        return  String.valueOf(obj.getJSONObject("main").getFloat("temp"));
    }
    public String get_min_TEMP_(){

        JSONObject obj=new JSONObject(this.jsonFile_);
        return  String.valueOf(obj.getJSONObject("main").getFloat("temp_min"));
    }
    public String get_max_TEMP_(){

        JSONObject obj=new JSONObject(this.jsonFile_);
        return  String.valueOf(obj.getJSONObject("main").getFloat("temp_max"));
    }
    public String get_Action(){

        JSONObject obj=new JSONObject(this.jsonFile_);
        JSONArray wea=(JSONArray)obj.get("weather");
        JSONObject wea1=(JSONObject)wea.get(0);
        return (String)wea1.get("main");
    }

    public String get_icon(){

        JSONObject obj=new JSONObject(this.jsonFile_);
        JSONArray wea=(JSONArray)obj.get("weather");
        JSONObject wea1=(JSONObject)wea.get(0);
        return (String)wea1.get("icon");
    }

    public String getWindSpeed_()
    {
        JSONObject obj=new JSONObject(this.jsonFile_);
        return  String.valueOf(obj.getJSONObject("wind").getFloat("speed"));
    }

    public String pressure()
    {
        JSONObject obj=new JSONObject(this.jsonFile_);
        return  String.valueOf(obj.getJSONObject("main").getFloat("pressure"));
    }
}

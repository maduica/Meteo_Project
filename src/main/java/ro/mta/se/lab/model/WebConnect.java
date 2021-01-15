package ro.mta.se.lab.model;

import com.sun.source.tree.WhileLoopTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WebConnect {
    String city_;
    String country_;
    String locID_;
    String apiKey_;

    public WebConnect(String cityName, String countryName,String id)
    {
        this.locID_=id;
        this.city_=cityName;
        this.country_=countryName;
        this.apiKey_="3590e4d2ca45a176e6f39f2a679977f9";
//api.openweathermap.org/data/2.5/weather?id={city id}&appid={API key}

    }

    public String getMyjsonFile_() throws IOException {
        String myjsonFile_="";
        String requestURL = "http://api.openweathermap.org/data/2.5/weather?id=" +
                this.locID_ + "&appid=" + this.apiKey_ + "&units=metric";

        URL url=new URL(requestURL);
        URLConnection conn=url.openConnection();
        BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder rez=new StringBuilder();

        String line;
        while((line=reader.readLine())!=null)
        {
            rez.append(line);
        }
        reader.close();
        myjsonFile_=rez.toString();

        return myjsonFile_;
    }

}

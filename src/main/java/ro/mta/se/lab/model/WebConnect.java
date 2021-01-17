package ro.mta.se.lab.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * WebConnect este clasa prin intermediul careia interogam serverul pe baza id-ului si obtinem
 * fisierul json corespunzator localitatii.
 * apiKey_ este cheia de la contul propriu, in timp ce locID_ este identificatorul localitatii
 */
public class WebConnect {
    String locID_;
    String apiKey_;

    public WebConnect(String id)
    {
        this.locID_=id;
        this.apiKey_="3590e4d2ca45a176e6f39f2a679977f9";
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

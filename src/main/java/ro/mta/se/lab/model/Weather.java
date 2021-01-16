package ro.mta.se.lab.model;

public class Weather {
    String temperature_;
    String wind_speed;
    String pressure_;
    String maxTemp_;
    String minTemp_;
    String action_;
    String feels_like_;

    public Weather(String temperature, String wind_speed, String pressure_, String maxTemp_, String minTemp_, String action_, String feels_like_) {
        this.temperature_ = temperature;
        this.wind_speed = wind_speed;
        this.pressure_ = pressure_;
        this.maxTemp_ = maxTemp_;
        this.minTemp_ = minTemp_;
        this.action_ = action_;
        this.feels_like_ = feels_like_;
    }

    public String getTemperature_() {
        return temperature_;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public String getPressure_() {
        return pressure_;
    }

    public String getMaxTemp_() {
        return maxTemp_;
    }

    public String getMinTemp_() {
        return minTemp_;
    }

    public String getAction_() {
        return action_;
    }

    public String getFeels_like_() {
        return feels_like_;
    }


}

package com.drc.des.sunshine;

public class Weather extends MainActivity {

    private String day, clouds, highTemp, lowTemp, currentTemp, humid, wind, pressure;
    private int image;
    private int sunny = R.mipmap.sunny;
    private int rain = R.mipmap.rain;
    private int other = R.mipmap.ic_launcher;


    public Weather(){
        super();
    }

    public Weather(String day,String clouds, String currentTemp, String highTemp, String lowTemp,
                   String humid, String wind, String pressure) {
        super();
        this.day = day;
        this.currentTemp = currentTemp;
        this.highTemp = highTemp;
        this.lowTemp = lowTemp;
        this.humid = humid;
        this.wind = wind;
        this.pressure = pressure;
        this.clouds = clouds;
        if (clouds == "Sunny"){
            this.image = sunny;
        }
        else if (clouds == "Rainy"){
            this.image = rain;
        }
        else {
            this.image = other;
        }


    }

    public String getWeekDay() {
        return day;
    }

    public String getTempHigh() {
        return highTemp;
    }

    public String getTempLow() {
        return lowTemp;
    }

    public String getCondition() {
        return clouds;
    }

    public int getImage() {
        return image;
    }

    public String getWind() {
        wind = "Wind: " + wind + " km/h SW";
        return wind;
    }

    public String getHumid() {
        humid = "Humidity: " + humid + "%";
        return humid;
    }

    public String getPressure() {
        pressure = "Pressure: " + pressure + " hPa";
        return pressure;
    }
}
package models;

import java.util.HashMap;
import java.util.Iterator;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Station extends Model
{
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();
  public double latitude;
  public double longitude;

  public String name;
  public Station(String name)
  {
    this.name = name;
  }
  public int pressure(int pressure){ return pressure;}

 public static String codeToText(int code)
 {
  HashMap <Integer, String> weatherCodes = new HashMap<>();

  weatherCodes.put(100, "Clear");
  weatherCodes.put(200, "Partial clouds");
  weatherCodes.put(300, "Cloudy");
  weatherCodes.put(400, "Light showers");
  weatherCodes.put(500, "Heavy showers");
  weatherCodes.put(600, "Rain");
  weatherCodes.put(700, "Snow");
  weatherCodes.put(800, "Thunder");

  return weatherCodes.get(code);
 }

 public static double calculateCelcius(double celcius, double temperature)
 {
  celcius = temperature;
  return celcius;
 }

 public static double calculateFahrenheit(double temperature)
 {
  double fahrenheit= temperature * 9 / 5 + 32;
  return (int) (fahrenheit * 100.0) /100.0;
 }

 public static double windChill(double windSpeed, double temperature)
 {
  double windChill = 13.12 + 0.6215* temperature- 11.37 * Math.pow(windSpeed, 0.16)
          + 0.3965 * (temperature * Math.pow(windSpeed,0.16));
  return (int) (windChill *100.0 ) /100.0;
 }
// https://introcs.cs.princeton.edu/java/12types/WindChill.java.html

 public static int windBeaufort(double windSpeed)
 {
  if (windSpeed <= 1){
   return 0;
  } else if (windSpeed > 1 || windSpeed <= 5){
   return 1;
  } else if (windSpeed >= 6 || windSpeed <= 11) {
   return 2;
  } else if (windSpeed >= 12 || windSpeed <= 19) {
   return 3;
  } else if (windSpeed >= 20|| windSpeed <= 28) {
   return 4;
  } else if (windSpeed >= 29 || windSpeed <= 38) {
   return 5;
  } else if (windSpeed >= 39 || windSpeed <= 49) {
   return 6;
  } else if (windSpeed >= 50 || windSpeed <= 61) {
   return 7;
  } else if (windSpeed >= 62 || windSpeed <= 74) {
   return 8;
  } else if (windSpeed >= 75 || windSpeed <= 88) {
   return 9;
  } else if (windSpeed >= 89 || windSpeed <= 102) {
   return 10;
  } else {
   return 11;
  }
 }

 public static String windDirection(int windDirection)
 {
  if (windDirection <= 11.25) {
   return "North";
  } else if (windDirection <= 33.75) {
   return "North North-East";
  } else if (windDirection <= 56.25) {
   return "North-East";
  } else if (windDirection <= 78.75) {
   return "East North-East";
  } else if (windDirection <= 101.25) {
   return "East";
  } else if (windDirection <= 123.75) {
   return "East";
  } else if (windDirection <= 146.25) {
   return "East South-East";
  } else if (windDirection <= 168.75) {
   return "South-East";
  } else if (windDirection <= 168.75) {
   return "South South-East";
  } else if (windDirection <= 191.25) {
   return "South";
  } else if (windDirection <= 213.75) {
   return "South South-West";
  } else if (windDirection <= 236.25) {
   return "South-West";
  } else if (windDirection <= 258.75) {
   return "West South-West";
  } else if (windDirection <= 281.25) {
   return "West";
  } else if (windDirection <= 303.75) {
   return "West North-West";
  } else if (windDirection <= 326.25) {
   return "North-West";
  } else {
   return "North North-West";
  }
 }
 
}


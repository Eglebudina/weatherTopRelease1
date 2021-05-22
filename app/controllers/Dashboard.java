package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import utils.StationDetails;


public class Dashboard extends Controller
{
  public static void index() {
    List<Station> stations = Station.findAll();

    for (Station station : stations) {
      List<Reading> readings = station.readings;
      if (readings != null) {
        Reading lastReading = readings.get(readings.size() - 1);
      }
      render("dashboard.html", stations);
    }
  }

  public static void deleteStation(Long id) {
    Station station = Station.findById(id);
    Logger.info("Removing" + station.name);
    station.delete();
    redirect("/dashboard");
  }

  public static void addStation(String name) {
      Station station = new Station(name);
      Logger.info("Adding a new station called " + name);
      station.save();
      redirect("/dashboard");
    }

}

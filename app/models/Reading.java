package models;

import javax.persistence.Entity;
import java.util.HashMap;
import java.util.HashSet;
import play.db.jpa.Model;
import java.util.ArrayList;
import java.util.Iterator;

@Entity
public class Reading extends Model
{
  public int code;
  public double temperature;
  public double windSpeed;
  public int pressure;
  public int windDirection;

  public Reading(int code,double temperature, double windSpeed, int pressure, int windDirection)
  {
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.pressure = pressure;
    this.windDirection = windDirection;
  }

}

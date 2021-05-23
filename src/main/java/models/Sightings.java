package models;


import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Sightings {
    //properties
    private int id;
    private String animalName;
    private String location;
    private int rangerid;
    private Timestamp timestamp;



    //Constructor
    public Sightings(String animalName, String location, int rangerid) {
        this.animalName = animalName;
        this.location = location;
        this.rangerid = rangerid;
        this.id = rangerid;
        this.timestamp = new Timestamp(new Date().getTime());
    }
    // getters
    public String getAnimalName() {
        return animalName;
    }

    public int getId() {
        return id;
    }

    public int getRangerid() {
        return rangerid;
    }

    public String getLocation() {
        return location;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sightings sighting = (Sightings) o;
        return getAnimalName().equals(sighting.getAnimalName()) &&
                getRangerid() == sighting.getRangerid()&&
                Objects.equals(getLocation(), sighting.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalName, location, rangerid);
    }
}



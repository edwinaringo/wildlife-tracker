package models;

public class Sightings {
    private String animalName;
    private int rangerid;
    private String location;
    private int id;

    public Sightings(String animalName, String location, int rangerid) {
        this.animalName = animalName;
        this.location = location;
        this.rangerid = rangerid;
        this.id = rangerid;
    }

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
}



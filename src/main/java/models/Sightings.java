package models;


import org.sql2o.*;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
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

    public void save() {
        String sql = "INSERT INTO sightings(animalname, loction, timestamp, rangerid) values (:animalname, :location, :timestamp, :rangerid)";
        try(Connection con = DB.sql2o.open()) {
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("animalName",this.animalName)
                    .addParameter("location",this.location)
                    .addParameter("timestamp",this.timestamp)
                    .addParameter("rangerid",this.rangerid)
                    .executeUpdate()
                    .getKey();
        }catch (Sql2oException exception) {
            System.out.println(exception);
        }
    }

    public static List<Sightings> allSightings(){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM sightings")
                    .executeAndFetch(Sightings.class);
        }
    }

    public static List<Object> allLocations(){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT location FROM sightings")
                    .executeAndFetch(Object.class);
        }
    }

    public static Sightings find(int searchId) {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM sightings WHERE id =:id")
                    .addParameter("id", searchId)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Sightings.class);
        }
    }

    public String getRangerName() {
        return Ranger.find(rangerid).getName();
    }


}



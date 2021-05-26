package models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Objects;

public class Ranger {
    private String name;
    private int id;

    public Ranger(String name) {
        this.name = name;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(this == null || getClass() != o.getClass()) return false;
        Ranger ranger = (Ranger) o;
        return Objects.equals(getName(), ranger.getName()) &&
                getId() == ranger.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void save() {
        String sql ="INSERT INTO rangers(name) VALUES (:name)";
        try (Connection con = DB.sql2o.open()){
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();

        }catch (Sql2oException exception) {
            System.out.println(exception);
        }
    }

    public static Ranger find(int searchId) {
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM rangers WHERE id=:id")
                    .addParameter("id",searchId)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Ranger.class);
        }
    }

    public static List<Ranger> allRangers(){
        try(Connection con =DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM rangers")
                    .executeAndFetch(Ranger.class);
        }
    }

    public List<Sightings> rangerSightings(){
        String sql = "SELECT * FROM sightings WHERE rangerid =:id";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id",this.id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sightings.class);
        }
    }

    public void delete(){
        try(Connection con = DB.sql2o.open()) {
            con.createQuery("DELETE FROM rangers WHERE id = :id")
                    .addParameter("id",this.id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }

}

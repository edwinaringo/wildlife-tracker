package models;

import org.junit.rules.ExternalResource;
import org.sql2o.*;


public class DatabaseRule extends ExternalResource {

    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postegresql://localhost:5432/parks_test", "edwin","123");
    }

    protected void after() {
        try(Connection con = DB.sql2o.open()){
            String deleteAnimalsQuery = "DELETE FROM animals;";
            String deleteSightingsQuery = "DELETE FROM sightings;";
            String deleteRangerQuery = "DELETE FROM rangers;";
            con.createQuery(deleteAnimalsQuery).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();
            con.createQuery(deleteRangerQuery).executeUpdate();
        }
    }
}

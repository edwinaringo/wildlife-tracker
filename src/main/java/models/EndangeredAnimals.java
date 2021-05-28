package models;

import org.sql2o.*;

import java.util.List;

public class EndangeredAnimals extends Animals{
    private static final String DATABASE_TYPE = "Endangered";

// Constructor.
    public EndangeredAnimals(String name, String age, String health) {
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = DATABASE_TYPE;
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals(name, health, age, type) values (:name, :health, :age. :type)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
        }catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    public static List<EndangeredAnimals> allEndangeredAnimals() {
        String sql = "SELECT * FROM animals where type=:type";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("type",DATABASE_TYPE)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimals.class);
        }
    }

    public static EndangeredAnimals find(int searchId) {
        String sql = "SELECT * FROM animals where id=:id AND type=:type";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id",searchId)
                    .addParameter("type",DATABASE_TYPE)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredAnimals.class);
        }
    }


}

package models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class SafeAnimals extends Animals{
    private static final String DATABASE_TYPE = "Safe";

    public SafeAnimals(String name, String health, String age) {
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



    public static List<SafeAnimals> allSafeAnimals() {
        String sql = "SELECT  * FROM animals where type=:type";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("type",DATABASE_TYPE)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(SafeAnimals.class);
        }
    }

    public static SafeAnimals find(int searchId) {
        String sql = "SELECT * FROM animals where id=:id AND type=:type";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id",searchId)
                    .addParameter("type",DATABASE_TYPE)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(SafeAnimals.class);
        }
    }
}

package models;
import org.sql2o.*;
import java.util.List;
import java.util.Objects;

public abstract class Animals {
    public int id;
    public String name;
    public String health;
    public String age;
    public String type;


    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth() {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge() {
        this.age = age;
    }


    //Override equals and hashcode.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animal = (Animals) o;
        return  Objects.equals(getName(), animal.getName()) &&
                Objects.equals(getAge(), animal.getAge()) &&
                Objects.equals(getHealth(), animal.getHealth())&&
                Objects.equals(getType(), animal.getType())&&
                getId() == animal.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,health,age,type);
    }

    public void save(){
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals(name, health, age, type) values (:name, :health, :age, :type)";
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

    public static List<String> allAnimals() {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT name FROM animals")
                    .executeAndFetch(String.class);
        }
    }



}

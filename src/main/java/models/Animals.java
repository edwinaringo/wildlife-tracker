package models;
import java.util.Objects;
public abstract class Animals {
    public int id;
    public String name;
    public String age;
    public String health;
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

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animal = (Animals) o;
        return  Objects.equals(getName(), animal.getName()) &&
                Objects.equals(getHealth(), animal.getHealth()) &&
                Objects.equals(getAge(), animal.getAge()) &&
                getId() == animal.getId() &&
                Objects.equals(getType(), animal.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, age, type);
    }

}

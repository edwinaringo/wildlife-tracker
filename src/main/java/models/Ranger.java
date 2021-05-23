package models;

import java.util.Objects;

public class Ranger {
    private String name;
    private int id;

    public Ranger(String name, int id) {
        this.name = name;
        this.id = id;
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

}

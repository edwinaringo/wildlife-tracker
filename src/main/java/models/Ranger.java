package models;

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

}

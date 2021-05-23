package models;

public class EndangeredAnimals extends Animals{
    private static final String DATABASE_TYPE = "Endangered";

// Constructor.
    public EndangeredAnimals(String name, String age, String health) {
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = DATABASE_TYPE;
    }

}

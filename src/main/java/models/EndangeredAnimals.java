package models;

public class EndangeredAnimals extends Animals{
    private static final String DB_TYPE = "Endangered";

    public EndangeredAnimals(String name, String health, String age) {
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = DB_TYPE;
    }
}

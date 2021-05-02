package models;

public class SafeAnimals extends Animals{
    private static final String DB_TYPE = "Not Endangered";

    public SafeAnimals(String name, String health, String age) {
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = DB_TYPE;
    }

}

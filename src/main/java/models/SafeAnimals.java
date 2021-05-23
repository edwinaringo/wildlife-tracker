package models;

public class SafeAnimals extends Animals{
    private static final String DATABASE_TYPE = "Safe";

    public SafeAnimals(String name, String health, String age) {
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = DATABASE_TYPE;
    }

}

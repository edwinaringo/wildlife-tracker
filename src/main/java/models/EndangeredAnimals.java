package models;

public class EndangeredAnimals extends Animals{
    private String health;
    private String age;
    private static final String DB_TYPE = "Endangered";


    public EndangeredAnimals(String name, String age, String health) {
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = DB_TYPE;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public static String getDbType() {
        return DB_TYPE;
    }


}

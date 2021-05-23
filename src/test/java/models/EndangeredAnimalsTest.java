package models;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndangeredAnimalsTest {

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    private EndangeredAnimals otherAnimal() {
        return new EndangeredAnimals("Mammoth","Adult","Bad");
    }

    @Test
    public void endangeredAnimal_canInstantiateCorrectly_boolean(){
        EndangeredAnimals endangeredAnimals = otherAnimal();
        assertTrue(endangeredAnimals instanceof EndangeredAnimals);
    }

    @Test
    public void getAge_returnAnimalsAge_true(){
        EndangeredAnimals endangeredAnimals = otherAnimal();
        assertEquals("Adult", endangeredAnimals.getAge());
    }

    @Test
    public void getName_returnAnimalsName_true(){
        EndangeredAnimals endangeredAnimals = otherAnimal();
        assertEquals("Mammoth", endangeredAnimals.getName());
    }

    @Test
    public void getHealth_returnAnimalsHealth_true(){
        EndangeredAnimals endangeredAnimals = otherAnimal();
        assertEquals("Bad", endangeredAnimals.getHealth());
    }
}
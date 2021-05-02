package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SafeAnimalsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    private SafeAnimals otherAnimal() {
        return new SafeAnimals("Lion","Okay","Old");
    }

    @Test
    public void safeAnimals_CanInstantiateCorrectly_boolean(){
        SafeAnimals safeAnimals = otherAnimal();
        assertTrue(safeAnimals instanceof SafeAnimals);
    }

    @Test
    public void ageMethod_canGetSafeAnimalsAge_equals(){
        SafeAnimals safeAnimals = otherAnimal();
        assertEquals("Old", safeAnimals.getAge());
    }

    @Test
    public void nameMethod_canGetSafeAnimalsName_equals(){
        SafeAnimals safeAnimals = otherAnimal();
        assertEquals("Lion", safeAnimals.getName());
    }

    @Test
    public void healthMethod_canGetSafeAnimalsHealth(){
        SafeAnimals normalAnimal = otherAnimal();
        assertEquals("Okay", normalAnimal.getHealth());
    }
}
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
}
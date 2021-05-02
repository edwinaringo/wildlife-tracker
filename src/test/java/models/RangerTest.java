package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    private Ranger otherRanger(){
        return new Ranger("Nike",2);
    }

    @Test
    public void rangerClass_canInstantiateCorrectly(){
        Ranger ranger = otherRanger();
        assertTrue(ranger instanceof Ranger);
    }


}

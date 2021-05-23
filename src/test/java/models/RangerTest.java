package models;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangerTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    private Ranger otherRanger(){
        return new Ranger("Tyler",2);
    }

    @Test
    public void rangerClass_canInstantiateCorrectly_boolean(){
        Ranger ranger = otherRanger();
        assertTrue(ranger instanceof Ranger);
    }

    @Test
    public void getName_canGetRangerName_true(){
        Ranger ranger = otherRanger();
        assertEquals("Tyler",ranger.getName());
    }

    @Test
    public void getName_canGetRangerId_true(){
        Ranger ranger = otherRanger();
        assertEquals(2,ranger.getId());
    }


}

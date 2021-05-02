package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SightingsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    private Sightings otherSighting(){
        return new Sightings("Lion","West Wing",1);
    }

    @Test
    public void sightings_canInstantiateCorrectly_boolean(){
        Sightings sightings = otherSighting();
        assertTrue(sightings instanceof Sightings);
    }
}
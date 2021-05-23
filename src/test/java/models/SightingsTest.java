package models;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

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

    @Test
    public void sightings_canGetAnimalName_true() {
        Sightings sightings = otherSighting();
        assertEquals("Lion", sightings.getAnimalName());
    }

    @Test
    public void sightings_canGetRangerId_true() {
        Sightings sightings = otherSighting();
        assertEquals(1,sightings.getRangerid());
    }

    @Test
    public void sightings_canGetLocation_true() {
        Sightings sightings = otherSighting();
        assertEquals("West Wing", sightings.getLocation());
    }

    @Test
    public void sightings_canGetTimeStamp_true() {
        Sightings sightings = otherSighting();
        Timestamp testTimestamp = new Timestamp(new Date().getTime());
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        assertEquals(dateFormat.format(testTimestamp),dateFormat.format(sightings.getTimestamp()));
    }
}
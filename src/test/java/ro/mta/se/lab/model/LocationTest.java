package ro.mta.se.lab.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Duica Marius
 * testam constructorul clasei cat si functiile de get
 * locForTest_ va fi obiectul Location testat
 */
public class LocationTest {

    private Location locForTest_;
    @Before
    public void setUp() throws Exception {
        this.locForTest_=new Location("683506","Bucharest","Romania");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getId_() {
        assertEquals("683506",this.locForTest_.getId_());
    }

    @Test
    public void getLocation_Name_() {
        assertEquals("Bucharest",this.locForTest_.getLocation_Name_());
    }

    @Test
    public void getLocationCountry_() {
        assertEquals("Romania",this.locForTest_.getLocationCountry_());
    }
}
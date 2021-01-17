package ro.mta.se.lab.model;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class MockitoJava_Test {
    ILocationMock_Test mock_test;
    Location loc;

    @Before
    public void setup()
    {
        mock_test=mock(ILocationMock_Test.class);
        when(mock_test.getId_()).thenReturn("683506");
        when(mock_test.getLocation_Name_()).thenReturn("Bucharest");
        when(mock_test.getLocationCountry_()).thenReturn("Romania");
        loc=new Location(mock_test);
    }


    @Test
    public void check()
    {
        assertEquals(loc.getLocation_Name_(),"Bucharest");
        assertEquals(loc.getId_(),"683506");
        assertEquals(loc.getLocationCountry_(),"Romania");

    }


}

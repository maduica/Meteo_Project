package ro.mta.se.lab.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class JsonAnalyzerTest {
    JsonAnalyzer jsonObject_forTest_;

    @Before
    public void setUp() throws Exception {
       String filecontent_ = Files.readString(Path.of("src/test/test.json"), StandardCharsets.US_ASCII);
       this.jsonObject_forTest_=new JsonAnalyzer(filecontent_);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void get_TEMP_() {
        assertEquals(this.jsonObject_forTest_.get_TEMP_(),"282.54");
    }

    @Test
    public void get_Action() {
        assertEquals(this.jsonObject_forTest_.get_Action(),"282.54");
    }
}
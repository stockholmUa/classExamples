package com.sourceit.courses.devs.classes.class12.example02;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;


public class MessTest {
    protected Mess mess;

    @Before
    public void setUp() throws Exception {
        System.out.println("Method setUp");
        mess = new Mess();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Method tearDown");
    }

    @Test
    public void testConvertToSymbolArray() throws Exception {
        String[] expectedArray = {"1", "2", "3"};

        String[] resultArray =  mess.convertToSymbolArray("1 2 3");

        assertArrayEquals(expectedArray, resultArray);
    }

    @Test(timeout = 10)
    public void concutTest() throws Exception {
        String result =  mess.concut("one", "two");

        Thread.sleep(20);
        assertEquals("onetwo", result);
    }

    @Ignore("This method does not work yet")
    @Test
    public void concutTest02() throws Exception {
        String result =  mess.concut("one", "two");

        assertEquals("onetwo", result);
    }
}

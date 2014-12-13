package com.sourceit.courses.devs.classes.class12;


import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class Example04 {
    public static Matcher customMatches(final Object expected){

        return new BaseMatcher() {

            protected Object theExpected = expected;

            public boolean matches(Object o) {
                return theExpected.equals(o);
            }

            public void describeTo(Description description) {
                description.appendText(theExpected.toString() + " Text");
            }
        };
    }

    @Parameterized.Parameters
    public static Collection cValues() {
        return Arrays.asList(new Object[][]{
                {"ASA", "ASA"},
                {"NASA", "NASA"},
                {"KASDRS", "ASA"},
                {"SDFGHJ", "SDFGHJ"}});
    }

    private String param01;
    private String param02;

    public Example04(String param01, String param02) {
        this.param01 = param01;
        this.param02 = param02;
    }

    @Test
    public void testGetTheSame() throws Exception {
        assertEquals("Pattern did not validate zip code", param01, param02);
    }
}

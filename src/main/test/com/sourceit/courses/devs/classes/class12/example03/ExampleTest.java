package com.sourceit.courses.devs.classes.class12.example03;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class ExampleTest {

    public static Matcher customeMatches(final Object expected){

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


    @Test
    public void testGetTheSame() throws Exception {
        assertThat(Example.getTheSame(3), is(3));

//        assertThat(Example.getTheSame(3), describedAs("Some text", is(2)));

        assertThat("Hello", is(allOf(notNullValue(), instanceOf(String.class), equalTo("Hello"))));
//        assertThat(Example.getTheSame(3), not(is(3)));

        assertThat("DDD", customeMatches("D"));

    }




    @Test
    public void allOfExampleShowsAllMatchersMustAllBeTrue() throws Exception {
        assertThat("Hello", allOf(notNullValue(), instanceOf(String.class), equalTo("Hello")));
    }

    @Test
    public void allOfExampleShowsFailingIfOneMatcherDoesNotMatch() throws Exception {
        assertThat("Hello", is(not(allOf(notNullValue(), instanceOf(Integer.class)))));
    }

    @Test
    public void anyExampleChecksThatClassIsOfSameType() throws Exception {
        assertThat("Hello", is(any(String.class)));
    }

    @Test
    public void anyExampleShowsStringIsAlsoAnObject() throws Exception {
        assertThat("Hello", is(any(Object.class)));
    }

    @Test
    public void anyOfExampleReturnsTrueIfOneMatches() throws Exception {
        assertThat("Hello", is(anyOf(nullValue(), instanceOf(String.class), equalTo("Goodbye"))));
    }

    @Test
    public void anyOfExampleFailingIfAllMatchersAreFalse() throws Exception {
        assertThat("Hello", is(not(anyOf(nullValue(), instanceOf(Integer.class), equalTo("Goodbye")))));
    }

    @Test
    public void anythingExampleAlwaysReturnsTrue() throws Exception {
        assertThat("Hello", is(anything()));
    }

    @Test
    public void equalToExampleAddingTwoPlusTwo() throws Exception {
        assertThat(2 + 2, is(equalTo(4)));
    }

    @Test
    public void instanceOfExampleForString() throws Exception {
        assertThat("Hello", is(instanceOf(String.class)));
    }

    @Test
    public void isExampleShortCutForIsInstanceOfClass() throws Exception {
        assertThat("Hello", is(String.class));
        assertThat("Hello", instanceOf(String.class));
    }

    @Test
    public void isExampleShortCutAsJustSyntacticSugarUsedThreeTimes() throws Exception {
        assertThat("Hello", is(is(is(notNullValue()))));
    }

    @Test
    public void isExampleShortCutForIsEqualTo() throws Exception {
        assertThat("Hello", is("Hello"));
        assertThat("Hello", equalTo("Hello"));
    }

    @Test
    public void notExampleJustInvertsExpression() throws Exception {
        assertThat("Hello", is(not(instanceOf(Integer.class))));
    }

    @Test
    public void notNullValueExampleForString() throws Exception {
        assertThat("Hello", is(notNullValue()));
    }

    @Test
    public void notNullValueExampleForAClass() throws Exception {
        assertThat("Hello", is(notNullValue(Object.class)));
    }

    @Test
    public void nullValueExampleWithANull() throws Exception {
        assertThat(null, is(nullValue()));
    }

    @Test
    public void nullValueExampleWithANullType() throws Exception {
        Integer nothing = null;
        assertThat(nothing, is(nullValue(Integer.class)));
    }

    @Test
    public void sameInstanceExample() throws Exception {
        Object object = new Object();
        Object sameObject = object;
        assertThat(object, is(sameInstance(sameObject)));
    }

}

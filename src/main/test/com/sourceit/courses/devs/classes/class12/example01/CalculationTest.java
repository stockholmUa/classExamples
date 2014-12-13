package com.sourceit.courses.devs.classes.class12.example01;

import junit.framework.TestCase;
import junit.framework.TestResult;


public class CalculationTest extends TestCase {

    protected Calculation calc;

    public CalculationTest() {
        super();
    }

    public CalculationTest(String str) {
        super(str);
    }

    public void setUp() throws Exception {
        super.setUp();
        System.out.println("Method setUp");
        calc = new Calculation();

    }

    public void tearDown() throws Exception {
        System.out.println("Method tearDown");
    }

    public void testAdd() throws Exception {
        System.out.println("Method testAdd");
        assertEquals("Add method have trouble with adding two int values", 5, calc.add(2, 3));
    }

    public void testSubtract() throws Exception {
        System.out.println("Method testSubtract");
        assertTrue("Subtract method have trouble with logic", 5 == calc.subtract(8, 3));
    }

//    Do not start with test, as the result was ignored
    public void addTest() throws Exception {
        System.out.println("Method testAdd");
        assertEquals("Add method have trouble with adding two int values", 5, calc.add(2, 3));
    }

    public static void main(String[] args) {
        CalculationTest test = new CalculationTest("testAdd");
        TestResult result = test.run();
        result.failures();
    }
}

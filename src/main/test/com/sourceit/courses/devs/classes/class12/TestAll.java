package com.sourceit.courses.devs.classes.class12;



import com.sourceit.courses.devs.classes.class12.example02.MessTest;
import com.sourceit.courses.devs.classes.class12.example03.ExampleTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({MessTest.class, ExampleTest.class})
public class TestAll {}

package com.sourceit.courses.devs.classes.class10;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class Log4jTest {
    static final Logger logger = Logger.getLogger(Log4jTest.class);

    public static void main(String[] args) {
        //Configure logger
        //BasicConfigurator.configure();
        logger.debug("Test message!");
    }
}

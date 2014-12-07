package com.sourceit.courses.devs.classes.class09.example06;

import java.util.concurrent.TimeUnit;

/**
 * Storage can hold only one number at a time. The boolean flag represent its holding ability.
 * The class would have two methods which provide ability to put and get the number.
 */
public class Storage {

    /**
     * Method return the stored number from the storage object.
     *      - check for the data presence, if the data is not present
     *      then unblock the monitor and suspend the thread
     *      - print the number which has been taken from storage
     *      - trigger the flag to empty
     *      - wait for 1 second
     *      - allow other threads that the operation was finished
     * @return stored value
     */


    /**
     * Method place a number to be stored in the object.
     *      - check for the data presence, if the data is present
     *      then unblock the monitor and suspend the thread
     *      - place a new number into internal storage object
     *      - trigger the flag to presence
     *      - print the number which has been placed into storage
     *      - wait for 1 second
     *      - allow other threads that the operation was finished
     * @param n a value to be stored
     */


    public static void main(String[] args) {
        // Enter code to test Storage
    }

}

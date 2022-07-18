/*
 * Copyright (c) 2022
 * For Implemica
 */
package com.alexandertuleninov.implemica.taskthree;

import org.junit.*;
import java.math.BigInteger;
import static org.junit.Assert.*;

/**
 * This class is designed to test the TaskThreeFactorial.class.
 * @version 01
 *
 * @author Alexander Tuleninov
 * */
public class TaskThreeFactorialTest {
    BigInteger validReferenceNumber;
    int number;
    int validSumDigitsNumber;

    @Before
    public void init() {
        validReferenceNumber = new BigInteger("9332621544394415268169923885626670049071596"
                               + "826438162146859296389521759999322991560894146397615651828625"
                               + "3697920827223758251185210916864000000000000000000000000");
        number = 100;
        validSumDigitsNumber = 648;
    }

    @After
    public void cleaningData() {
        validReferenceNumber = null;
    }

    /**
     * The method tests the getFactorial() method of the TaskThreeFactorial class.
     * @number                      the given number, it's 100
     * @validReferenceNumber        the correct value of the factorial of the number 100
     * */
    @Test
    public void validReferenceNumber() {
        assertEquals(validReferenceNumber, TaskThreeFactorial.getFactorial(number));
    }

    /**
     * The method tests the sumDigits() method of the TaskThreeFactorial.class.
     * @number                      the given number, it's 100
     * @validSumDigitsNumber        the correct value of the factorial of the number 100
     * */
    @Test
    public void validSumDigits() {
        assertEquals(validSumDigitsNumber, TaskThreeFactorial.sumDigits(TaskThreeFactorial.getFactorial(number)));
    }
}
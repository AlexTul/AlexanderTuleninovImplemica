/*
 * Copyright (c) 2022
 * For Implemica
 */
package com.alexandertuleninov.implemica.taskthree;

import org.apache.log4j.LogManager;
import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * This class is designed to perform a test task from Implemica.
 * Task: Find the sum of the digits in the number 100! (i.e. 100 factorial)
 * {Correct answer: 648}
 * @version 01
 *
 * @author Alexander Tuleninov
 */
public class TaskThreeFactorial {
    private static final org.apache.log4j.Logger LOG = LogManager.getLogger(TaskThreeFactorial.class);

    public static void main(String[] args) {
        LOG.info(sumDigits(getFactorial(100)));
    }

    /**
     * The method calculates the factorial of the given number.
     * @param number                 the given number
     * @return                       the factorial of the given number
     * */
    public static BigInteger getFactorial(int number) {
        if (number < 2) {
            return BigInteger.valueOf(1);
        }
        else {
            return IntStream.rangeClosed(2, number).mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
        }
    }

    /**
     * The method calculates the sum of the digits of the factorial of the given number.
     * @param factorial            the method parameter, it's the factorial of the given number
     * @zero                       the object to compare objects
     * @separator                  the divisor and remainder divisor
     * @return sum                 is the sum of the digits of the factorial of the given number
     * */
    public static int sumDigits(BigInteger factorial) {
        BigInteger sum = BigInteger.valueOf(0);
        BigInteger zero = BigInteger.valueOf(0);
        int separator = 10;
        while(factorial.compareTo(zero) > 0) {
            sum = sum.add(factorial.remainder(BigInteger.valueOf(separator)));
            factorial = factorial.divide(BigInteger.valueOf(separator));
        }
        return sum.intValue();
    }
}

/*
 * Copyright (c) 2022
 * For Implemica
 */
package com.alexandertuleninov.implemica.taskone;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * This class is designed to test the TaskOneCorrectBracketExpressions.class.
 * @version 01
 *
 * @author Alexander Tuleninov
 */
public class TaskOneCorrectNumberTest {
    /**
     * The method tests the countsCorrectBracketExpressions() method of the TaskOneCorrectBracketExpressions.class.
     * @numberNull                 the number to test is 0
     * @numberThree                the number to test is 3
     * @validNumberNull            the correct value
     * @validNumberFife            the correct value
     * */
    @Test
    public void validIntegerNumberExamples() {
        int numberNull = 0;
        int validNumberNull = 0;
        Assert.assertEquals(validNumberNull, TaskOneCorrectBracketExpressions.countsCorrectBracketExpressions(numberNull));

        int numberThree = 3;
        int validNumberFife = 5;
        assertEquals(validNumberFife, TaskOneCorrectBracketExpressions.countsCorrectBracketExpressions(numberThree));
    }
}
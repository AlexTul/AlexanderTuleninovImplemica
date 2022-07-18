/*
 * Copyright (c) 2022
 * For Implemica
 */
package com.alexandertuleninov.implemica.tasktwo;

import org.junit.*;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * Class is designed to test the DijkstraAlgorithm.class.
 * @version 01
 *
 * @author Alexander Tuleninov
 * */
public class DijkstraAlgorithmTest {
    private DijkstraAlgorithm dA;
    private List<String> NAME;
    private int[][] costMatrix;

    @Before
    public void init() {
        NAME = Arrays.asList("gdansk", "bydgoszcz", "torun", "warszawa");
        costMatrix = new int[][]{{0, 1, 3, 0},
                                 {1, 0, 1, 4},
                                 {3, 1, 0, 1},
                                 {0, 4, 1, 0}};

        int n = 4;
        dA = new DijkstraAlgorithm(n, costMatrix);
    }

    @After
    public void cleaningData() {
        dA = null;
        NAME = null;
        costMatrix = null;
    }

    /**
     * The method tests the findDistancesFromTo() method of the DijkstraAlgorithm.class.
     * @validNumberThree            the correct value for distance test between "gdansk" and "warszawa"
     * @validNumberTwo              the correct value for distance test between "bydgoszcz" and "warszawa"
     * */
    @Test
    public void validNumberThreeAndTwo() {
        int validNumberThree = 3;
        assertEquals(validNumberThree, dA.findDistancesFromTo(NAME.indexOf("gdansk"), NAME.indexOf("warszawa")));

        int validNumberTwo = 2;
        assertEquals(validNumberTwo, dA.findDistancesFromTo(NAME.indexOf("bydgoszcz"), NAME.indexOf("warszawa")));
    }
}
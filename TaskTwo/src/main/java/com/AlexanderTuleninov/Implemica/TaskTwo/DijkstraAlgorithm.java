/*
 * Copyright (c) 2022
 * For Implemica
 */
package com.AlexanderTuleninov.Implemica.TaskTwo;

import lombok.AllArgsConstructor;

/**
 * Class for finding minimum cost paths between
 * pairs of cities using Dijkstra's Algorithm.
 * @version 01
 *
 * @author Alexander Tuleninov
 * */
@AllArgsConstructor
public class DijkstraAlgorithm {
    private  final int n;
    private final int[][] costMatrix;

    /**
     * The method finds minimum cost paths between pairs of cities.
     * @param startPoint        the source
     * @param endPoint          the destination
     * @[]distance              the array containing the minimum distance between a pair of cities
     * @[]peaksVisited          the array containing vertex visit data
     * @temp                    the buffer variable
     * @minIndexGraph           the index characterizing the addition of a vertex to the graph
     * @minDistance             the index characterizing the presence of a minimum distance
     * @return                  the minimum cost between pairs of cities
     * */
    public int findDistancesFromTo(int startPoint, int endPoint) {
        int UNATTAINABLE_NUMBER = Integer.MAX_VALUE;
        int[] distance = new int[n];
        int[] peaksVisited = new int[n];
        int temp;
        int minIndexGraph;
        int minDistance;

        for (int i = 0; i < n; i++) {
            distance[i] = UNATTAINABLE_NUMBER;
            peaksVisited[i] = 1;
        }
        distance[startPoint] = 0;

        // Algorithm step
        do {
            minIndexGraph = UNATTAINABLE_NUMBER;
            minDistance = UNATTAINABLE_NUMBER;

            // If the vertex has not yet been bypassed, add the minimum distance and the vertex to the graph
            for (int i = 0; i < n; i++) {
                if ((peaksVisited[i] == 1) && (distance[i] < minDistance)) {
                    minDistance = distance[i];
                    minIndexGraph = i;
                }
            }

            /* If the vertex is added to the graph,
             * add the found minimum distance to the current vertex distance
             * and compare with the current minimum vertex distance */
            if (minIndexGraph != UNATTAINABLE_NUMBER) {
                for (int i = 0; i < n; i++) {
                    if (costMatrix[minIndexGraph][i] > 0) {
                        temp = minDistance + costMatrix[minIndexGraph][i];
                        if (temp < distance[i]) {
                            distance[i] = temp;
                        }
                    }
                }
                peaksVisited[minIndexGraph] = 0;
            }
        } while (minIndexGraph < UNATTAINABLE_NUMBER);
        return distance[endPoint];
    }
}

/*
 * Copyright (c) 2022
 * For Implemica
 */
package com.alexandertuleninov.implemica.taskone;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.Scanner;

/**
 * This class is designed to perform a test task from Implemica.
 * Task: Если мы из корректно записанного арифметического выражения, содержащего числа, знаки операций и открывающие
 * и закрывающие круглые скобки выбросим числа и знаки операций, а затем запишем оставшиеся в выражении скобки без
 * пробелов между ними, то полученный результат назовем правильным скобочным выражением [скобочное выражение "(()(()))"
 * - правильное, а "()(" и "())(" - нет].
 * Найти число правильных скобочных выражений, содержащих N открывающихся и N закрывающихся скобок. N вводится с
 * клавиатуры. N неотрицательное целое число.
 * @version 01
 *
 * @author Alexander Tuleninov
 */
public class TaskOneCorrectBracketExpressions {
    private static final Logger LOG = LogManager.getLogger(String.valueOf(TaskOneCorrectBracketExpressions.class));

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LOG.info(countsCorrectBracketExpressions(in.nextInt()));
        in.close();
    }

    /** The method counts correct bracket expressions, which is the Catalan number.
     * @param number                    the number entered by the user
     * @[]arrayAuxiliary                the auxiliary array
     * @return                          the correct bracket expressions
     * */
    static long countsCorrectBracketExpressions(int number) {
           if (number > 0) {
            long[] arrayAuxiliary = new long[number + 1];
            arrayAuxiliary[0] = 1;
            for (int i = 1; i <= number; i++) {
                arrayAuxiliary[i] = 0;
                for (int j = 0; j < i; j++) {
                    arrayAuxiliary[i] += arrayAuxiliary[j] * arrayAuxiliary[i - 1 - j];
                }
            }
            return arrayAuxiliary[number];
        } else {
            return 0;
        }
    }
}

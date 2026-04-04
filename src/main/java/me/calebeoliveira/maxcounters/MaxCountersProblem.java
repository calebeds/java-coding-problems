package me.calebeoliveira.maxcounters;

import java.util.Arrays;

public class MaxCountersProblem {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(naiveSolution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
        System.out.println(Arrays.toString(solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
    }

    private static int[] solution(int size, int[] array) {
        int[] counters = new int[size];
        int maxCounter = 0;
        int newStartingPoint = 0;
        for(int i = 0; i < array.length; i++) {
            int pos = array[i];
            if(pos > size) {
                newStartingPoint = maxCounter;
            } else {

                int index = pos - 1;
                if(counters[index] < newStartingPoint) {
                        counters[index] = newStartingPoint;
                }

                counters[index] += 1;
                if(counters[index] > maxCounter) {
                    maxCounter = counters[index];
                }
            }
        }

        for(int i = 0; i < counters.length; i++) {
            if(counters[i] < newStartingPoint) {
                counters[i] = newStartingPoint;
            }
        }

        return counters;
    }

    private static int[] naiveSolution(int size, int[] array) {
        int[] counters = new int[size];
        int maxCounter = 0;
        for(int i = 0; i < array.length; i++) {
            int pos = array[i];
            if(pos > size) {
                for(int j = 0; j < counters.length; j++) {
                    counters[j] = maxCounter;
                }
            } else {
                int index = pos - 1;
                counters[index] += 1;
                if(counters[index] > maxCounter) {
                    maxCounter = counters[index];
                }
            }
        }

        return counters;
    }
}

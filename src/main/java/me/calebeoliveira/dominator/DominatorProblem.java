package me.calebeoliveira.dominator;

import java.util.Arrays;

public class DominatorProblem {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 1, 1, 4, 1, 1}));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    private static int solution(int[] array) {
        int consecutiveSize = 0;
        int candidate = 0;

        for(int item: array) {
            if(consecutiveSize == 0) {
                candidate = item;
                consecutiveSize++;
            } else if(candidate == item) {
                consecutiveSize++;
            } else {
                consecutiveSize--;
            }
        }

        int occurence = 0;
        int index = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == candidate) {
                occurence++;
                index = i;
            }
        }

        return occurence > array.length / 2.0 ? index : -1;
    }
}

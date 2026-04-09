package me.calebeoliveira.minabssumoftwo;

import java.util.Arrays;

public class MinAbsSumOfTwo {
    public static void main(String[] args) {
        System.out.println(sumOfTwoBruteForce(new int[]{-8, 4, 5, -10, 3}));
        System.out.println(solution(new int[]{-8, 4, 5, -10, 3}));
    }

    private static int solution(int[] array) {
        int minAbsSumOfTwo = Integer.MAX_VALUE;
        Arrays.sort(array);
        int head = 0;
        int tail = array.length - 1;

        while (head <= tail) {
            minAbsSumOfTwo = Math.min(minAbsSumOfTwo, Math.abs(array[head] + array[tail]));
            if(array[head] + array[tail] < 0) {
                head++;
            } else {
                tail--;
            }
        }

        return minAbsSumOfTwo;
    }

    private static int sumOfTwoBruteForce(int[] array) {
        int sum = Integer.MAX_VALUE;
        int head = 0;

        for(int tail = 0; tail < array.length; tail++) {
            while (head < array.length) {
                int currentSum = Math.abs(array[head] + array[tail]);

                if(currentSum < sum) {
                    sum = currentSum;
                }

                head++;
            }
        }

        return sum;
    }
}

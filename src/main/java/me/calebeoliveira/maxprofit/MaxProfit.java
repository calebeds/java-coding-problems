package me.calebeoliveira.maxprofit;

public class MaxProfit {
    public static void main(String[] args) {
        int[] array = new int[] {114, 132, 119, 91, 84, 29, 61, 76, 38, 21, 9, 63, 45, 68, 81, 124, 118, 78, 44, 59, 80};
        System.out.println(solution(array));
    }

    private static int solution(int[] array) {
        int globalMaxSum = 0;
        int localMaxSum = 0;
        for(int i = 1; i < array.length; i++) {
            int d = array[i] - array[i - 1];
            localMaxSum = Math.max(d, localMaxSum + d);
            globalMaxSum = Math.max(localMaxSum, globalMaxSum);
        }

        return globalMaxSum;
    }
}

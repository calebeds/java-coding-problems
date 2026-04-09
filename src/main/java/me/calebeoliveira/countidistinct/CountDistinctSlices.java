package me.calebeoliveira.countidistinct;

public class CountDistinctSlices {
    public static void main(String[] args) {
        System.out.println(solution(9 , new int[]{2, 4, 1, 7, 4, 9, 7, 3, 5, 5, 8, 7, 1}));
    }

    private static int solution(int m, int[] array) {
        int totalSlices = 0;
        boolean[] inCurrentSlice = new boolean[m + 1];
        int head = 0;
        for(int tail = 0; tail < array.length; tail++) {
            while (head < array.length && !inCurrentSlice[array[head]]) {
                inCurrentSlice[array[head]] = true;
                totalSlices += (head - tail) + 1;
                head += 1;
                if(totalSlices > 1_000_000_000) {
                    totalSlices = 1_000_000_000;
                }
            }
            inCurrentSlice[array[tail]] = false;
        }

        return totalSlices;
    }
}

package me.calebeoliveira.passingcars;

public class PassingCars {
    public static void main(String[] args) {

        System.out.println(otherSolution(new int[]{0, 1, 0, 1, 1}));
        System.out.println(solution(new int[]{0, 1, 0, 1, 1}));
    }

    private static int solution(int[] array) {
        int[] suffixSum = new int[array.length + 1];
        int count = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            suffixSum[i] = array[i] + suffixSum[i + 1];
            if(array[i] == 0) {
                count += suffixSum[i];
            }

            if(count > 1_000_000_000) {
                return -1;
            }
        }

        return count;
    }

    private static int otherSolution(int[] array) {
        int zeroCounter = 0;
        int[] numberOfZeros = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                zeroCounter++;
            } else {
                numberOfZeros[i] = zeroCounter;
            }
        }

        int sum = 0;

        for(int i = 0; i < array.length; i++) {
            sum += numberOfZeros[i];
        }

        return sum;
    }
}

package me.calebeoliveira.equilibrium;

public class TapeEquilibriumProblem {
    public static void main(String[] args) {
        System.out.println(equilibriumNaiveSolution(new int[]{3, 1, 2, 4, 3}));
        System.out.println(equilibriumSolution(new int[]{3, 1, 2, 4, 3}));
    }

    private static int equilibriumSolution(int[] array) {
        int sumLeft = array[0];

        int sumRight = 0;
        for (int i = 1; i < array.length; i++) {
            sumRight += array[i];
        }

        int diff = Math.abs(sumLeft - sumRight);

        for(int i = 1; i < array.length - 1; i++) {
            sumLeft += array[i];
            sumRight -= array[i];

            int currentDiff = Math.abs(sumLeft - sumRight);
            if(currentDiff < diff) {
                diff = currentDiff;
            }
        }

        return diff;
    }

    private static int equilibriumNaiveSolution(int[] array) {
        int smallestSum = Integer.MAX_VALUE;

        for(int i = 1; i < array.length; i++) {
            int sumLeft = 0;
            for(int j = 0; j < i; j++) {
                sumLeft += array[j];
            }

            int sumRight = 0;
            for(int j = i; j < array.length; j++) {
                sumRight += array[j];
            }

            int abs = Math.abs(sumLeft - sumRight);

            if(abs < smallestSum) {
                smallestSum = abs;
            }
        }

        return smallestSum;
    }
}

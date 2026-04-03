package me.calebeoliveira.perm;

public class PermMissingElem {
    public static void main(String[] args) {
        System.out.println(sumSolution(new int[]{2, 3, 1, 5}));
        System.out.println(sumSolution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(sumSolution(new int[]{}));
    }

    public static int sumSolution(int[] array) {
        long actualSum = 0;
        for(int number: array) {
            actualSum += number;
        }

        long maxNumber = array.length + 1;
        long expectedSum = (maxNumber * (maxNumber + 1)) / 2;
        return (int) (expectedSum - actualSum);
    }

    public static int newArraySolution(int[] array) {
        int[] table = new int[array.length + 2];

        for(int i = 0; i < array.length; i++) {
            table[array[i]] = 1;
        }

        for(int i = 1; i < table.length; i++) {
            if(table[i] != 1) {
                return i;
            }
        }

        return -1;
    }

    public static int permNaiveSolution(int[] array) {
        for(int i = 1; i < array.length + 1; i++) {
            boolean found = false;
            for(int j = 0; j < array.length; j++) {
                if(i == array[j]) {
                    found = true;
                }
            }
            if(!found) {
                return i;
            }
        }

        return -1;
    }
}

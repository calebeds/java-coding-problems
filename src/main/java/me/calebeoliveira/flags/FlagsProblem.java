package me.calebeoliveira.flags;

public class FlagsProblem {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
    }

    private static int solution(int[] array) {
        int[] peaks = new int[array.length];
        int nextPeak = array.length;

        peaks[array.length - 1] = nextPeak;
        for(int i = array.length -2; i > 0; i--) {
            if (array[i - 1] < array[i] && array[i + 1] < array[i]) {
                nextPeak = i;
            }
            peaks[i] = nextPeak;
        }

        peaks[0] = nextPeak;

        int currentGuess = 0;
        int nextGuess = 0;

        while (canPlaceFlags(peaks, nextGuess)) {
            currentGuess = nextGuess;
            nextGuess++;
        }

        return  currentGuess;
    }

    private static boolean canPlaceFlags(int[] peaks, int flagsToPlace) {
        int currentPosition = 1 - flagsToPlace;
        for(int i = 0; i < flagsToPlace; i++) {
            if(currentPosition + flagsToPlace > peaks.length - 1) {
                return false;
            }
            currentPosition = peaks[currentPosition + flagsToPlace];
        }

        return currentPosition < peaks.length;
    }


}

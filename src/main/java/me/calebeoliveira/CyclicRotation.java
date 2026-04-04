package me.calebeoliveira;

import java.util.Arrays;

public class CyclicRotation {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(array, 2)));
        System.out.println(Arrays.toString(solution(array, 5)));
    }

    private static int[] solution(int[] array, int rotations) {
      int[] newArray = new int[array.length];
      for(int i = 0; i < array.length; i++) {
          int newPosition = (i + rotations) % array.length;
          newArray[newPosition] = array[i];
      }

      return newArray;
    }
}

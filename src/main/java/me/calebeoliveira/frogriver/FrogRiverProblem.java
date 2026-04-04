package me.calebeoliveira.frogriver;

import java.util.HashMap;

public class FrogRiverProblem {
    public static void main(String[] args) {
        int[] array = {1, 3, 1, 4, 2, 3, 5, 4};
        int[] array2 = {1, 1, 1};
        int[] array3 = {1, 2, 1};

        System.out.println(solution(5, array));
        System.out.println(solution2(5, array));
        System.out.println(solution2(1, array2));
        System.out.println(solution2(3, array3));
    }

    private static int solution2(final int riverSize, final int[] array) {
        boolean[] slots = new boolean[array.length + 1];
        int counter = riverSize;

        for(int time = 0; time < array.length; time++) {
            boolean slot = slots[array[time]];
            if(!slot) {
                slots[array[time]] = true;
                counter--;

                if(counter == 0) {
                    return time;
                }
            }
        }

        return -1;
    }

    private static int solution(int riverSize, int[] array) {
        HashMap<Integer, Integer> slots = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            slots.merge(array[i], 1, (v1, v2) -> v1 + v2);
            if(slots.size() == riverSize) {
                return i;
            }
        }

        return -1;
    }
}

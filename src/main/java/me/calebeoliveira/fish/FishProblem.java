package me.calebeoliveira.fish;

import java.util.Arrays;
import java.util.Stack;

public class FishProblem {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 8, 2, 6, 7}, new int[]{0, 1, 1, 0, 0}));
        System.out.println(solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
    }

    private static int solution(int[] sizes, int[] directions) {
        int survivors = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < directions.length; i++) {
           int weight = sizes[i];
           if(directions[i] == 1) {
               stack.push(weight);
           } else {
               int weightDown = stack.isEmpty() ? -1 : stack.pop();
               while (weightDown != -1 && weightDown < weight) {
                   weightDown = stack.isEmpty() ? -1 : stack.pop();
               }
               if(weightDown == -1) {
                   survivors++;
               } else {
                   stack.push(weightDown);
               }
           }
        }

        return survivors + stack.size();
    }
}

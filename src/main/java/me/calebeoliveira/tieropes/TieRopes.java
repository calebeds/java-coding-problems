package me.calebeoliveira.tieropes;

public class TieRopes {
    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{1, 2, 3, 4, 1, 1, 3}));
    }

    private static int solution(int k, int[] array) {
       int count = 0;
       int ropeLength = 0;

       for(int rope: array) {
           ropeLength += rope;
           if(ropeLength >= k) {
               count++;
               ropeLength = 0;
           }
       }

       return count;
    }
}

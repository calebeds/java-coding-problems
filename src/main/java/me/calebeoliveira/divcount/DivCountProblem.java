package me.calebeoliveira.divcount;

public class DivCountProblem {
    public static void main(String[] args) {
        System.out.println(solution(4, 14, 2));
    }

    private static int solution(int a, int b, int k) {
        double nStart = Math.ceil(a / (double) k);
        double nEnd = Math.floor(b / (double) k);
        return (int) (nEnd - nStart + 1);
    }
}

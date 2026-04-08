package me.calebeoliveira.chocalates;

public class ChocolatesProblem {
    public static void main(String[] args) {

        System.out.println(otherSolution(10, 4));
        System.out.println(otherSolution(9, 6));
        System.out.println(solution(10, 4));
        System.out.println(solution(9, 6));
        System.out.println(solution(10, 11));
    }

    private static int findGcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return findGcd(b, a % b);
    }

    private static int solution(int n, int m) {
        return n / findGcd(n, m);
    }

    private static int otherSolution(int numberOfChocolates, int stepsToEat) {
        boolean[] array = new boolean[numberOfChocolates];
        int eaten = 0;
        for(int i = 0; i < array.length;) {
            if(!array[i]) {
                eaten++;
                array[i] = true;
                i = (i + stepsToEat) % numberOfChocolates;
            } else {
                break;
            }
        }

        return eaten;
    }
}

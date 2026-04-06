package me.calebeoliveira.discintersection;

import java.util.Arrays;

public class DiscIntersectionProblem {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5, 2, 1, 4, 0}));
    }

    static class DiscLog implements Comparable<DiscLog> {
        final long x;
        final int startEnd;

        public DiscLog(long x, int startEnd) {
            this.x = x;
            this.startEnd = startEnd;
        }

        @Override
        public int compareTo(DiscLog b) {
            return this.x != b.x ? Long.compare(this.x, b.x) : Integer.compare(b.startEnd, this.startEnd);
        }
    }

    private static int solution(int[] array) {
        int len = array.length;
        DiscLog[] discHistory = new DiscLog[len * 2];
        int j = 0;
        for(int i = 0; i < len; i++) {
            discHistory[j++] = new DiscLog(i - (long) array[i], 1);
            discHistory[j++] = new DiscLog(i + (long) array[i], -1);
        }

        Arrays.sort(discHistory);
        int intersections = 0;
        int activeIntersections = 0;

        for(DiscLog log: discHistory) {
            activeIntersections += log.startEnd;
            if(log.startEnd > 0) {
                intersections += activeIntersections - 1;
            }
            if(intersections > 10_000_000) {
                return -1;
            }
        }

        return intersections;
    }
}

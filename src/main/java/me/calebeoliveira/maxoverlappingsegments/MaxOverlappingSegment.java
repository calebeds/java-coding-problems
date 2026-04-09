package me.calebeoliveira.maxoverlappingsegments;

public class MaxOverlappingSegment {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 7, 9, 9}, new int[]{5, 6, 8, 9, 10}));
    }

    private static int solution(int[] startArray, int[] endArray) {
        int lastEndSegment = -1;
        int count = 0;

        for(int i = 0; i < startArray.length; i++) {
            if(startArray[i] > lastEndSegment) {
                count++;
                lastEndSegment = endArray[i];
            }
        }

        return count;
    }
}

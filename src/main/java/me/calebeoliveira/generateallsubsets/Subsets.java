package me.calebeoliveira.generateallsubsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(final int[] nums,
                           final int start,
                           final List<Integer> current,
                           final List<List<Integer>> result) {
        // Add current subset to result
        result.add(new ArrayList<>(current));

        // Try adding each remaining element
        for(int i = start; i < nums.length; i++) {
            // choose
            current.add(nums[i]);

            // explore with this choice
            backtrack(nums, i + 1, current, result);

            // backtrack (undo choice)
            current.removeLast();
        }
    }
}

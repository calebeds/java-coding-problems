package me.calebeoliveira.permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(final int[] nums,
                           final boolean[] used,
                           final List<Integer> current,
                           final List<List<Integer>> result) {

        // Base case: complete permutation
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                used[i] = true;
                current.add(nums[i]);

                backtrack(nums, used, current, result);

                used[i] = false;
                current.removeLast();
            }
        }

    }
}

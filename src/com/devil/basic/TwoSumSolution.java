package com.devil.basic;

import java.util.HashMap;

/**
 * 求一个数组中两个数相加等于目标值的下标
 *
 * @author Devil
 * @date Created in 2021/6/25 15:34
 */
public class TwoSumSolution {

    public int[] solutionOne(int[] nums, int target) {
        int[] result;
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        if (nums.length == 2) {
            result = new int[]{0, 1};
            return result;
        }

        result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public int[] solutionTwo(int[] nums, int target) {
        int[] result = new int[0];
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        HashMap<Integer, Integer> resultMap = new HashMap<>(nums.length * 2);
        for (int i = 0; i < nums.length; i++) {
            // 存在返回
            if (resultMap.containsKey(target - nums[i])) {
                result = new int[]{resultMap.get(target - nums[i]), i};
            }
            // 不存在塞入
            resultMap.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSumSolution solution = new TwoSumSolution();
        int[] nums = {1, 2, 0, 5, 6};
        int target = 8;
        System.out.println("方式一：============");
        int[] solutionOne = solution.solutionOne(nums, 8);
        System.out.println("[" + solutionOne[0] + "," + solutionOne[1] + "]");
        System.out.println("方式二：============");
        int[] solutionTwo = solution.solutionTwo(nums, target);
        System.out.println("[" + solutionTwo[0] + "," + solutionTwo[1] + "]");
    }

}

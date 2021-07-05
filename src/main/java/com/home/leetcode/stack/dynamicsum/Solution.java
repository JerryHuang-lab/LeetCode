package com.home.leetcode.stack.dynamicsum;

import java.lang.String;
import java.util.Arrays;

/**
 * @author hw
 * @create 2020/7/5
 */

public class Solution {

    /*
    给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。

    请返回 nums 的动态和。
    输入：nums = [3,1,2,10,1]
    输出：[3,4,6,16,17]
    输入：nums = [1,2,3,4]
    输出：[1,3,6,10]
    解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
    * */

    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                runningSum[i] = nums[i];
            } else {
                runningSum[i] = runningSum[i - 1] + nums[i];
            }
        }
        return runningSum;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,1,2,10,1};
        int[] runningSums = solution.runningSum(nums);
        Arrays.stream(runningSums).forEach(runningSum->{
            System.out.println(runningSum);
        });

    }
}

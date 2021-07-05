package com.home.leetcode.top.dp;

/**
 * @author hw
 * @create 2021/7/5
 */

public class Top55 {


    public static void main(String[] args) {
        int[] nums = {0,2,3};
        Top55 top55 = new Top55();
        System.out.println(top55.canJump(nums));
    }

    /**
     *
     *   给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

        数组中的每个元素代表你在该位置可以跳跃的最大长度。

        判断你是否能够到达最后一个下标
     *  输入：nums = [2,3,1,1,4]
     *  输出：true
     *  解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标
     *
     * */
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length  ;i ++){
            if(i > max){
                /*题干中的到不了 实际上就是之前得max到不了现在的i*/
                return false;
            }
            max = Math.max(nums[i] + i,max);
        }
        return true;
    }


}

package com.home.leetcode.top.dp;

import static java.lang.Math.max;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 你的目标是使用最少的跳跃次数到达数组的最后一个位置。

 假设你总是可以到达数组的最后一个位置。

 输入: [2,3,1,1,4]
 输出: 2
 解释: 跳到最后一个位置的最小跳跃数是 2。
      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

 *
 * @author huangwei10
 * @create 2021/7/2
 */

public class Top45 {

	public static void main(String[] args) {
		int[] nums = {1,0,0,0,4};
		Top45 top45 = new Top45();
		System.out.println(top45.test(nums));

	}

	public int jump(int[] nums){
		int count = 0;
		for(int j = nums.length-1; j>0;){
			j = getMinArrivePos(nums,j);
			if(j != -1){
				count++;
			} else {
				return -1;
			}

		}
		return count;
	}

	private int getMinArrivePos(int[] nums,int j){
		for(int i = 0;i < j;i++){
			if(i+nums[i] >= j){
				return i;
			}
		}
		return -1;
	}

	public int test(int[] nums){
		int ans = 0;
		int end = 0;
		int maxPos = 0;
		for (int i = 0; i < nums.length-1; i++)
		{
			maxPos = max(nums[i] + i, maxPos);
			if (i == end)
			{
				end = maxPos;
				ans++;
			}
		}
		return ans;
	}
}

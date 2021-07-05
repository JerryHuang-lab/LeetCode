package com.home.leetcode.top.dp;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。  你可以认为每种硬币的数量是无限的。   
 * 示例 1：  输入：coins = [1, 2, 5], amount = 11 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：  输入：coins = [2], amount = 3 输出：-1 示例 3：  输入：coins = [1], amount = 0 输出：0 示例 4：  输入：coins = [1], amount = 1 输出：1 示例 5：  输入：coins = [1], amount = 2 输出：2  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/coin-change 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hw
 * @create 2021/6/30
 */

public class Top322 {


    public static void main(String[] args) {
        int[] coin = {3};
        int amount = 11;
        Top322 top322 = new Top322();
        System.out.println(top322.coinChange(coin,amount));
    }

    /**
     * 偏向与动态规划 原因 amount的其他每一个最有解的组合
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i = 1; i<= amount ; i++){
            for(int j = 0; j<coins.length;j++){
                /*开始计算dp[i]*/
                if(coins[j] <= i && dp[i-coins[j]] != -1){
                    if(dp[i] == -1 || dp[i] > dp[i-coins[j]]+1){
                        dp[i] = dp[i-coins[j]]+1;
                    }
                }
            }
        }
        return dp[amount];
     }
}

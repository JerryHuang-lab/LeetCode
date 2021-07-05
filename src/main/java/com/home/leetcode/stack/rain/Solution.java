package com.home.leetcode.stack.rain;

import java.lang.String;

/**
 * @author hw
 * @create 2020/7/22
 */

public class Solution {


    /*
    * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

    上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分    表示雨水）。 感谢 Marcos 贡献此图。

    示例:

    输入: [0,1,0,2,1,0,1,3,2,1,2,1]
    输出: 6
    */

    public static int trap(int[] height) {
        int result = 0;
        if(height.length == 0){
            return 0;
        }
        /*结果值*/

        /*当前组内黑色块个数*/
        int currentBlock = 0;
        int leftHeight[] = new int[]{-1, -1};
        int rightHeight[] = new int[]{-1, -1};
        for(int i = 0; i < height.length; i++){
            if( -1 ==  leftHeight[0] ){
                leftHeight[0] = i;
                leftHeight[1] = height[i];
                currentBlock += height[i];
            } else if(leftHeight[1] <= height[i]){
                currentBlock += leftHeight[1];
                rightHeight[1] = height[i];
                rightHeight[0] = i;
                result +=  leftHeight[1]*(rightHeight[0]+1-leftHeight[0])-currentBlock;
                leftHeight[0] = rightHeight[0];
                leftHeight[1] = rightHeight[1];
                currentBlock = rightHeight[1];
                rightHeight = new int[]{-1, -1};
            } else {
                currentBlock += height[i];
            }
        }
        int endPoint = leftHeight[0];
        currentBlock = 0;
        rightHeight = new int[]{-1, -1};
        for(int j = height.length -1; j >= endPoint; j-- ){
            if(-1 == rightHeight[0]){
                rightHeight[0] = j;
                rightHeight[1] = height[j];
                currentBlock += height[j];
            } else if(rightHeight[1] <= height[j]){
                currentBlock += rightHeight[1];
                leftHeight[1] = height[j];
                leftHeight[0] = j;
                result +=  rightHeight[1]*(rightHeight[0]+1-leftHeight[0])-currentBlock;
                rightHeight[0] = leftHeight[0];
                rightHeight[1] = leftHeight[1];
                currentBlock = leftHeight[1];
                leftHeight = new int[]{-1, -1};
            } else {
                currentBlock += height[j];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int height1[] = {2,0,1};
        System.out.println(trap(height1));

    }

}

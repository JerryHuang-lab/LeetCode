package com.home.leetcode.top;

import java.lang.String;
import java.util.*;

/**
 * @author hw
 * @create 2020/7/23
 */

public class Top1 {

    /*
    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍
    示例:

    给定 nums = [2, 7, 11, 15], target = 9

    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/two-sum
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */

    public static void main(String[] args) {
    }

    public int[] twoSum(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
/*list 0位key的下标，1位差值*/
        Map<Integer, List<Integer>> listMap = new HashMap<Integer, List<Integer>>();
        for(int i = 0 ; i < nums.length; i++ ){
            List<Integer> integers = null;
            if(listMap.containsKey(nums[i])){
                integers = listMap.get(nums[i]);
            }else {
                integers = new ArrayList<>();
                listMap.put(nums[i], integers);
            }
            integers.add(i);
        }
        List<Integer> useFlagList = new ArrayList<>();
        for(int i = 0 ; i < nums.length; i++ ){
            if(useFlagList.contains(i)){
                continue;
            }
            useFlagList.add(i);
            Integer a = target - nums[i];
            if(listMap.containsKey(a)){
                List<Integer> integers = listMap.get(a);
                for(int point : integers){
                    if(!useFlagList.contains(point)){
                        result.add(i);
                        result.add(point);
                        useFlagList.add(point);
                        break;
                    }
                }

            }else {

            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();

    }
}

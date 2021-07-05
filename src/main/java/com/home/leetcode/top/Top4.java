package com.home.leetcode.top;

/**
 * @author hw
 * @create 2020/7/28
 */

public class Top4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0 ){
            return 0.0;
        }
        int l = (nums1.length + nums2.length + 1)/2;
        int r = (nums1.length + nums2.length + 2)/2;
        if(l == r){
            /*两个数组合并长度为奇数*/
            return getKth(nums1,0,nums2,0,l);
        }
        return (getKth(nums1,0,nums2,0,l)+getKth(nums1,0,nums2,0,r))/2.0;

    }


    private  double getKth(int[] nums1, int st1, int[] nums2, int st2, int k){
        if(st1 > nums1.length-1) return nums2[st2 + k - 1];
        if(st2 > nums2.length-1) return nums1[st1 + k - 1];
        // 边界情况, k = 1 则返回两个数组中最小的那个
        if(k == 1) return Math.min(nums1[st1], nums2[st2]);
        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if(st1+k/2-1 < nums1.length){
            mid1 = nums1[st1+k/2-1];
        }
        if(st2+k/2-1 < nums2.length){
            mid2 = nums2[st2+k/2-1];
        }
        if(mid1 < mid2){
            /*说明k的值在mid1右边到整个nums2*/
            return getKth(nums1, st1+k/2, nums2,st2,k-k/2);
        } else {
            return getKth(nums1, st1, nums2,st2+k/2, k-k/2);
        }
    }


}

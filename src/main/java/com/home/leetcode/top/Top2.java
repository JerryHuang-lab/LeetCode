package com.home.leetcode.top;


import com.home.leetcode.top.ListNode.ListNode;

import java.lang.String;

/**
 * @author hw
 * @create 2020/7/23
 */

public class Top2 {

    public static void main(String[] args) {

       /* ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode x = new ListNode(5);
        ListNode y = new ListNode(6);
        ListNode z = new ListNode(4);
        a.next = b;
        b.next = c;
        x.next = y;
        y.next = z;*/
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(8);
        ListNode c = new ListNode(2);
        a.next = b;
        ListNode x = new ListNode(1);
        Top2 top2 = new Top2();
        ListNode listNode =  top2.addTwoNumbers(a,x);
        System.out.println(1111);


    }


    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = null;
        Integer count = 0;
        ListNode surNode = null;
        ListNode curNode = null;
        while (null != l1 && null != l2) {
            Integer value = l1.val + l2.val + count;
            count = value / 10;
            value = value % 10;
            if (null == listNode) {
                listNode = new ListNode(value);
            } else {
                ListNode newNode = new ListNode(value);
                if(null == curNode) {
                    curNode = listNode;
                }
                curNode.next = newNode;
                curNode = newNode;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (null != l1) {
            surNode = l1;
        } else if (null != l2) {
            surNode = l2;
        } else {
            if (count != 0) {
                surNode = new ListNode(count);
            }
            if(null == curNode){
                curNode = listNode;
            }
            curNode.next = surNode;
            return listNode;

        }
        if (null != surNode) {
            if (count != 0) {
                while (null != surNode) {
                    Integer value = surNode.val + count;
                    count = value / 10;
                    value = value % 10;
                    ListNode newNode = new ListNode(value);
                    if(null == curNode){
                        curNode = listNode;
                    }
                    curNode.next = newNode;
                    curNode = newNode;
                    if (count == 0) {
                        curNode.next = surNode.next;
                        break;
                    }
                    surNode = surNode.next;
                    if (null == surNode) {
                        curNode.next = new ListNode(count);
                        break;
                    }
                }

            } else {
                if(null == curNode){
                    listNode.next = surNode;
                } else {
                    curNode.next = surNode;
                }
            }
        }
        return listNode;
    }


}

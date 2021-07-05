package com.home.leetcode.stock;

import java.lang.String;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author hw
 * @create 2020/7/5
 */

public class StockBuyTime {



    /*
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

    如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

    注意：你不能在买入股票前卖出股票。
    示例 1:

    输入: [7,1,5,3,6,4]
    输出: 5
       解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     */

    public int maxProfit(int[] prices) {
        Integer maxProfit = 0;
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < prices.length; i++) {
            if (result.isEmpty()) {
                /*如果为空
                 */
                result.put(prices[i], -1);
            } else {
                Iterator<Map.Entry<Integer, Integer>> resultIterator = result.entrySet().iterator();
                boolean putFlag = false;
                while (resultIterator.hasNext()) {
                    Map.Entry<Integer, Integer> entry = resultIterator.next();
                    if (entry.getKey() > prices[i]) {
                        if (entry.getValue() == -1) {
                           /*说明当前数比前一个数小*/
                            resultIterator.remove();
                        }
                        putFlag = true;
                    } else if (entry.getValue() < prices[i]) {
                        entry.setValue(prices[i]);
                    }
                    if(entry.getValue() != -1){
                        Integer profit = entry.getValue() - entry.getKey();
                        if(maxProfit < profit){
                            maxProfit = profit;
                        }
                    }

                }
                if (putFlag) {
                    result.put(prices[i], -1);
                }
            }
        }
        return  maxProfit;
    }

    public int maxProfit2(int[] prices) {
        Integer maxProfit = 0;
        Integer minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
           minPrice = Math.min(minPrice, prices[i]);
           maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return  maxProfit;
    }

    public static void main(String[] args) {
        StockBuyTime stockBuyTime = new StockBuyTime();
        int[] stockPrics = {7,1,5,3,6,4};
        System.out.println(stockBuyTime.maxProfit2(stockPrics));
    }
}

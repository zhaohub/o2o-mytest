package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/8.
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        int len = candidates.length - 1;
        for (int i = len; i >= 0; i--) {
            List<Integer> list = new ArrayList<Integer>();
            if (obtainSubList(list, target - candidates[i], Arrays.copyOfRange(candidates, 0, i + 1))) {
                list.add(candidates[i]);
                res.add(list);
            }
        }
        return res;
    }

    private static boolean obtainSubList(List<Integer> res, int sum, int[] subArray) {
        if (subArray == null || subArray.length == 0)
            return false;

        for (int i = subArray.length - 1; i >= 0; i--) {
            if (sum == subArray[i] ||
                    (subArray[i] < sum && obtainSubList(res, sum - subArray[i], Arrays.copyOfRange(subArray, 0, i + 1)))) {
                res.add(subArray[i]);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] canidates = {2, 3, 6, 7};
        List<List<Integer>> res = combinationSum(canidates, 8);
        //2 6
        //2 3 3
        //2 2 2 2
    }
}
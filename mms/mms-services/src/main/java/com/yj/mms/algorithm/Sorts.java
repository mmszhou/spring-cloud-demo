package com.yj.mms.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 冒泡
 */
public class Sorts {

    /**
     * 冒泡排序
     *
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            //提前退出标识 是否存在交换
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                    flag = true;
                }
            }

            //没有数据交换，提前退出
            if (!flag) {
                break;
            }

        }


    }

    public static void main(String[] args) {
        int[] a = {6, 2, 4, 1, 9, 5,7,2,9,0,9,3,8,12};
        bubbleSort(a, a.length);

    }
}

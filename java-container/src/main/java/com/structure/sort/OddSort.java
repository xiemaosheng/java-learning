package com.structure.sort;

/**
 * 奇偶排序
 * Created by Administrator on 2017/5/29 0029.
 */
public class OddSort {
    public static void oddSort(int[] arr) {
        int exchFlag = 1;
        int start = 0;
        while (exchFlag == 1 || start == 0) {
            exchFlag = 0;
            for (int i = start; i < arr.length - 1; i += 2) {
                if (arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    exchFlag = 1;
                }
            }

            if (start == 0){
                start = 1;
            }else{
                start = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,2,44,5,88,9};
        oddSort(arr);
        for (int i : arr){
            System.out.println(i);
        }

    }
}

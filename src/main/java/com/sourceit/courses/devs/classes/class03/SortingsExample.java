package com.sourceit.courses.devs.classes.class03;


import java.util.Arrays;

public class SortingsExample {

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static void bubblesort(int[] arr){
        for(int i = arr.length-1 ; i >= 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    static void doSelectionSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }

    }

    public static void main(String[] args) {
        // Инициализация массива
        int nums[] = {99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49};

        int nums1[] = new int[nums.length];
        int nums2[] = new int[nums.length];
        System.arraycopy(nums,0,nums1,0, nums.length);
        System.arraycopy(nums,0,nums2,0, nums.length);

        Long startTime;

        System.out.println(Arrays.toString(nums1));

        startTime = System.nanoTime();
        bubblesort(nums1);

        System.out.println("Time for bubble sorting is " + (System.nanoTime() - startTime) + " ns");
        System.out.println(Arrays.toString(nums1));


        startTime = System.nanoTime();
        doSelectionSort(nums2);

        System.out.println("Time for selection sorting is " + (System.nanoTime() - startTime) + " ns");
        System.out.println(Arrays.toString(nums1));
    }
}

package com.sort;

public class Sort09_maxDiff {

    public static void main(String[] args) {
        maxDiff(new int[]{1,3, 2, 6, 4, 7, 8});
    }

    public static int maxDiff(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }

        boolean[] bucket = new boolean[arr.length + 1];
        int[] maxBucket = new int[arr.length + 1];
        int[] minBucket = new int[arr.length + 1];

        for (int num : arr) {
            int index = (num - min) * arr.length / (max - min);
            if (!bucket[index]) {
                bucket[index] = true;
                minBucket[index] = num;
                maxBucket[index] = num;
            } else {
                if (minBucket[index] > num) {
                    minBucket[index] = num;
                }
                if (maxBucket[index] < num) {
                    maxBucket[index] = num;
                }
            }
        }

        int maxDiff = Integer.MIN_VALUE;

        int lastNum = maxBucket[0];
        for (int i = 1; i < bucket.length; i++) {
            if(bucket[i]){
                maxDiff = Math.max((minBucket[i] - lastNum), maxDiff);
                lastNum = maxBucket[i];
            }
        }

        System.out.println(maxDiff);
        return maxDiff;
    }
}

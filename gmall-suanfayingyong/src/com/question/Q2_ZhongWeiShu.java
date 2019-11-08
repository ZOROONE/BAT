package com.question;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2_ZhongWeiShu {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 3, 3, 2, 3};
        MiddleNode middleNode = new MiddleNode();
        // 1 3 2 2 3 2 3
        for (int num : arr) {
            middleNode.add(num);
            System.out.println(middleNode.getZhongWeiShu());
        }
    }

    public static class MiddleNode {
        private PriorityQueue<Integer> minQueue;
        private PriorityQueue<Integer> maxQueue;

        public MiddleNode() {
            minQueue = new PriorityQueue<Integer>();
            maxQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
        }

        public void add(int num) {
            maxQueue.add(num);
            if (maxQueue.size() - minQueue.size() > 1) {
                minQueue.add(maxQueue.poll());
            }
        }

        public int getZhongWeiShu() {
            if (maxQueue.size() - minQueue.size() == 1) {
                if (maxQueue.size() == 1) {
                    return maxQueue.peek();
                }
                return Math.min(maxQueue.peek(), minQueue.peek());
            } else {
                return (maxQueue.peek() + minQueue.peek()) >>> 1;
            }

        }
    }

}

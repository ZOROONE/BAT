package com.jigou;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;

public class J01_ArrayToQueue {

    /**
     * 用数组实现固定大小的队列
     */
    public static class ArrayQueue{
        private int[] arr;
        private int capacity;
        private int size;
        private int headIndex;
        private int tailIndex;

        public ArrayQueue(int capacity){
            arr = new int[capacity];
            this.capacity = capacity;
            this.size = 0;
            headIndex = 0;
            tailIndex = 0;
        }

        public boolean add(int num){
            if(size == capacity){
                return false;
            }
            if(size == 0){
                arr[headIndex] = num;
                arr[tailIndex] = num;
            } else {
                tailIndex = getNextIndex(tailIndex);
                arr[tailIndex] = num;
            }
            size++;
            return true;
        }


        private int getNextIndex(int index) {
            return index == capacity - 1 ? 0 : index + 1;
        }

        public Integer peek(){
            if(size > 0){
                return arr[headIndex];
            } else {
                return null;
            }
        }

        public Integer poll(){
            if(size == 0){
                return null;
            }
            if(size == 1){
                size--;
                return arr[headIndex];
            } else {
                size--;
                int res = arr[headIndex];
                headIndex = getNextIndex(headIndex);
                return res;
            }
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public int getSize(){
            return size;
        }
    }


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.add(3);
        System.out.println(queue.peek());//3
        System.out.println(queue.size);//1
        System.out.println(queue.isEmpty());
        queue.add(2);
        System.out.println(queue.peek());//3
        System.out.println(queue.size);//2
        queue.add(5);
        System.out.println(queue.peek());//3
        System.out.println(queue.size);//2
        queue.add(6);
        System.out.println(queue.peek());//3
        System.out.println(queue.size);//2
        System.out.println(queue.poll()); // 3
        System.out.println(queue.size); //2
        System.out.println(queue.poll()); // 2
        System.out.println(queue.size); //1
        System.out.println(queue.poll()); // 5
        System.out.println(queue.size);
    }
}

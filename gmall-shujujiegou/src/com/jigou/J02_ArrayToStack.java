package com.jigou;

public class J02_ArrayToStack {

    public static class ArrayStack{
        private int[] arr;
        private int capacity;
        private int size;
        private int headIndex;

        public ArrayStack(int capacity){
            arr = new int[capacity];
            this.capacity = capacity;
            size = 0;
            headIndex = -1;
        }
        // and和push底层是一样的，只是返回值不一样
        public Integer push(int num){
            if(size < capacity){
                arr[++headIndex] = num;
                size++;
                return num;
            } else {
                return null;
            }
        }

        public Integer peek(){
            if(size > 0){
                return arr[headIndex];
            } else {
                return null;
            }
        }

        public Integer pop(){
            if(size > 0){
                size--;
                return arr[headIndex--];
            } else {
                return null;
            }
        }
    }


    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        System.out.println(stack.peek()); // 1
        stack.push(2);
        System.out.println(stack.peek()); // 2
        stack.push(3);
        System.out.println(stack.peek()); // 3
        stack.push(4);
        System.out.println(stack.peek()); // 3
        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); //2
        System.out.println(stack.pop()); //1
        System.out.println(stack.pop()); //null 现在不报错了
    }
}

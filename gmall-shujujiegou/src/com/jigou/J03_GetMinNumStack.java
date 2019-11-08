package com.jigou;

import java.util.Stack;

public class J03_GetMinNumStack {

    public static class GetMinNumStack{
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;
        private int size;

        public GetMinNumStack(){
            this.dataStack = new Stack<Integer>();
            this.minStack = new Stack<Integer>();
            this.size = 0;
        }

        public Integer push(int num){
            if(size == 0){
                dataStack.push(num);
                minStack.push(num);
            } else{
                dataStack.push(num);
                minStack.push(Math.min(num, minStack.peek()));
            }
            size++;
            return num;
        }

        public Integer peek(){
            return dataStack.peek();
        }

        public Integer pop(){
            Integer res = dataStack.pop();
            minStack.pop();
            size--;
            return res;
        }

        public Integer getMin(){
            return minStack.peek();
        }
    }

}

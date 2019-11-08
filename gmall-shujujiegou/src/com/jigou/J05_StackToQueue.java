package com.jigou;

import java.util.Stack;

public class J05_StackToQueue {

    public static class StackToQueue{
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public StackToQueue(){
            pushStack = new Stack<Integer>();
            popStack = new Stack<Integer>();
        }

        public boolean add(int num){
            pushStack.push(num);
            return true;
        }

        public Integer peek(){
            if(popStack.isEmpty()){
                dao();
            }
            return popStack.peek();
        }

        public Integer poll(){
            if(popStack.isEmpty()){
                dao();
            }
            return popStack.pop();
        }

        private void dao() {
            while (pushStack.size() > 0){
                popStack.push(pushStack.pop());
            }
        }

        public int size(){
            return popStack.size() + pushStack.size();
        }

        public boolean isEmpty(){
            return popStack.isEmpty() && pushStack.isEmpty();
        }
    }
}

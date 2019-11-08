package com.jigou;

import java.util.LinkedList;
import java.util.Queue;

public class J04_QueueToStack {

    public static class QueueToStack{

        private Queue<Integer> dataQueue;
        private Queue<Integer> helpQueue;
        private Queue<Integer> swapQueue;

        public QueueToStack(){
            dataQueue = new LinkedList<Integer>();
            helpQueue = new LinkedList<Integer>();
        }

        public Integer push(int num){
            dataQueue.add(num);
            return num;
        }

        public Integer peek(){
            if(dataQueue.size() > 0){
                while (dataQueue.size() > 1){
                    helpQueue.add(dataQueue.poll());
                }
                Integer res = dataQueue.peek();
                helpQueue.add(dataQueue.poll());
                swapQueue = dataQueue; //此时dataQueue为空了
                dataQueue = helpQueue; //
                helpQueue = swapQueue;
                return res;
            }

            return dataQueue.peek();
        }

        public Integer pop(){
            if(dataQueue.size() > 0){
                while (dataQueue.size() > 1){
                    helpQueue.add(dataQueue.poll());
                }
                Integer res = dataQueue.poll();
                swapQueue = dataQueue; //此时dataQueue为空了
                dataQueue = helpQueue; //
                helpQueue = swapQueue;
                return res;
            }
            return dataQueue.poll();
        }

    }
}

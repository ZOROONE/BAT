package com.jigou;

import java.util.Stack;

public class J08_IsHuiWenNode {

    public static class Node {
        private int data;
        public Node next;

        public Node(int num) {
            this.data = num;
        }
    }

    public static boolean isHuiWen(Node head) {
        if (head == null) return false;

        Node fast = head;
        Node slow = head;
        Stack<Node> stack = new Stack<Node>();
        while (fast.next != null && fast.next.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
//        if (fast.next == null) {
//            slow = slow.next;
//        } else {
//            stack.push(slow);
//            slow = slow.next;
//        }

        if (fast.next != null) {
            stack.push(slow);
        }
        slow = slow.next;

        while (!stack.isEmpty()) {
            if (stack.pop().data != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    /**
     * 要求时间复杂为O(N), 额外空间复杂度为O(1)
     * @return
     */
    public static boolean isHuiWenO1(Node head){
        if(head == null || head.next == null) return false;
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next != null) {
            slow = slow.next;
        }

        //后半部分链表反转
        Node pre = null;
        Node next = null;
        while (slow.next != null){
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        slow.next = pre;

        // 这时slow指针在链表最后一个Node上面
        Node last = slow;

        boolean res = false;
        while (last != null){
            if(last.data != head.data){
                break;
            }
            last = last.next;
            head = head.next;
        }

        if(last == null){
            res = true;
        }

        //将后半部分链表再反转回来

        pre = null;
        next = null;
        while (slow.next != null){
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        slow.next = pre;
        return res;
    }

    public static void main(String[] args) {
    }
}

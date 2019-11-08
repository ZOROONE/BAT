package com.jigou;

public class J07_ReverseDoubleNode {
    public static class Node{
        private int data;
        public Node pre;
        public Node next;

        public Node(int num){
            this.data = num;
        }
    }

    public static Node reverseNode(Node head){
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur.next != null){
            pre = cur.pre;
            next = cur.next;
            cur.next = pre;
            cur.pre = next;
            cur = next;
        }
        cur.next = cur.pre;
        cur.pre = null;
        return cur;
    }
}

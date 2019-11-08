package com.jigou;

public class J06_ReverseSingleNode {
    public static class Node{
        private int data;
        public Node next;
        public Node(int num){
            this.data = num;
            next = null;
        }
    }

    public static Node reverseNode(Node head){
        if(head == null) return null;

        Node cur = head;
        Node last = null;
        Node next = null;

        if (cur != null) {
            next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        return last;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
    }
}

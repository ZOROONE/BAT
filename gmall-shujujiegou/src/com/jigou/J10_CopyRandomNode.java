package com.jigou;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制含有随机节点的链表
 */
public class J10_CopyRandomNode {

    public static class Node{
        private int data;
        public Node random;
        public Node next;

        public Node(int num){
            this.data = num;
        }
        private void get(){

        }
    }

    //1. 借助哈希表，额外空间复杂度O(N)
    public static void copyRandomNode(Node head){
        if(head == null) return;
        Node cur = head;
        Map<Node, Node> map = new HashMap<Node, Node>();

        while (cur != null){
            map.put(cur, new Node(cur.data));
            cur = cur.next;
        }

        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        //map.get(head); 就是复制的头节点
    }

    //要求额外空间复杂度为(1)
    public static void copyRandomNode2(Node head){
        if (head == null) {
            return;
        }

        Node cur = head;
        Node next = null;
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.data);
            cur.next.next = next;
            cur = next;
        }

        //建立random指针链接
        cur = head;
        while (cur != null){
            cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        //将分离出来
        cur = head;
        Node copyHead = cur.next;
        next = null;
        while (cur.next.next != null){
            next = cur.next.next;
            cur.next.next = next.next;
            cur.next = next;
            cur = next;
        }
        cur.next = null;

    }
}

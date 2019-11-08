package com.jigou;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import java.util.HashSet;

public class J11_IsLoopNode {

    public static class Node{
        private int data;
        public Node next;
        public Node(int num){
            this.data = num;
        }
    }

    //1. 借助map判断是否有环
    public static Node isLoop1(Node head){
        HashSet<Node> set = new HashSet<>();
        while (head != null){
            if(set.contains(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }

    //2. 借助快慢指针
    public static Node isLoop2(Node head){
        if(head == null){
            return null;
        }

        Node fast = head;
        Node slow = head;

        do{
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        fast = head;

        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}

package com.jigou;

import com.sun.org.apache.xerces.internal.impl.dtd.models.CMAny;

/**
 * 链表与荷兰国旗问题
 * <p>
 * 左边大， 中间相等，右边小
 */
public class J09_HeLanGuoQiNode {

    public static class Node {
        private int data;
        public Node next;

        public Node(int num) {
            this.data = num;
        }
    }

    /**
     * 1. 可以将Node节点一个个放入到数组中，这就成了数组求荷兰国旗的问题了
     * 2. 可以分三个区域，小于，大于，相等
     *
     * @param head
     */
    public static Node heLanGuoQi(Node head, int num) {
        if (head == null) return null;

        Node smallHead = null;
        Node smallCur = null;
        Node equalHead = null;
        Node equalCur = null;
        Node bigHead = null;
        Node bigCur = null;

        while (head != null) {
            if (head.data < num) {
                if (smallCur == null) {
                    smallHead = head;
                    smallCur = head;
                } else {
                    smallCur.next = head;
                    smallCur = head;
                }
            } else if (head.data == num) {
                if (equalCur == null) {
                    equalHead = head;
                    equalCur = head;
                } else {
                    equalCur.next = head;
                    equalCur = head;
                }
            } else {
                if (bigCur == null) {
                    bigHead = head;
                    bigCur = head;
                } else {
                    bigCur.next = head;
                    bigCur = head;
                }
            }
            head = head.next;
        }

        //将三个部分拼接在一起
        head = smallHead != null ? smallHead : equalHead != null ? equalHead : bigHead;

        if (smallHead != null) {
            smallCur.next = equalHead != null ? equalHead : bigHead;
        }

        if (equalHead != null) {
            equalCur.next = bigHead;
        }

        if (bigHead != null) {
            bigCur.next = null;
        }

        return head;
    }
}

package com.jigou;
import com.jigou.J11_IsLoopNode.Node;
public class J12_XiangJiaoNode {


    public static Node getFistNode(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }

        Node head1Loop = J11_IsLoopNode.isLoop2(head1);
        Node head2Loop = J11_IsLoopNode.isLoop2(head2);

        if(head1Loop == null && head2Loop == null){
            //1. 无环香蕉
            return noLoop(head1, head2);
        } else if(head1Loop != null && head2Loop != null){
            if(head1Loop == head2Loop){
                //2. 环前相交
                return beforeLoop(head1, head2, head2Loop);
            }
            //3. 环上香蕉
            return onLoop(head1Loop, head2Loop);

        }
        return null;
    }

    private static Node noLoop(Node head1, Node head2) {
        Node cur1 = head1;
        Node cur2 = head2;
        int length1 = 1;
        int length2 = 1;
        while (cur1.next != null){
            length1++;
            cur1 = cur1.next;
        }
        while (cur2.next != null){
            length2++;
            cur2 = cur2.next;
        }
        //如果最后一个都不相同，那就不相交
        if(cur1 != cur2){
            return null;
        }

        cur1 = head1;
        cur2 = head2;
        //将两个链表裁剪为相同长度
        if(length1 > length2){
            for (int i = 0; i < length1 - length2; i++) {
                cur1 = cur1.next;
            }
        }else{
            for (int i = 0; i < length2 - length1; i++) {
                cur2 = cur2.next;
            }
        }

        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //环前香蕉
    private static Node beforeLoop(Node head1, Node head2, Node loopNode) {
        Node cur1 = head1;
        Node cur2 = head2;
        int length1 = 1;
        int length2 = 1;
        while (cur1 != loopNode){
            length1++;
            cur1 = cur1.next;
        }
        while (cur2 != loopNode){
            length2++;
            cur2 = cur2.next;
        }

        cur1 = head1;
        cur2 = head2;
        //将两个链表裁剪为相同长度
        if(length1 > length2){
            for (int i = 0; i < length1 - length2; i++) {
                cur1 = cur1.next;
            }
        }else{
            for (int i = 0; i < length2 - length1; i++) {
                cur2 = cur2.next;
            }
        }

        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }

    //环上香蕉，可能不相交，自己判断
    private static Node onLoop(Node head1Loop, Node head2Loop) {
        Node cur = head1Loop.next;
        while (cur != head2Loop && cur != head1Loop){
            cur = cur.next;
        }

        if(cur == head2Loop){
            return head2Loop;
        }
        return null;
    }
}

package com.jiegou.tree;

public class T04_GetSuccessor {

    //找一个节点的后继节点，即中序遍历时该节点的下一个节点
    public static Tree getSuccessor(Tree node) {
        if (node == null) {
            return null;
        }

        //如果该节点的右孩子不为空，则其后继节点就是其右孩子的最左节点
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        //如果其右孩子为空，则其后继接节点就是其祖先节点为左孩子时的parent节点
        Tree parent = node.parent;
        while (parent != null && parent.left != node) {
            node = parent;
            parent = parent.parent;
        }

        return parent;
    }
}

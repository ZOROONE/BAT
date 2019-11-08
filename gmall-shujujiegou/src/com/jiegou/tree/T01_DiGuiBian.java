package com.jiegou.tree;

import java.util.Stack;

public class T01_DiGuiBian {

    //递归模式，  遍历Tree一共返回一个节点三次
    //递归模式强大，就因为它把所有东西都压入栈中
    public static void xianXu(Tree root){
        if(root == null){
            return;
        }
        //当第一次到达这个节点，如果这时候打印就是先序遍历， 中左右
        System.out.println(root.data);

        xianXu(root.left);
        //第二次到达该节点，如果这时候遍历，就是中序，  左中右
        //System.out.println(root.data);

        xianXu(root.right);
        //第三次到达该节点，如果这时候打印，就是后序，  左右中
        //System.out.println(root.data);
    }

}

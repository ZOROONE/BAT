package com.jiegou.tree;

import java.util.Stack;

public class T02_ZhanBianli {

    //借助栈，先进后出，先压右孩子，再压左孩子
    public static void xianXu(Tree root){
        if (root == null) {
            return;
        }

        Stack<Tree> stack = new Stack<>();
        stack.push(root);
        Tree cur;
        while (!stack.isEmpty()){
            cur = stack.pop();
            System.out.println(cur.data);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 首先将root节点的左边节点全部压入栈中，最后当root为null时，栈顶元素一定是最左面节点且其左子树为空
     * 弹出栈顶元素，并且打印，然后将root节点移动到该节点右孩子上， 如果右孩子非空，跟上面一样
     * 如果右孩子为空，则会在栈顶重新弹出一个元素，然后打印，并且重新将root移到其有孩子上面
     *
     * 其实第一次到达一个节点时，是一开始将该节点压入栈中的时候
     * 第二次到达一个节点时，是在栈中弹出该节点时，这时打印，自然是中序
     *
     * 然后
     * @param root
     */
    public static void zhongXu(Tree root){
        if(root ==  null){
            return;
        }
        Stack<Tree> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            } else{
                root = stack.pop();
                System.out.println(root.data);
                root = root.right;
            }
        }
    }


    /**
     * 先序是中左右， 我们上面利用栈，先打印，在压右压左
     * 后序，是左中右，就是中右左倒过来，所以我们借助两个栈实现
     *
     * 一个栈是用来存储中右左的顺序压入，一个栈用来到
     */
    public static void houXu(Tree root){
        if (root == null) {
            return;
        }

        Stack<Tree> stack1 = new Stack<>();
        Stack<Tree> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()){
            root = stack1.pop();
            stack2.push(root);
            if(root.left != null){
                stack1.push(root.left);
            }
            if(root.right != null){
                stack1.push(root.right);
            }
        }

        while (!stack2.isEmpty()){
            System.out.println(stack2.pop().data);
        }
    }
}

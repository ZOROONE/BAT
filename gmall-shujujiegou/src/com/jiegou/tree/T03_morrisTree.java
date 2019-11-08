package com.jiegou.tree;

public class T03_morrisTree {

    public static void preMorris(Tree root){
        if(root == null){
            return;
        }
        Tree cur = root;
        Tree mostRight = null;
        while (cur != null){
            if(cur.left == null){
                //左子树为空，证明第一次该节点，也只会经过一次，直接打印
                System.out.println(cur.data);
                cur = cur.right;
            }else {
                //左子树非空， 会经过两次, 先找到该节点的mostRight节点
                mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }

                if(mostRight.right == null){
                    //第一次经过该节点，先序遍历直接打印
                    System.out.println(cur.data);
                    //将mostRight节点的右孩子指向该节点，将该节点移到左孩子上面
                    mostRight.right = cur;
                    cur = cur.left;
                }else{
                    //第二次经过该节点
                    //将该节点mostRight的右孩子指向空，然后将该节点移到其有孩子上面
                    mostRight = null;
                    cur = cur.right;
                }
            }
        }
    }

    //和preMorris一样，第一次到一个节点时就打印是先序遍历，第二次到再打印是中序遍历
    public static void midMorris(Tree root){
        if (root == null) {
            return;
        }
        Tree cur = root;
        Tree mostRight;
        while (cur != null){
            if(cur.left == null){
                //左孩子为空， 第一次经过该节点，也是唯一一次，其实是隐式第二次
                System.out.println(cur.data);
                cur = cur.right;
            }else{
                //左孩子非空，共经过该节点两次，等第二次经过时打印就是中序遍历
                //得到该节点mostRight节点
                mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != null){
                    if(mostRight == null){
                        //第一次经过该节点, 将该节点mostRight节点的右孩子指向该节点，左移该节点
                        mostRight.right = cur;
                        cur = cur.left;
                    }else{
                        //第二次经过该节点，  将该节点mostRight右孩子指向空，然后右移动该节点
                        System.out.println(cur.data);
                        mostRight.right = null;
                        cur = cur.right;
                    }
                }
            }
        }
    }


    public static void houMorris(Tree root){
        if (root == null) {
            return;
        }

        Tree cur = root;
        Tree mostRight;
        while (cur != null){
            if(cur.left == null){
                //如果左子树为空，那么只会经过该节点一次，将该节点右移
                cur = cur.right;
            } else{
                //总共两次经过该节点，首先找到该节点mostRight节点
                mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }

                if(mostRight == null){
                    //第一次经过该节点, 将该节点的mostRight节点右孩子指向自己，然后左移该节点
                    mostRight.right = cur;
                    cur = cur.left;
                }else{
                    //第二次到达该节点，将该节点mostRight节点右孩子指向空
                    mostRight.right = null;
                    //将该节点左节点右边界从下到上打印，即先反转，打印再反转
                    printLeftRight(cur.left);
                    //右移动该节点
                    cur = cur.right;
                }
            }
        }
    }

    private static void printLeftRight(Tree head) {

        //右边界反转
        Tree pre = null;
        Tree cur = head;
        Tree next = null;
        while (cur != null){
            next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }

        //反转并打印
        cur = pre;//最右边界节点
        next = null;
        pre = null;
        while (cur != null){
            next = cur.right;
            cur.right = pre;
            pre = cur;
            System.out.println(cur.data);
            cur = next;
        }
    }
}

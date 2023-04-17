package com.algorithm.system;

/**
 * @Description
 * @Date 2023/4/17
 *
 * morris
 */
public class Test30 {
    public class Node{
        int value;
        Node left;
        Node right;
        public Node(int a){
            this.value = a;
        }
    }

    //前中后序都可以
    public static void  process(Node node){
        if(node == null){
            return;
        }
        process(node.left);
        process(node.right);
    }

    /**
     * 假设来到当前节点cur，开始时cur来到头节点位置
     * 1）如果cur没有左孩子，cur向右移动(cur = cur.right)
     * 2）如果cur有左孩子，找到左子树上最右的节点mostRight：
     * 	a.如果mostRight的右指针指向空，让其指向cur，
     * 	然后cur向左移动(cur = cur.left)
     * 	b.如果mostRight的右指针指向cur，让其指向null，
     * 	然后cur向右移动(cur = cur.right)
     * 3）cur为空时遍历停止
     */
    public static void morris(Node node){
        if(node == null){
            return;
        }
        Node cur = node;
        while (cur != null){
            Node morrisRight = cur.left;
            if(morrisRight != null){
                //morrisRight.right != cur 防止转回去了
                while (morrisRight.right != null && morrisRight.right != cur){
                    //找到左孩子的最右节点
                    morrisRight = morrisRight.right;
                }
                if(morrisRight.right == null){
                    morrisRight.right = cur;
                    cur = cur.right;
                    continue;
                }else{
                    morrisRight.right = null;
                }
            }else{
                cur = cur.right;
            }
        }

    }

}

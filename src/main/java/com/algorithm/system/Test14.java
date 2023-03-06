package com.algorithm.system;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Date 2023/2/23
 */
public class Test14 {

    /**
     * 并查集
     */

    //node数组 int[][]m
    //find方法，找到他的父
    //unit方法，合并两个数组


    public static int findCircleNum(int[][] isConnected) {
        UnionNew unio = new UnionNew(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i+1; j < isConnected.length; j++) {
                if(isConnected[i][j] == 1){
                    unio.union(i,j);
                }
            }

        }
        return  unio.setSize;
    }

    public static class UnionNew{
        //i是k的父亲 parent[i] = k;
        private int[] parent;
        private int[] help;
        //多少个集合
        private int setSize;
        public int[] size;

        // n 是而二维数组的长度
        public UnionNew(int length){
            parent = new int[length];
            help = new int[length];
            size = new int[length];
            setSize = length;
            for (int i = 0; i < length; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findParent(int son){
            int a = 0;
            //先看我的父亲是不是我自己
            while (son != parent[son]){
                //不是，把我的上级记录
                help[a++] = son;
                //我的上级传出去，直到找到顶级，也就是我的父是我自己
                son = parent[son];
            }
            //这个时候，son就是我的最顶级父，help里记录了整个路径的上级
            for (int i = 0; i <= a-1; i++) {
                parent[help[i]] = son;
            }
            return son;
        }

        public void union(int a , int b){
            int aParent = findParent(a);
            int bParent = findParent(b);

            if(aParent != bParent){
                //谁的长度长，把短的合并到长的上面，只用把头节点合并进去
                if (size[aParent] >= size[bParent]) {
                    //长度先变长
                    size[aParent] += size[bParent];
                    //短的那个，头就是长的
                    parent[bParent] = aParent;
                } else {
                    size[bParent] += size[aParent];
                    parent[aParent] = bParent;
                }
                setSize--;
            }

        }

    }

    /**
     * 给定一个二维数组matrix，里面的值不是1就是0，
     * 上、下、左、右相邻的1认为是一片岛，
     * 返回matrix中岛的数量
     */

    /**
     * 因为这次要把所有数放到Node里，判断并查集，所以 numIslands 里两层遍历都是0开始 最终得到一个谁是 1 的list
     * 因为这个值最终是 char 的 1 ，我们不知道每个1是上面意思，也不知道在哪
     * 我们需要区分他，所以新增了一个对象Dom 来区分哪里是1 哪里是0。因此有了Dom[][] 来知道哪里是 有1 哪里没1
     *
     * 这个时候，我们并查集的时候，使用的List里的数字，也就是Dom的并查集。按照管理，对Dom封装一个Node节点
     * 因为不知道哪个Node节点是保存Dom的，所以加里一个nodes map，来存dom 和 node对象的关系
     */

    public static class Node<V>{
        V value;

        public Node(V v) {
            value = v;
        }
    }
    public static class Dom{}


    public static class DX<V>{
        private HashMap<Node<V>,Node<V>> parent;
        public HashMap<Node<V>,Integer> setSize;
        private HashMap<V,Node<V>> nodes;


        public DX(List<V> list){
            parent = new HashMap<>(list.size());
            setSize = new HashMap<>(list.size());
            nodes = new HashMap<>(list.size());
            for (V v : list) {
                Node<V> vNode = new Node<>(v);
                nodes.put(v,vNode);
                parent.put(vNode,vNode);
                setSize.put(vNode,1);
            }
        }

        public Node finParent(Node<V> node){
            while (node != parent.get(node)){
                node = parent.get(node);
            }
            return node;
        }

        public void union(V v1,V v2){
            Node<V> aHead = finParent(nodes.get(v1));
            Node<V> bHead = finParent(nodes.get(v2));
            if (aHead != bHead) {
                Integer int1 = setSize.get(aHead);
                Integer int2 = setSize.get(bHead);
                if(int1 >= int2){
                    parent.put(bHead, aHead);
                    setSize.put(aHead, int1 + int2);
                    setSize.remove(bHead);
                }else{
                    parent.put(aHead, bHead);
                    setSize.put(bHead, int1 + int2);
                    setSize.remove(aHead);
                }

            }
        }

        public void union2(V a,V b){
            Node<V> aHead = finParent(nodes.get(a));
            Node<V> bHead = finParent(nodes.get(b));
            if (aHead != bHead) {
                int aSetSize = setSize.get(aHead);
                int bSetSize = setSize.get(bHead);
                Node<V> big = aSetSize >= bSetSize ? aHead : bHead;
                Node<V> small = big == aHead ? bHead : aHead;
                parent.put(small, big);
                setSize.put(big, aSetSize + bSetSize);
                setSize.remove(small);
            }
        }
    }




    public static int numIslands(char[][] board) {
        List<Dom> list = new LinkedList<>();
        int row = board.length;
        int col = board[0].length;
        Dom[][] dots = new Dom[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '1') {
                    dots[i][j] = new Dom();
                    list.add(dots[i][j]);
                }
            }
        }
        DX uf = new DX(list);
        for (int j = 1; j < col; j++) {
            // (0,j)  (0,0)跳过了  (0,1) (0,2) (0,3)
            if (board[0][j - 1] == '1' && board[0][j] == '1') {
                uf.union(dots[0][j - 1], dots[0][j]);
            }
        }
        for (int i = 1; i < row; i++) {
            if (board[i - 1][0] == '1' && board[i][0] == '1') {
                uf.union(dots[i - 1][0], dots[i][0]);
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == '1') {
                    if (board[i][j - 1] == '1') {
                        uf.union(dots[i][j - 1], dots[i][j]);
                    }
                    if (board[i - 1][j] == '1') {
                        uf.union(dots[i - 1][j], dots[i][j]);
                    }
                }
            }
        }
        return uf.setSize.size();
    }









    public static void main(String[] args) {
        /*int [][]m = {{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
        System.out.println(findCircleNum(m));*/



        //char[][]a = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][]a = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        int i = numIslands(a);
        System.out.println(i);
    }
}

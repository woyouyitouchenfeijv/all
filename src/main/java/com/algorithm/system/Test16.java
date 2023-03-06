package com.algorithm.system;

import java.util.*;

/**
 * @Description
 * @Date 2023/2/28
 *
 * 图
 */
public class Test16 {



    //图节点，封装一下
    public class Node{
        int value;
        int out;
        int in;
        //我的所有节点
        public ArrayList<Node> nexts;
        //我的所有边
        public ArrayList<Edge> edges;
        public Node(int value) {
            this.value = value;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }

    //边
    public class Edge{
        int weight;
        //谁指向我
        Node from;
        //我指向谁
        Node to;
        public Edge(int weight,Node from,Node to){
            this.weight = weight;
            this.to = to;
            this.from = from;
        }
    }

    //图
    public class Graph{
        //节点和封装节点的map
        Map<Integer,Node> nodes;
        //存哪个边记录过，记录过就不再记录
        Set<Edge> edges;
        public Graph(){
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }
    }


    // 从node出发，进行宽度优先遍历 。就是从头开始，一级层一层遍历
    public static void bfs(Node start){
        if(start == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            System.out.println(poll.value);
            ArrayList<Node> nexts = poll.nexts;
            for (Node next : nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }


    //从node出发，进行深度有限遍历。就是先到子节点，一层一层往上遍历
    public static void dfs(Node start){
        if(start == null){
            return;
        }
        Stack<Node> nodes = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        nodes.add(start);
        set.add(start);
        System.out.println(start.value);
        while (!nodes.isEmpty()){
            Node pop = nodes.pop();
            for (Node next : pop.nexts) {
                if(!set.contains(next)){
                    nodes.push(pop);
                    nodes.push(next);
                    set.add(next);
                    System.out.println(next.value);
                }
            }
        }
    }












    // leetcode 743题，可以用这道题来练习Dijkstra算法
    // 测试链接 : https://leetcode.com/problems/network-delay-time

    public static int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> nexts = new ArrayList<>();
        for (int i = 0;i<=n;i++) {
            nexts.add(new ArrayList<>());
        }
        for (int[] time : times) {
            nexts.get(time[0]).add(new int[]{time[1],time[2]});
        }
        //这一步完，把所有的节点变成了这样 {节点 { 到谁 ，距离} }

        // new 一个小根堆，排序规则是谁的距离短，就先弹出谁。选一个最小的距离去走
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        //把头节点放到
        heap.add(new int[]{k,0});
        //设置头已经到了谁,默认都是false
        boolean[] booleans = new boolean[n + 1];
        int max = 0;
        int num = 0;
        //如果堆不为空，并且没走完次数
        while (!heap.isEmpty() && num < n){
            int[] poll = heap.poll();
            //节点
            int cur = poll[0];
            //距离
            int delay = poll[1];
            if(booleans[cur]){
                continue;
            }
            booleans[cur] = true;
            num++;
            max = Math.max(max,delay);
            //拿到我能到的点，然后距离加上到我的距离
            for (int[] ints : nexts.get(cur)) {
                heap.add(new int[]{ints[0],delay+ints[1]});
            }
        }
        return num < n ? -1 : max;
    }


    public static void main(String[] args) {
        int[][]times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
       // networkDelayTime(times,n,k);

    }


}

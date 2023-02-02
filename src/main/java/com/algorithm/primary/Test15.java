package com.algorithm.primary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description
 * @Date 2023/1/30
 */
public class Test15 {

    public static class ListNode{
        int num;
        String name;
        String value;
        public ListNode(int num ,String name , String value){
            this.num = num;
            this.name = name;
            this.value = value;
        }
    }


    /**
     *  集成 Comparator 接口，实现 compare 方法
     *
     *  返回负数，第一个数在前
     *  返回正数，第二个数在前
     *  返回 0 ，无所谓
     */
    public static class ComputerNum implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.num - o2.num;
        }
    }

    public static void sout(ArrayList<ListNode> listNodes ){
        if(listNodes == null || 0 == listNodes.size()){
            System.out.println(0);
        }
        for (ListNode listNode : listNodes) {
            System.out.println(listNode.num +"-name-"+ listNode.name + "-value-" + listNode.value);
        }

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(6, "a", "b");
        ListNode listNode2 = new ListNode(2, "aa", "bb");
        ListNode listNode3 = new ListNode(3, "aaa", "bbb");

        ArrayList<ListNode> listNodes = new ArrayList();
        listNodes.add(listNode3);
        listNodes.add(listNode1);
        listNodes.add(listNode2);
        sout(listNodes);
        System.out.println("---");
        PriorityQueue<ListNode> listNodesQueue = new PriorityQueue<>(new ComputerNum());
        listNodesQueue.add(listNode3);
        listNodesQueue.add(listNode1);
        listNodesQueue.add(listNode2);

        while (!listNodesQueue.isEmpty()){
            ListNode listNode = listNodesQueue.poll();
            System.out.println(listNode.num +"-name-"+ listNode.name + "-value-" + listNode.value);

        }

    }


}

package com.algorithm.system;

import java.util.*;

/**
 * @Description
 * @Date 2023/2/9
 *
 *
 * 比较器 - 实现 Comparator 传一个对象进去，实现 compare 方法
 * 返回 负数 第一个值在前
 * 返回 正数 第二个在前
 * 返回 0 无所谓
 *
 *
 *
 *
 * 有序表  treeMap  - 比大小和比较器联动
 *
 *
 *
 * 完全二叉树 - 空、一个都是
 * 从左往右依次有值的树。一个树的子，左有，右没有，是。左没有，右有不是
 *
 *
 * 如果有个数组，
 * i 是数组的序号
 * 左的序号： 2*i+1
 * 右的序号： 2*i+2
 * 头的序号： i-1 / 2
 * 按照序号可以组成一个树
 *
 * 利用大根堆堆排序
 *
 */
public class Test7  {

    /**
     * 比较器
     */
    class Student{
        int age;
        String name ;
    }
    class AgeComputer implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            if(o1.age > o2.age){
                return -1;
            }else {
                return 1;
            }
        }
    }



    /**
     * 利用大根堆堆排序
     * 一组数组，从上往下大根堆排序
     * 一组数组，从下往上大根堆排序
     */














    /**
     * 最大线段重合问题
     *
     *
     * 给了很多线段，然后再给个范围【start，end】。start和end都是整数
     * 1、线段开始和结束，一定都是整数
     * 2、线段重合长度>=1
     * 问这些线段在哪个区域重合的最多，多少重合
     */




    class MyHeap{
        //堆本身数据
        private ArrayList<Integer> heap;
        //存的数和角标
        private HashMap<Integer,Integer> indexMap;
        //堆大小
        private int heapSize;
        //比较逻辑
        private Comparator<Integer> cp;

        public MyHeap(){
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
            heapSize = 0;
            cp = new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            };
        }

        private void swap(int i , int j){
            //heap交换
            int midI =   heap.get(i);
            int midJ =  heap.get(j);
            heap.set(i,midJ);
            heap.set(j,midI);
            //indexMap交换
            indexMap.put(i,midJ);
            indexMap.put(j,midI);
        }

        //是否为空
        public boolean isEmpty(){
            return size() == 0;
        }
        //大小
        public int size(){
            return heapSize;
        }
        //是否包含
        public boolean haveInteger(int value){
            return indexMap.get(value) == null;
        }
        //返回顶部
        public Integer peek(){
            return  heap.get(0);
        }


        //弹出
        public Integer poll(){
            int result =  heap.get(0);
            //0位置，也就是头和最后一个子节点交换。这样拿出去不影响其他。整个树结构也是存在的
            swap(0,heapSize-1);
            //索引里也去除这个数，这个时候，去除的是result这个值
            indexMap.remove(result);
            heap.remove(heapSize--);
            //走一次重新排序，因为现在 0 和最后交换了，现在整个树不是小根堆
            heapify(0);
           return result;
        }
        //排序
        public void heapify(int head){

        }

        //删除任意值
        public void remove(int r){
            //找到角标
            int index = indexMap.get(r);
            //把角标和最后一个换
            swap(index,heapSize-1);
            //删除这个值


        }

    }

    public static void main(String[] args) {
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.isEmpty();
        integers.peek();
        integers.poll();
    }



    /**
     * 加强堆
     */

    class HeapGreater<T>{
        //堆本身，存的数据
        private ArrayList<T> heap;
        //存的数据和heap里角标的关系
        private HashMap<T,Integer> indexMap;
        //堆大小
        private int heapSize;
        //里面数据比较大小的逻辑
        private Comparator<? super T> comp;


        /**
         * 初始化
         */
        public HeapGreater(Comparator<? super T> c){
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
            heapSize = 0;
            comp = c;
        }
        //是否为空
        public boolean isEmpty(){
            return heapSize == 0;
        }
        //大小
        public int size(){
            return heapSize;
        }
        //是否包含
        public boolean contain(T o){
            return indexMap.containsKey(0);
        }
        //返回堆顶
        public T peek(){
            return heap.get(0);
        }
        //弹出
        public T pop(){
            T t = heap.get(0);
            //0位置，也就是头和最后一个子节点交换。这样拿出去不影响其他。整个树结构也是存在的
            swap(0,heapSize-1);
            //索引里也去除这个数
            indexMap.remove(t);
            heap.remove(--heapSize);
            //走一次重新排序，因为现在 0 和最后交换了，现在整个树不是小根堆
            heapify(0);
            return t;
        }

        public void remove(T o){
            //拿到树子节点尾巴
            T end = heap.get(heapSize - 1);
            //拿到这个要删除的对象的角标
            int index = indexMap.get(o);
            //map删除这个值
            indexMap.remove(o);
            //如果俩不相同
            if (o != end) {
                //挪到尾节点
                heap.set(index, end);
                indexMap.put(end, index);
                //因为尾节点挪到了之前 o 所在的地方，所以重新排序
                resign(end);
            }
            //删除尾巴
            heap.remove(--heapSize);
        }

        // 请返回堆上的所有元素
        public List<T> getAllElements() {
            List<T> ans = new ArrayList<>();
            for (T c : heap) {
                ans.add(c);
            }
            return ans;
        }

        /**
         * 排序
         */
        public void resign(T obj) {
            heapInsert(indexMap.get(obj));
            heapify(indexMap.get(obj));
        }



        /**
         * 大根堆举例
         *    6
         *  4   3
         * 1 0  2
         * -------
         * 6 4 3 1 0 2
         * 0 1 2 3 4 5
         * 从上往下过一遍  传过来的是角标
         */
        private void heapInsert(int index){
            //小根堆是左序，所以当前 - 1 ➗ 2 就是父的角标
            int right = (index - 1) >> 1;
            //根据比大小规则，如果正数，前面的大 负数，后面的大
            while (comp.compare(heap.get(index), heap.get(right)) < 0) {
                swap(index, right);
                //变成子，继续
                index = right;
            }
        }

        /**
         *
         * 从下往上过一遍
         */
        private void heapify(int index) {
            //它 * 2 +1 是他的子的角标
            int left = index << 1 +1;
            //得判断子是否存在
            while (left < heapSize) {
                //判断一下，在子的左右俩节点上，选一个更小的。
                //left+1有值 && left > left+1  best 就等于 left + 1
                int best = left + 1 < heapSize && comp.compare(heap.get(left + 1), heap.get(left)) < 0 ? (left + 1) : left;
                //index 大于 best
                best = comp.compare(heap.get(best), heap.get(index)) < 0 ? best : index;
                //子不是自己
                if (best == index) {
                    break;
                }
                //这一步其实就是index 和子交换
                swap(best, index);
                //变成子，继续
                index = best;
                //子继续找子
                left = index << 1 + 1;
            }
        }
        /**
         * 交换
         * 1、交换堆数据
         * 2、交换map的索引
         */
        private void swap(int i, int j) {
            T o1 = heap.get(i);
            T o2 = heap.get(j);
            heap.set(i, o2);
            heap.set(j, o1);
            indexMap.put(o2, i);
            indexMap.put(o1, j);
        }


    }


    /**
     * 堆排序
     */
    static class HeapSort{
        public static void main(String[] args) {
            System.out.println(Math.abs(100));
        }
    }





}

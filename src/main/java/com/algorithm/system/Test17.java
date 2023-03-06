package com.algorithm.system;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description
 * @Date 2023/3/1
 */
public class Test17 {


    /**
     * 给一个数组，输出有多少种结合的数组
     *  {1,2,3,4,5}
     *  1 12 13 14 15
     *  2 23 24 25 等都算
     */

    public static void getA(String str){
        ArrayList<String> result = new ArrayList<>();
        getB(str.toCharArray(),0,result,"");

        for (String s : result) {
            System.out.println(s);
        }
    }

    /**
     * @param arr 原始数组
     * @param index 走到哪个位置了
     * @param result 返回值
     * @param path 路径
     */
    private static void getB(char[] arr, int index, ArrayList<String> result, String path) {
        if(arr.length == index){
            result.add(path);
            return;
        }
        getB(arr,index+1,result,path);
        getB(arr,index+1,result,path+arr[index]+"");

    }


    /**
     * 给一个字符，输出有多少种结合的数组
     * 要有序
     * abcd
     * 第一次输出 a ab ac ad  。。。。
     * 第二次输出 b bc。。。。
     */
    public static void getC(String s){
        if(s == null || s.length() == 0 ){
            return;
        }
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> yu = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            yu.add(aChar+"");
        }
        getD(yu,strings,"");
        for (String str : strings) {
            System.out.println(str);
        }
    }

    private static void getD(ArrayList<String> yu, ArrayList<String> result, String s) {
        if(yu.isEmpty()){
            result.add(s);
            return;
        }
        for (int i = 0; i < yu.size(); i++) {
            String s1 = yu.get(i);
            yu.remove(i);
            getD(yu,result,s+s1);
            yu.add(i,s1);
        }
    }


    /**
     * 3版本
     */
    public static void getE(String s){
        if(s == null || s.length() == 0 ){
            return;
        }
        ArrayList<String> strings = new ArrayList<>();
        char[] chars = s.toCharArray();
        getF(chars,strings,0);
        for (String str : strings) {
            System.out.println(str);
        }
    }

    private static void swap(char[] chars,int i,int j){
       char a = chars[i];
       chars[i] = chars[j];
       chars[j] = a;
    }

    private static void getF(char[] chars, ArrayList<String> strings, int i) {
        if(chars.length == i){
            strings.add(String.valueOf(chars));
            return;
        }
        //要从 i 角标开始，因为 i 已经被换了
        for (int j = i; j < chars.length; j++) {
            char aChar = chars[j];
            swap(chars,j,i);
            getF(chars,strings,j+1);
            swap(chars,j,i);
        }

    }


    /*public static void main(String[] args) {
        //getA("abc");
        //getC("abc");
        //getE("abc");

        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(3);
        reverse(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }*/



    public static void reverse(Stack<Integer> stack){
        //为空返回
        if(stack.isEmpty()){
            return;
        }
        //不为空，拿到栈底部
        int a = getEnd(stack);
        //栈自己再去转，不为空不出来
        reverse(stack);
        //栈为空了，把栈底放进去，循环出来放，逆序了
        stack.push(a);
    }

    private static int getEnd(Stack<Integer> stack) {
        //栈不可能为空，因为上面方法判断了
        //栈弹出来一个
        Integer pop = stack.pop();
        if(stack.isEmpty()){
            //如果为空直接返回
            return pop;
        }
        //不为空一直转，直到为空。所有的过程值都存在了pop里面。
        //然后最终栈空了，最后一个pop就是end，然后end返回去，其他的过程pop又存入stack里面
        int end = getEnd(stack);
        stack.push(pop);
        return end;
    }











}

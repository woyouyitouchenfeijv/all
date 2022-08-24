package com.likou;

import org.junit.Test;

/**
 * @Description
 * @Date 2022/8/10
 */
public class Topic640 {
    public String solveEquation(String equation) {
        int right = 0,left = 0;
        String[] split = equation.split("=");
        /**
         * 数据分为
         * x  -x  2x 2
         */
        String[] leftSplit = split[0].replace("-", "+-").split("\\+");
        String[] rightSplit = split[1].replace("-", "+-").split("\\+");
        //左边
        for (String s : leftSplit) {
            if(s.equals("x")){
                left++;
            }else if(s.equals("-x")){
                left--;
            }else if(s.contains("x")){
                left+= Integer.parseInt(s.split("x")[0]);
            }else if(!s.equals("")){
                right -= Integer.parseInt(s);
            }
        }
        //右边
        for (String s : rightSplit) {
            if(s.equals("x")){
                left--;
            }else if(s.equals("-x")){
                left++;
            }else if(s.contains("x")){
                left-= Integer.parseInt(s.split("x")[0]);
            }else if(!s.equals("")){
                right += Integer.parseInt(s);
            }
        }
        if (left == 0) {
            if (right == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + right/left;
        }
    }

    @Test
    public void test(){
        String equation = "-x=-1";
        System.out.println(solveEquation(equation));
    }

    public static void main(String[] args) {
        int a = 1;
        char b = '+';
        int c = 1+b+a-b;
        System.out.println(c);

    }
}

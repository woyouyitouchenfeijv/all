package com.likou;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Date 2022/8/24
 */
public class Topic1460 {

    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (Integer integer : target) {
            Integer orDefault = map.getOrDefault(integer, 0);
            map.put(integer,orDefault+1);
        }
        for (int i : arr) {
            Integer integer = map.get(i);
            if(integer == null){
                return false;
            }else{
                map.put(i,integer -1);
            }
        }
        for (Integer integer : map.values()) {
            if(integer != 0){
                return false;
            }
        }
        return true;
    }


    @Test
    public void test(){
        int[] target = {7};
        int[] arr = {7};
        System.out.println(canBeEqual(target, arr));
    }
}

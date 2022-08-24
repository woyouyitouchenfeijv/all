package com.likou;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Date 2022/8/12
 */
public class Topic1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int group = groupSizes[i];
            List<Integer> integers = map.get(group);
            if(integers == null){
                integers =  new ArrayList<>();
                integers.add(i);
                map.put(group,integers);
            }else{
                integers.add(i);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int k : map.keySet()) {
            //拿到value
            List<Integer> list = map.get(k);
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                //把人放到组里
                cur.add(list.get(i));
                //如果组大小大于分的值，就再建一个组
                /**
                 * 有个问题，比如  3333。
                 *  1，2，3，4都要分到3个人的组，
                 *  但是总数是4 所以这个场景不考虑
                 */
                if (cur.size() == k) {
                    ans.add(cur);
                    cur = new ArrayList<>();
                }
            }
        }
        return ans;
    }

    @Test
    public void test(){
        int[] a = {3,3,3,3,3,1,3};
        System.out.println(groupThePeople(a));
    }
}

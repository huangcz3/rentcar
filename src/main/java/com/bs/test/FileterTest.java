package com.bs.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author User
 * @date 2018-04-18 14:08
 * @desc
 */
public class FileterTest {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("123456");
        set.add("147258");
        set.add("258369");
        set.add("159357");


        List<String> list = new ArrayList<>();
        list.add("147258");
        list.add("123456");
        list.add("111111");
        list.add("123789");

        set.stream().forEach(s -> System.out.println("过滤前" + s));

        list.stream().forEach(l ->{
            if (set.contains(l)){
                System.out.println("the same:"+l);
                set.remove(l);
            }
        });

        set.stream().forEach(s -> System.out.println("过滤后" + s));



    }

}

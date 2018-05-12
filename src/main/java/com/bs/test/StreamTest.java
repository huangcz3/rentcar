package com.bs.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author User
 * @date 2018-04-16 17:29
 * @desc
 */
public class StreamTest {

    public static void main(String[] args) {

        List<String> wordList = new ArrayList<>();

        wordList.add("a");
        wordList.add("b");
        wordList.add("C");


        wordList.forEach(s -> System.out.print(s));


        System.out.println();
        List<String> output = wordList.stream().map(String::toUpperCase).collect(Collectors.toList());
        output.forEach(s -> {
            System.out.print(s);
        });
        System.out.println();
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        Integer[] it = squareNums.stream().peek(s ->
                System.out.println(s)
        ).filter(i -> i%2 == 1).toArray(Integer[]::new);

        Arrays.stream(it).forEach(integer -> System.out.println(integer));
        System.out.println();




//        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
//        Integer[] evens = Arrays.stream(sixNums).filter(integer -> integer % 2 ==1).toArray(Integer[]::new);
//
//        Arrays.stream(evens).forEach(integer -> System.out.println(integer));


        System.out.println(Integer.MAX_VALUE);

    }
}

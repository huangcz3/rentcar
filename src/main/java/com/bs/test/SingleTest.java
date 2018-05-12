package com.bs.test;

/**
 * @author User
 * @date 2018-04-19 11:05
 * @desc
 */
public class SingleTest {

    private static SingleTest singleTest = null;

    private SingleTest() {
    }

    public static synchronized SingleTest getSingleTest() {

        if (singleTest == null){
            singleTest = new SingleTest();
        }

        System.out.println(singleTest);
        return singleTest;
    }

    public static void main(String[] args) {
        SingleTest singleTest = SingleTest.getSingleTest();
    }
}

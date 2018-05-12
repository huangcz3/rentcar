package com.bs.test;

/**
 * @author User
 * @date 2018-04-18 23:19
 * @desc
 */
public class WeiCaoZuoFuTest {

    public static void main(String[] args) {
        int i1 = 4;
        int i2 = 5;
        float f1 = 1.2f;
         float f2 = i1;
         f2 = f1;


        System.out.println(Integer.toBinaryString(i1));
        System.out.println(Integer.toBinaryString(i2));

        int reslut1 = i1 & i2;
        System.out.println(reslut1);
        System.out.println(Integer.toBinaryString(reslut1));

        int result2 = i1 | i2;
        System.out.println(result2);
        System.out.println(Integer.toBinaryString(result2));

        int result3 = i2 << 1;
        System.out.println(result3);
        System.out.println(Integer.toBinaryString(result3));


        System.out.println("****************");
        char c1 = '4';
        char c2 = '1';

        System.out.println((int)c1);
        System.out.println((int)c2);
        reslut1 = c1 + c2;
        System.out.println(reslut1);


    }
}

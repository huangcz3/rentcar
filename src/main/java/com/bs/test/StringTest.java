package com.bs.test;

import java.sql.Date;
import java.util.HashMap;

/**
 * @author hcz
 * @date   2018-03-22 10:21
 * @desc
 */
public class StringTest {

    public static void main(String[] args) {
        String str = "hello1";
        System.out.println(str.charAt(0));
        System.out.println(str.indexOf("l"));


        System.out.println(new Date(System.currentTimeMillis()));


        for (int i=0;i < 5 ;i++){
            System.out.println("137001"+String.format("%05d",i));
        }

        int i = 0;
        for (;;){
            System.out.println(i++);
//            if (i == 5) {
//                break;
//            }
//            continue;
        }


    }




}

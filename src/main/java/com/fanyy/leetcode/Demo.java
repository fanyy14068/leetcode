package com.fanyy.leetcode;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author: fanyy
 * Created on 2021/12/10
 */

public class Demo {
    public static void main(String[] args) {
        outClass out = new outClass();
        out.outPrint(10);
        Field[] s = out.getClass().getFields();
        for(Field i: s) {
            System.out.println(i);
        }
        try {
            System.out.println(out.getClass().getField("age"));
        } catch (NoSuchFieldException e) {
            System.out.println("aaa");

        }

    }


}

class outClass{
    private int age = 0;
    public int a = 100;
    public void outPrint( int x) {
        class inClass{
            public void inPrint() {
                age = 100;
                System.out.println(x);
                System.out.println(age);
            }
        }
        new inClass().inPrint();
    }
}

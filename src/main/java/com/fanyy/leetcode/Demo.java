package com.fanyy.leetcode;

import java.util.*;

/**
 * @author: fanyy
 * Created on 2021/12/10
 */

public class Demo {
    public static void main(String[] args) {
//        Square id = new Square(2);
//        System.out.println(id.getArea());
        System.out.println(2 & 1);
    }


}

class Square {
    int side;

    public Square() {
        this(1);
    }

    public Square(int side) {
        this.side = side;
    }

    public int getPerimeter() {
        return this.side * 4;
    }

    public int getArea() {
        return this.side * this.side;
    }
}

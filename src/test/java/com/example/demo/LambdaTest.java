package com.example.demo;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaTest {

    @Test
    public void testFunction(){
        List<Integer> list= Arrays.asList(3,1,5,2,6);
        list.sort((Integer o1,Integer o2) ->   o1.compareTo(o2));
        list.sort(( o1, o2) -> {
            int a=0;
            a+=1;
            return o1.compareTo(o2);
        });
    list.sort(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });
        System.out.println(list);
    }

    @Test
    public void testMathExpr() {
        MathExpr add = (a, b) -> a + b;

        System.out.println(add.calc(2, 3));

        Function<Integer,Integer> pow=(a)->a*a;
        BiFunction<Integer,Integer,Integer> add2=(a,b)->a+b;
        System.out.println("pow:"+pow.apply(3));
        System.out.println("add:"+add2.apply(2,3));
    }
}

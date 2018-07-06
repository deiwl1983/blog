package cn.zhaocai.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * test jdk8新特性
 */
public class JasonLambda_test {

    /**
     * 三种排序方法， 其中二种是lambda方法
     *
     */
    @Test
    public void testFunction(){
        List<Integer> list = Arrays.asList(5,2,9,0,6);
//        list.stream().max((o1, o2) -> o1.compareTo(o2)).get();
        list.sort((o1, o2) -> o1.compareTo(o2));

        list.sort((o1, o2) -> {

         return o1.compareTo(o2);
        });
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1<o2){
                    return -1;
                }else if (o1<o2){
                   return  1;
                }else {
                    return 0;
                }
            }
        });

        List<Integer> listSort = Arrays.asList(8,6,9,3,7,5,0);
        listSort.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(listSort);
        List<Integer> streamList = Arrays.asList(5,8,3,6,1,0,7,3,9);
       Integer max = streamList.stream().reduce((o1,o2) ->o1>o2?o1:o2).get();
       System.out.println(max);
    }

    @Test
    public void testMath(){
        Person p= (b , a ) -> a*b;
        int result = p.math(80, 3);
        System.out.println(result);
        System.out.println(p.math(80,3));

        Function<Integer,String> jason = (j) -> j.toString();
        System.out.println( jason.apply(9));
}
}

package cn.zhaocai.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 此流非IO流，而是Util集合
 */
public class testStream {

    @Test
    public void testStream1(){
        List<Employ> testEmploy = Arrays.asList(new Employ("jaosn",32),
                                            new Employ("deiwl",35),
                                            new Employ("huxing",33));
//        Student max=list.stream().reduce( (o1,o2)->o1.getScore()>o2.getScore()?o1:o2).get();
        Employ max =testEmploy.stream().reduce( (o1,o2) ->o1.getAge()<o2.getAge()?o1:o2).get();
        System.out.println(max);

//        List<String> studentNameList=list.stream().map((a)->a.getName()).collect(Collectors.toList());
        List<String> list =testEmploy.stream().map((a) -> a.getName()).collect(Collectors.toList());
        List<Integer> listAge =testEmploy.stream().map((a) -> a.getAge()).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(listAge);
    }

    @Test
    public void testForEach(){
        Employ e1 = new Employ("beijing",72),
                e2=   new Employ("changping",32),
                 e3=  new Employ("shahe",56);

        Stream.of(e1,e2,e3).forEach((jason) -> System.out.println(jason));
    }

    @Test
    public void testQian(){
        float a = 0.2f;
        int b = 45000;
        float c = b* a;
//        float e = b * 6.7f;
        float f =b-c;
        float j = b-(b* a);
        System.out.println(b*6.7);
        System.out.println(j*6.7);
    }
}

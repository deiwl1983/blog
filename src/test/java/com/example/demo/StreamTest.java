package com.example.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {


    @Test
    public void testStream(){

        List<Student> list= Arrays.asList(
                new Student("wang ming",78),
                new Student("Li Hua",78),
                new Student("Long Yins",38),
                new Student("He Wang",32),
                new Student("Li Li",88)
                );
        Student s=findMaxScoreStudent(list);

        Student max=list.stream().reduce( (o1,o2)->o1.getScore()>o2.getScore()?o1:o2).get();
        List<String> studentNameList=list.stream().map((a)->a.getName()).collect(Collectors.toList());
        List<Student> qualifiedStudents=list.stream().filter((a)->a.getScore()>=60).collect(Collectors.toList());
        System.out.println(s);
        System.out.println(max);
        System.out.println(studentNameList);
        System.out.println("qulified:"+qualifiedStudents);

    }


    @Test
    public void testStreamCreate(){
        Student a1=new Student("wang ming",78),
                a2=new Student("Li Hua",78),
               a3= new Student("Long Yins",38);
        Stream<Student> stream=Stream.of(a1,a2,a3);

        Stream.of(a1,a2,a3).forEach((a)-> System.out.println(a));
    }


    private Student findMaxScoreStudent(List<Student> list) {
        Student max=null;
        for(Student s:list){
            if(max==null){
                max=s;
                continue;
            }
            if(max.getScore()<s.getScore()){
                max=s;
            }else{

            }
        }
        return max;
    }
}

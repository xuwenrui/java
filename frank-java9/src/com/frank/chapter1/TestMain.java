package com.frank.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

/**
 * @description: 测试程序入口
 * 使用Lambda表达式通过条件过滤list
 * @author: xu.wr
 * @create: 2019-04-08 09:06
 **/
public class TestMain {
    /**
     * 使用Lambda表达式过滤数据
     */
    private static void filterListByLambda(List<Apple> apples){
        List<Apple> redApples=Apple.filterApples(apples, (Apple a) -> "红色".equals(a.getColor()));
        Apple.printList(redApples);
    }

    /**
     * 使用Stream和Lambda表达式过滤数据
     */
    private static void filterListByLambdaAndStream(List<Apple> apples){
        //顺序处理
        List<Apple> redApples=apples.stream().filter((Apple a) -> a.getWeight()>100).collect(Collectors.toList());
        //并行处理
//        List<Apple> redApples=apples.parallelStream().filter((Apple a) -> a.getWeight()>100).collect(Collectors.toList());
        Apple.printList(redApples);
    }

    /**
     * 用 Comparator 来排序
     */
    private static void sortByComparator(List<Apple> apples){
        apples.sort(Comparator.comparingInt(Apple::getWeight));
        apples.sort(Comparator.comparing(Apple::getWeight).reversed());
//        apples.sort((Apple a1, Apple a2) -> Integer.compare(a1.getWeight(), a2.getWeight()));
        Apple.printList(apples);
    }

    /**
     * 用 Runnable 执行代码块
     */
    private static void runnable(){
        Thread t = new Thread(() -> System.out.println("Hello world"));
        t.run();
    }

    /**
     * 返回某个属性的list
     */
    private static void  getPropertyList(List<Apple> apples){
        List<String> names=Apple.map(apples,(Apple p) -> p.getName());
        System.out.println(names.toString());


    }
    public static void main(String[] args) {
        List<Apple> apples=Apple.initAppleList();
//        filterListByLambda(apples);

//        filterListByLambdaAndStream(apples);

//        sortByComparator(apples);

//        runnable();

        getPropertyList(apples);
    }

}

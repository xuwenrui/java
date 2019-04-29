package com.frank.chapter3;

import com.frank.chapter1.Apple;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @description: 日常基本擦咋
 * @author: xu.wr
 * @create: 2019-04-29 10:36
 **/
public class BaseMain {
    private static void getColumn(List<Apple> apples){
        // 获取某一列的值
        List<String> names=apples.stream().map(Apple::getName).collect(Collectors.toList());
        System.out.println(names.toString());
    }

    /**
     * 根据某一列条件获取满足条件的集合
     * @param apples
     */
    private static void getListBuColumn(List<Apple> apples){
        // 获取某一列的值
        List<Apple> redApples=apples.stream().filter((Apple a) -> a.getWeight()>100).collect(Collectors.toList());
        Apple.printList(redApples);
    }

    /**
     * 根据某列去重
     * @param apples
     */
    private static void getDistinctListBuColumn(List<Apple> apples){

        //按name分组
        Map<String,List<Apple>> appleMap = apples.stream().collect(
                Collectors.groupingBy(Apple::getName));
        System.out.println(appleMap.size()+":"+appleMap.toString());
        //分组获取行数,方法一
        Map<String, Long> applecountMap =  apples.stream().
                collect(Collectors.groupingBy(Apple::getName,Collectors.counting()));
        System.out.println(applecountMap.size()+":"+applecountMap.toString());
        //分组获取行数,方法二
        Map<String, Long> applecountMap2= apples.stream().map(Apple::getName).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(applecountMap2.size()+":"+applecountMap2.toString());
        //分组后按count排序
        applecountMap2.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(System.out::println);
        //分组求和
        Map<String, Integer> sumMap = apples.stream().collect(
                Collectors.groupingBy(Apple::getName, Collectors.summingInt(Apple::getWeight)));
        System.out.println(sumMap.size()+":"+sumMap.toString());
    }
    //按属性分组
    public static void main(String[] args) {
        List<Apple> apples=Apple.initAppleList();
//        getColumn(apples);

//        getListBuColumn(apples);
//        getDistinctListBuColumn(apples);
            getDistinctListBuColumn(apples);
    }
}

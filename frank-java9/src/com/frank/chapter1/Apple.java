package com.frank.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @description: apple实体类
 * @author: xu.wr
 * @create: 2019-04-08 09:14
 **/
public class Apple {
    private Integer id;
    private String name;
    private int weight;
    private String color;

    public Apple(Integer id,String name, int weight, String color) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public static <T, R> List<R> map(List<T> list,Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T s: list){
            result.add(f.apply(s));
        }
        return result;
    }

    public static List<Apple> initAppleList(){
        List<Apple> apples=new ArrayList<>();
        Apple apple1=new Apple(1,"红富士1",120,"红色");
        Apple apple2=new Apple(2,"红富士2",100,"绿色");
        Apple apple3=new Apple(3,"乔纳金",80,"黄色");
        Apple apple4=new Apple(4,"黄元帅",100,"黄色");
        Apple apple5=new Apple(5,"红星",80,"红色");
        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
        apples.add(apple4);
        apples.add(apple5);
        return apples;
    }
    public static void printList(List<Apple> apples){
        if (apples.size()>0){
            for (Apple apple:apples){
                System.out.println(apple.toString());
            }
        }
    }
    public static List<Apple> filterApples(List<Apple> inventory,Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}

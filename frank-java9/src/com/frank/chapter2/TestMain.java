package com.frank.chapter2;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * @description:，如filter、map、reduce、find、match、sort、limit
 * @author: xu.wr
 * @create: 2019-04-15 15:42
 **/
public class TestMain {
    private static void lowCaloricDishesName(List<Dish> menu){
        List<String> lowCaloricDishesName =
                menu.stream()
//        menu.parallelStream()     多核并行
                        .filter(d -> d.getCalories() < 400)
                        .sorted(comparing(Dish::getCalories))
                        .map(Dish::getName)
                        .collect(Collectors.toList());
        System.out.println(lowCaloricDishesName);
    }

    public static void main(String[] args) {
        List<Dish> menu= Dish.initDish();
        lowCaloricDishesName(menu);
    }
}

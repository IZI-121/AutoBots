package com.autobots.java.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLesson {

    public static void main(String[] args) {

        MathOperations addition = (a,b) -> a+b;
        MathOperations multi = (a,b) -> a*b;

        System.out.println("5+3= " + addition.operate(5,3));
        System.out.println("5*3= " + multi.operate(5,3));

        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        System.out.println(isNotEmpty.test(""));
        System.out.println(isNotEmpty.test("Java"));

        Function<Integer,String> toStringFunction = integer -> "Число: " + integer;
        System.out.println(toStringFunction.apply(10));


        Consumer<String> print = s -> System.out.println("Writing: " + s);
        print.accept("Hello world");
    }
}

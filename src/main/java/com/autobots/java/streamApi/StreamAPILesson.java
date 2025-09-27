package com.autobots.java.streamApi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPILesson {
    public static void main(String[] args) {

        List<String> names = List.of("Anna", "Bob", "Alex", "Bella", "Andrew");

        for (String name : names) {
            if (name.startsWith("A"))
                System.out.println(name);
        }

        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int r1 = 0;
        for (int num : numbers) {
            r1 += num;
        }
        System.out.println(r1);

        int totalSum = numbers.stream()
                .mapToInt(num -> num)
                .sum();
        System.out.println(totalSum);

        int totalElements = (int) numbers.stream()
                .count();
        System.out.println(totalElements);

        numbers.stream()
                .min(Integer::compareTo)
                .ifPresent(System.out::println);

        List<String> list = List.of("one", "two", "three", "Hello", "four", "five");

        list.stream()
                .filter(s -> s.length() > 3)
                .findFirst()
                .ifPresent(System.out::println);


        List<Employee> employees = List.of(
                new Employee(1, "Alex", 25, 50000, "IT"),
        new Employee(2, "Maria", 30, 60000, "HR"),
        new Employee(3, "John", 28, 55000, "Finance"),
        new Employee(4, "Sophia", 35, 70000, "IT"),
        new Employee(5, "Michael", 40, 75000, "Management"),
        new Employee(6, "Emma", 26, 52000, "IT"),
        new Employee(7, "Daniel", 32, 58000, "Marketing"),
        new Employee(8, "Olivia", 29, 61000, "Finance"),
        new Employee(9, "James", 45, 80000, "Management"),
        new Employee(10, "Liam", 27, 53000, "HR")
        );

        List<Employee> itEmployees = employees.stream()
                .filter(s->s.getDepartment().equals("IT"))
                .collect(Collectors.toList());
        System.out.println(itEmployees);


        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        employeesByDepartment.forEach((department ,  list1)-> {
            System.out.println("Otdel: " + department);
            list1.forEach(System.out::println);
        });

    }
}

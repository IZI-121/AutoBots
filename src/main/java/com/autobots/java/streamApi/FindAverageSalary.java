package com.autobots.java.streamApi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindAverageSalary {
    public static void main(String[] args) {

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

        Map<String, Double> averageSalary = new HashMap<>();
        Map<String, Integer> averageSalary2 = new HashMap<>();
        int count = 0;
        for (Employee employee : employees) {
            averageSalary.put(employee.getDepartment(),
                    averageSalary.getOrDefault(employee.getDepartment(), 0.0)
                            + employee.getSalary());
            averageSalary2.put(employee.getDepartment(), averageSalary2.getOrDefault(employee.getDepartment(), 0) + 1);

        }
        double averageSal = 0.0;

        for (String department : averageSalary.keySet()) {
            averageSal = averageSalary.get(department) / averageSalary2.get(department);
            System.out.printf("%s -> $%.2f%n" , department,averageSal);
        }
        System.out.println("_______________________");

        Map<String, Double> averageSalaryByDepartmentWithStream = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        averageSalaryByDepartmentWithStream.forEach((dep,averageSa)->
                System.out.println(dep + " -> " + averageSa + " $"));






    }
}

package com.schollofnet.java8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {
    public static void main(String... args) throws InterruptedException {
        // new Thread(() -> System.out.println("Hello world!")).start();
        List<String> listStrs = Arrays.asList("Marcello", "Costa", "Java 8");

        Logger.log("FOR IN LIST");
        for (String str : listStrs) {
            System.out.println(str);
        }

        Logger.log("LAMBDAS");
        listStrs.forEach(str -> System.out.println(str));

        Logger.log("FILTER LIST");
        List<String> result = listStrs.stream().filter(str -> str.startsWith("M")).collect(Collectors.toList());

        result.forEach(System.out::print);

        Logger.log("CALL STATIC FUNCTION");
        result.forEach(Person::say);

        /*
         * JAVA 7 IMPLEMENTATION
         * 
         * MyInterface myinterface = new MyInterface() {
         * 
         * @Override public void print() { Logger.log("USING INTERFACE");
         * System.out.println("Java 7 implementation - Functional interface"); } };
         * 
         * myinterface.print();
         */

        // JAVA 8 IMPLEMENTATION
        MyInterface my1 = (String s) -> {
            Logger.log("USING INTERFACE");
            System.out.println("Java 8 implementation - Functional interface: " + s);
        };

        // my1.print();
        result.forEach(my1::print);

        Logger.log("CALLING DEFAULT METHOD INSIDE FUNCTIONAL INTERFACE");
        my1.body();

        Logger.log("STREAM FILTERED LIST");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 0, 9, 10, 0);
        List<Integer> filteredNumbers = numbers.stream().filter(number -> number != 0).collect(Collectors.toList());
        filteredNumbers.forEach(System.out::println);

        Logger.log("STREAM FILTERED LIST 2");
        List<String> text = Arrays.asList("a", "b", "c", "", "d", "", "f", "");
        List<String> filteredText = text.stream().filter(txt -> !txt.isEmpty()).collect(Collectors.toList());
        filteredText.forEach(System.out::println);

        Logger.log("PARALLEL STREAM FILTERED LIST WITH JOIN");
        List<String> text2 = Arrays.asList("a1", "b2", "c3", "", "d4", "", "f5", "");
        String ListToString = text2.parallelStream().filter(txt -> !txt.isEmpty()).collect(Collectors.joining(","));
        System.out.println(ListToString);

        Logger.log("RANDOM NUMBERS WITH LIMIT");
        Random hash = new Random();
        hash.doubles().limit(3).forEach(System.out::println);

        Logger.log("CHECKING FOR NULL VALUES WITH OPTIONAL");
        List<Person> people = new ArrayList<Person>();

        Person person1 = new Person(1, "Marcello");
        Person person2 = new Person(2, "John");
        Person person3 = new Person(3, "Jane");
        Person person4 = new Person(4, null);

        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);

        people.forEach(p -> {
            String name = p.getName();
            Optional<String> op = Optional.ofNullable(name);
            System.out.println("Person ID: " + p.getId());
            op.ifPresent(System.out::println);

            if (!op.isPresent()) {
                System.out.println("Person ID " + p.getId() + " has null name");
            }
            System.out.println("-----");
        });

        Logger.log("DATE-TIME API");
        Instant now = Instant.now();
        Thread.sleep(1000);
        Instant now2 = Instant.now();

        Duration dur = Duration.between(now, now2);
        System.out.println("Time diff: " + dur.getSeconds() + " seconds ");

        LocalDate local = LocalDate.now();
        System.out.println("Date: " + local);

        LocalDate birthday1 = LocalDate.of(1988, 03, 22);
        LocalDate birthday2 = LocalDate.of(2020, 12, 30);

        Period period = Period.between(birthday1, birthday2);

        System.out.printf("Age: %s years, %s months, %s days ", period.getYears(), period.getMonths(),
                period.getDays());

        Logger.log("SCRIPT ENGINE MANAGER");
        ScriptEngineManager SEM = new ScriptEngineManager();
        ScriptEngine nashorn = SEM.getEngineByName("nashorn");

        try {
            nashorn.eval("print('Hello World from Nashorn')");
        } catch (ScriptException ex) {
            ex.getStackTrace();
        }
    }
}

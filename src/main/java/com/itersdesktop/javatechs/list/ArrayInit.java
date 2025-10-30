package com.itersdesktop.javatechs.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>Demonstrates how to initialise an array</p>
 *
 * @author <a href="mailto:nvntung@gmail.com">Tung Nguyen</a>
 */
public class ArrayInit {
    public static void main(String[] args) {
        //1. Init the array by using add method
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Peach");
        list.add("Orange");
        list.add("Banana");
        list.add("Avocado");
        list.stream().forEach(System.out::println);

        //2. Init the array when declaring using the add method
        List<String> names = new ArrayList<>() {
            {
                add("Tung");
                add("Hue");
                add("Khang");
                add("Phu");
            }
        };
        names.stream().forEach(System.out::println);

        //3. Init the array using Arrays.asList()
        List<String> subjects = new ArrayList<>(
                Arrays.asList("Maths", "English", "Science", "Computing", "Religions", "PE", "Engineering"));
        subjects.stream().forEach(System.out::println);

        //4. Init the array using List.of()
        List<String> teams = new ArrayList<>(
            List.of("WebAdmin", "Storage", "Network", "Security", "Database", "DevOps", "IT Support")
        );
        teams.stream().forEach(System.out::println);

        //5. Init the array using the other array/list
        // create another collection
        List<Integer> l = new ArrayList<>();
        l.add(1);l.add(2);l.add(3);l.add(4);l.add(5);
        List<Integer> l2 = new ArrayList<>(l);
        l2.stream().forEach(System.out::println);

        //6. Init the array using stream() and collect()
        // create a stream of elements using Stream.of()
        // method collect the stream elements into an
        // ArrayList using the collect() method and
        // Collectors.toCollection() method
        ArrayList<String> al = Stream
                .of("Dr", "Nguyen", "Vu", "Ngoc", "Tung")
                .collect(Collectors.toCollection(ArrayList::new));
        al.stream().forEach(System.out::println);
    }
}

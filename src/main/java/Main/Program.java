package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Program {

    public static void main(String[] args) throws IOException {
        List<Integer> stringList = new ArrayList<>();
        stringList.add(5);
        stringList.add(4);
        stringList.add(2);
        stringList.add(2);
        stringList.add(2);
        System.out.println(partition(stringList, 2));

        long count = Stream.of("how", "to", "do", "in", "java")
                .count();
        System.out.printf("There are %d words in the stream %n", count);

        count = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .count();
        System.out.printf("There are %d integers in the stream %n", count);

        count = LongStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(i -> i % 2 == 0)
                .count();
        System.out.printf("There are %d even numbers in the stream %n", count);

        long count2 = Stream.of("how", "to", "do", "in", "java")
                .collect(Collectors.counting());
        System.out.printf("There are %d words in the stream %n", count);

        count = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .collect(Collectors.counting());
        System.out.printf("There are %d integers in the stream %n", count);

        count = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(i -> i % 2 == 0)
                .collect(Collectors.counting());
        System.out.printf("There are %d even numbers in the stream %n", count);

        List<String> cities = Arrays.asList(
                "London",
                "Sydney",
                "Colombo",
                "Cairo",
                "Beijing");

        cities.stream()
                .filter(a -> a.startsWith("C"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
        try (BufferedReader br = Files.newBufferedReader(Paths.get("src/main/java/Main/lorem.txt"))) {

            Object[] lines = br.lines()
                    .filter(x -> x.startsWith("c"))
                    .sorted()
                    .toArray();
            System.out.println(lines);
        } catch (IOException e) {
            System.out.println(e);
        }


    }

    public static <T> Optional<Boolean> partition(List<T> list, T value) {

        return Stream.of(list).map(x -> x.contains(value))
                .findAny();
    }

    public String doSo(int[] seconds) {
        return (Arrays.stream(seconds)
                .mapToObj(x -> "Hours: " + x / 3600 + " Minutes: " + x % 3600 / 60 + " Seconds: " + x % 3600 % 60)
                .findFirst()
                .orElse("invalid"));
    }


}

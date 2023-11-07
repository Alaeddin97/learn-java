package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("======================Test buildStream start =====================================");
        Stream<String> sfValues = Stream.of("a1", "a2", "a3");
        System.out.println("streamFromValues: " + Arrays.toString(sfValues.toArray()));

        Stream<String> sfArray = Arrays.stream(new String[]{"a1", "a2", "a3"});
        System.out.println("streamFromArray: " + Arrays.toString(sfArray.toArray()));

        Stream<String> streamFromFiles = Files.lines(Paths.get("files/file.txt"));
        System.out.println(
                "streamFromFiles = " + streamFromFiles.collect(Collectors.toList()));

        Stream<Integer> sfIterator = Stream.iterate(4, integer -> integer > 3, i -> i + 1);
        System.out.println("sfIterator = " + sfIterator.limit(10).collect(Collectors.toList()));

        Stream<Integer> sfGenerator = Stream.generate(() -> 1);
        System.out.println("sfGenerator = " + sfGenerator.limit(3).collect(Collectors.toList()));

        System.out.println("====================Test filter and count=============================");
        testFilterAndCount();
        testFindFirstSkipCount();
        testLimit();
        testDistinct();
        testMatch();
        testMap();
        testFlatMap();
        testSorted();
        testPeek();
        testReduce();
        testCollect();
    }

    public static void testFilterAndCount() {
        System.out.println();
        System.out.println("Test filter and count start");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        Collection<Main.People> peoples = Arrays.asList(
                new Main.People("William", 16, Main.Sex.MAN),
                new Main.People("John", 23, Main.Sex.MAN),
                new Main.People("Helen", 42, Main.Sex.WOMEN),
                new Main.People("Peter", 69, Main.Sex.MAN)
        );

        long collectionCount = collection.stream().count();
        System.out.println("collectionCount = " + collectionCount);

        long peopleCount = peoples.stream()
                .filter(people -> people.getAge() > 16 && people.getSex().equals(Sex.MAN))
                .count();
        System.out.println("peopleCount = " + peopleCount);

        peoples.stream()
                .filter(people -> people.getAge() > 2 && people.getSex() != Sex.WOMEN)
                .mapToInt(People::getAge)
                .forEach(System.out::println);

        OptionalDouble average = peoples.stream()
                .filter(people -> people.getAge() > 2 && people.getSex() != Sex.WOMEN)
                .mapToInt(People::getAge)
                .average();
        System.out.println("average = " + average);
    }

    public static void testFindFirstSkipCount() {
        Collection<String> collection = Arrays.asList("a11", "a2", "a23", "a1");
        System.out.println("Find first");
        Optional<String> first =
                collection.stream()
                        .filter(m -> m.contains("2"))
                        .findFirst();
        System.out.println("first = " + first);

        Collection<Integer> integers = Arrays.asList(1, 2, 3, 1, 10, 33, 21, 45, 56, 98, 90, 31);
        Optional<Integer> firstInt = integers.stream()
                .filter(i -> i > 10)
                .skip(1)
                .findFirst();
        System.out.println("firstInt = " + (firstInt.get()));
    }

    private static void testLimit() {
        System.out.println("Test limit");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1", "a2", "a3");
        collection.stream()
                .skip(2)
                .limit(2)
                .forEach(System.out::println);
    }

    private static void testDistinct() {
        System.out.println("Test distinct");
        Collection<String> collection = Arrays.asList("a1", "a2", "b1", "b2", "a1", "a2", "b1", "b2");
        List<String> collect = collection.stream()
                .distinct()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    private static void testMatch() {
        Collection<String> collection = Arrays.asList("hello", "every", "one", "from", "math department");
        boolean allMatch = collection.stream()
                .allMatch(m -> m.length() == 4);
        System.out.println("allMatch = " + allMatch);

        boolean anyMatch = collection.stream()
                .anyMatch(m -> m.length() > 10);
        System.out.println("anyMatch = " + anyMatch);
    }

    private static void testMap() {
        System.out.println("Test map start");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        List<String> list = collection.stream()
                .map(
                        s -> {
                            return s.toUpperCase();
                        }
                )
                .toList();
        System.out.println("list = " + list);

        Collection<People> peoples = Arrays.asList(
                new People("Grigori", 44, Sex.MAN),
                new People("Aladdin", 26, Sex.MAN),
                new People("Yassin", 23, Sex.MAN)
        );
        List<People> stringList = peoples.stream()
                .map(
                        people -> {
                            if (people.getAge() == 44) people.setName("Grigori Perlman");
                            return people;
                        }
                )
                .toList();
        System.out.println("stringList = " + stringList);
    }

    private static void testFlatMap() {
        System.out.println();
        System.out.println("Test flat map start");
        Collection<String> collection = Arrays.asList("1,2,0", "4,5");
        Stream<Integer> integerStream = collection.stream()
                .flatMap(
                        s -> Arrays.stream(s.split(","))
                                .map(Integer::parseInt));
        System.out.println("integerStream = " + integerStream.toList());

    }

    private static void testSorted() {
        Collection<Integer> collection = Arrays.asList(1, 22, 3, 14, 51, 66, 7, 81, 9);
        List<Integer> list = collection.stream()
                .sorted().toList();
        System.out.println("list = " + list);

        Collection<Main.People> peoples = Arrays.asList(
                new Main.People("William", 16, Main.Sex.MAN),
                new Main.People("John", 23, Main.Sex.MAN),
                new Main.People("Helen", 42, Main.Sex.WOMEN),
                new Main.People("Peter", 69, Main.Sex.MAN)
        );
        List<People> list1 = peoples.stream()
                .sorted().toList();
        System.out.println("list1 = " + list1);
    }

    private static void testPeek() {
        Collection<Main.People> peoples = Arrays.asList(
                new Main.People("William", 16, Main.Sex.MAN),
                new Main.People("John", 23, Main.Sex.MAN),
                new Main.People("Helen", 42, Main.Sex.WOMEN),
                new Main.People("Peter", 69, Main.Sex.MAN)
        );

        List<People> list = peoples.stream()
                .peek(
                        people -> people.setName("name: " + people.getName())
                ).
                toList();
        System.out.println("list = " + list);

    }

    private static void testReduce() {
        Collection<Main.People> peoples = Arrays.asList(
                new Main.People("William", 16, Main.Sex.MAN),
                new Main.People("John", 23, Main.Sex.MAN),
                new Main.People("Helen", 42, Main.Sex.WOMEN),
                new Main.People("Peter", 69, Main.Sex.MAN)
        );

        People reducedPeople = peoples.stream()
                .reduce(peoples.stream().toList().get(0), (p, q) -> {
                    p.name = p.name + q.name;
                    return p;
                });
        System.out.println("reducedPeople = " + reducedPeople);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result = numbers
                .stream()
                .reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println("result = " + result);
    }

    private static void testCollect() {
        Collection<Main.People> peoples = Arrays.asList(
                new Main.People("William", 20, Main.Sex.MAN),
                new Main.People("John", 20, Main.Sex.MAN),
                new Main.People("Helen", 40, Main.Sex.WOMEN),
                new Main.People("Peter", 69, Main.Sex.MAN)
        );

        List<Integer> list1 = peoples.stream()
                .map(people -> {
                    people.setName("Euler ");
                    return people;
                })
                .collect(
                        Collectors
                        .mapping(p -> p.age, Collectors.toList()));
        System.out.println("mapping  = " + list1);


        Long counting = peoples.stream()
                .collect(Collectors.counting());
        System.out.println("counting = " + counting);

        Optional<People> minBy = peoples.stream()
                .collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println("minBy = " + minBy);

        Optional<People> maxBy = peoples.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.println("maxBy = " + maxBy);

        Map<Integer, List<People>> groupingBy = peoples.stream()
                .collect(Collectors.groupingBy(People::getAge));
        System.out.println("groupingBy = " + groupingBy.get(40));

        Map<Integer, Map<Integer, String>> complexGroupBy = peoples.stream()
                .collect(Collectors.groupingBy(People::getAge,
                        Collectors.toMap(People::getAge, People::getName)));
    }


    private enum Sex {
        MAN,
        WOMEN
    }

    private static class People implements Comparable<People> {
        private String name;
        private final Integer age;
        private final Main.Sex sex;


        public People(String name, Integer age, Main.Sex sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Main.Sex getSex() {
            return sex;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex=" + sex +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Main.People)) return false;
            Main.People people = (Main.People) o;
            return Objects.equals(name, people.name) &&
                    Objects.equals(age, people.age) &&
                    Objects.equals(sex, people.sex);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, sex);
        }

        @Override
        public int compareTo(People o) {
            return this.age - o.getAge();
        }
    }
}


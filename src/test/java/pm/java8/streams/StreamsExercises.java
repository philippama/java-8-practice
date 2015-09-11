package pm.java8.streams;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test suite demonstrates the following ways of generating and using streams.
 *
 * Creating streams
 *        Stream.of(), infinite stream with limit, Collection.stream(), from array, from file.
 *        Stream<String> stream = Stream.of("a", "b");
 *        IntStream positiveIntegers = IntStream.iterate(1, i -> i++).limit(100);
 *        IntStream range = IntStream.range(1, 100);
 *        Arrays.asList("1", "2", "3").stream();
 *        String strings[] = {"a", "b", "c"};
 *        Arrays.stream(strings);
 *        Files.lines(path); or Files.newBufferedReader(path).lines();
 *
 * Intermediate operations (return a Stream)
 *        stream.filter(s -> s.startsWith("b"));
 *        stream.limit(3);
 *        stream.map(String::toUpperCase);
 *        stream.peek(System.out::println);
 *        stream.sorted();
 *        stream.sorted(comparator.thenComparing())
 *        stream.mapToInt(String::length).max().getAsInt();
 *        stream.flatMap();
 *        stream.distinct();
 *
 * Terminal operations and collectors
 *        stream.forEach(s -> System.out.println(s)); // method reference?
 *        stream.count();
 *        [todo: stream.reduce()]
 *        stream.collect(Collectors.toList());
 *        stream.collect(Collectors.joining(","));
 *        stream.collect(Collectors.groupingBy(String::length));
 */
public class StreamsExercises {

    private List<Person> people = Arrays.asList(
            new Person("Bernard", "Sawrey"),
            new Person("Duncan", "Sawrey"),
            new Person("Anastasia", "Sawrey"),
            new Person("Charlotte", "Sawrey"),
            new Person("Daphne", "Sawrey"),
            new Person("Gerald", "Hawkshead"),
            new Person("Eustace", "Hawkshead"),
            new Person("Felicity", "Coniston")
    );

    /*
     * Shows:
     *  Collection.stream()
     *  Stream.forEach()
     */
    @Test
    public void verySimpleForEach() {
        List<String> sentence = Arrays.asList("I", "can", "print", "a", "stream", ".");

        // Convert the the sentence to a stream and print it.
        //TODO

    }

    /*
     * Shows:
     *  Arrays.stream()
     *  Stream.count()
     */
    @Test
    public void countNumberOfElementsInStream() {
        String words[] = {"There", "are", "four", "words"};

        long count = 0;

        //TODO

        assertThat(count).isEqualTo(4);
    }

    /*
     * Shows:
     *  Collection.stream()
     *  Stream.mapToInt()
     *  Stream.sum()
     */
    @Test
    public void sumWordLengths() {
        List<String> words = Arrays.asList("one", "two", "three", "four", "five");

        long totalLength = 0;

        //TODO

        assertThat(totalLength).isEqualTo(19);
    }

    /*
     * Shows:
     *  Collection.stream()
     *  Stream.map()
     *  Stream.collect()
     *  Collectors.toList()
     */
    @Test
    public void makeListOfFirstNamesFromPeople() {

        List<String> names = null;

        //TODO

        assertThat(names).isEqualTo(Arrays.asList("Bernard", "Duncan", "Anastasia", "Charlotte", "Daphne", "Gerald", "Eustace", "Felicity"));
    }

    /*
     * Shows:
     *  Collection.stream()
     *  Stream.map()
     *  Stream.collect()
     *  Collectors.joining()
     */
    @Test
    public void makeStringOfFirstNamesFromPeople() {

        String names = null;

        //TODO

        assertThat(names).isEqualTo("Bernard,Duncan,Anastasia,Charlotte,Daphne,Gerald,Eustace,Felicity");
    }

    /*
     * Shows:
     *  Collection.stream()
     *  Stream.map()
     *  Stream.sorted()
     *  Stream.collect()
     *  Collectors.toList()
     */
    @Test
    public void makeListOfFirstNamesFromPeopleInAlphabeticalOrder() {

        List<String> names = null;

        //TODO

        assertThat(names).isEqualTo(Arrays.asList("Anastasia", "Bernard", "Charlotte", "Daphne", "Duncan", "Eustace", "Felicity", "Gerald"));
    }

    /*
     * Shows:
     *  Collection.stream()
     *  Stream.sorted()
     *  Comparator.comparing()
     *  Stream.limit()
     *  Stream.collect()
     *  Collectors.toList()
     */
    @Test
    public void makeListOf1st3PeopleInAlphabeticalOrderLastNameThenFirstName() {

        List<Person> names = null;

        //TODO

        assertThat(names).containsExactlyElementsOf(Arrays.asList(
                new Person("Felicity", "Coniston"),
                new Person("Eustace", "Hawkshead"),
                new Person("Gerald", "Hawkshead")
        ));
    }

    /*
     * Shows:
     *  Collection.stream()
     *  Stream.flatMap()
     *  Stream.of()
     *  Stream.distinct()
     *  Stream.sorted()
     *  Stream.collect()
     *  Collectors.toList()
     */
    @Test
    public void makeListOfAllUniqueFirstAndLastNamesInAlphabeticalOrder() {

        List<String> names = null;

        //TODO

        assertThat(names).isEqualTo(Arrays.asList("Anastasia", "Bernard", "Charlotte", "Coniston", "Daphne", "Duncan", "Eustace", "Felicity", "Gerald", "Hawkshead", "Sawrey"));
    }

    /*
     * Shows:
     *  Files.lines() or Files.newBufferedReader()
     *  Stream.flatMap()
     *  Arrays.stream() - you can use regular expression "\\s+" to split the stream
     *  Stream.filter()
     *  Stream.collect()
     *  Collectors.toList()
     */
    @Test
    public void makeListOfAllFourLetteredWords() throws IOException {

        Path path = Paths.get("src/test/resources/receipt.txt");

        List<String> fourLetteredWords = null;

        // When the test passes, see if you can print out all the lines of the limerick before you break out the words.

        //TODO

        assertThat(fourLetteredWords).containsOnly("unam", "ago.", "tibi", "tuum", "fili");
    }

    /*
     * Shows:
     *  IntStream.iterate() or IntStream.range() or IntStream.rangeClosed()
     *  IntStream.limit() if using iterate()
     *  IntStream.sum()
     */
    @Test
    public void sumFirstTwelveIntegersWithIntStream() {

        long sum = 0L;

        // Example solution using iterate() and range()
        sum = IntStream.iterate(1, i -> i + 1)
                .limit(12)
                .sum();

        //TODO

        assertThat(sum).isEqualTo(78L);
    }

    /*
     * Shows:
     *  Collection.stream()
     *  Stream.collect()
     *  Collectors.groupingBy()
     */
    @Test
    public void getPeopleByLastName() {

        Map<String, List<Person>> groups = null;

        //TODO

        assertThat(groups).containsKeys("Coniston", "Hawkshead", "Sawrey");
        assertThat(groups.get("Coniston")).containsExactlyElementsOf(Arrays.asList(new Person("Felicity", "Coniston")));
        assertThat(groups.get("Hawkshead")).containsExactlyElementsOf(Arrays.asList(
                new Person("Gerald", "Hawkshead"),
                new Person("Eustace", "Hawkshead")
        ));
        assertThat(groups.get("Sawrey")).containsExactlyElementsOf(Arrays.asList(
                new Person("Bernard", "Sawrey"),
                new Person("Duncan", "Sawrey"),
                new Person("Anastasia", "Sawrey"),
                new Person("Charlotte", "Sawrey"),
                new Person("Daphne", "Sawrey")
        ));
    }

    static class Person {
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {

            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            final Person other = (Person) obj;
            return Objects.equals(this.firstName, other.firstName)
                    && Objects.equals(this.lastName, other.lastName);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
}

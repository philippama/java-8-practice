package pm.java8.streams;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

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
 *        stream.forEach(System.out::println);
 *        stream.count();
 *        stream.collect(Collectors.toList());
 *        stream.collect(Collectors.toMap(String::toLowerCase, String::toUpperCase);
 *        stream.collect(Collectors.joining(","));
 *        stream.collect(Collectors.groupingBy(String::length));
 *        stream.reduce()
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

        // You could do this with a List.forEach() but use a stream for practice:
        // convert the the sentence to a stream and print the words, one per line.

        // TODO

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

        // Count the number of words.

        // TODO

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

        // Add the lengths of all the words.

        // TODO

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

        // Start with List<Person> people which is defined above. Make a list of first names.

        // TODO

        assertThat(names).isEqualTo(Arrays.asList("Bernard", "Duncan", "Anastasia", "Charlotte", "Daphne", "Gerald", "Eustace", "Felicity"));
    }

    /*
     * Shows:
     *  Collection.stream()
     *  Stream.collect()
     *  Collectors.toMap()
     */
    @Test
    public void makeMapOfFirstNameToLastName() {

        Map<String, String> firstToLast = null;

        // Start with List<Person> people which is defined above. Make a map with key = first name, value = last name.

        // TODO

        assertThat(firstToLast).containsOnly(
                entry("Bernard", "Sawrey"),
                entry("Duncan", "Sawrey"),
                entry("Anastasia", "Sawrey"),
                entry("Charlotte", "Sawrey"),
                entry("Daphne", "Sawrey"),
                entry("Gerald", "Hawkshead"),
                entry("Eustace", "Hawkshead"),
                entry("Felicity", "Coniston")
        );
    }

    /*
     * Shows:
     *  Collection.stream()
     *  Stream.collect()
     *  Collectors.toMap()
     */
    @Test
    public void makeMapOfLowerFirstNameToUpperLastName() {

        Map<String, String> firstToLast = null;

        // Start with List<Person> people which is defined above.
        // Make a map with key = first name in lower case, value = last name in upper case.

        // TODO

        assertThat(firstToLast).containsOnly(
                entry("bernard", "SAWREY"),
                entry("duncan", "SAWREY"),
                entry("anastasia", "SAWREY"),
                entry("charlotte", "SAWREY"),
                entry("daphne", "SAWREY"),
                entry("gerald", "HAWKSHEAD"),
                entry("eustace", "HAWKSHEAD"),
                entry("felicity", "CONISTON")
        );
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

        // Start with List<Person> people which is defined above.
        // Join all the first names to form a comma separated string.

        // TODO

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

        // Start with List<Person> people which is defined above. Make a list of first names in alphabetical order.

        // TODO

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

        // Start with List<Person> people which is defined above. Make a list of the first three names in alphabetical
        // order when sorted by last name then first name.

        // TODO

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

        // Start with List<Person> people which is defined above. Make a list of all the first and last names in
        // alphabetical order.

        // TODO

        assertThat(names).isEqualTo(Arrays.asList("Anastasia", "Bernard", "Charlotte", "Coniston", "Daphne", "Duncan",
                                                  "Eustace", "Felicity", "Gerald", "Hawkshead", "Sawrey"));
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

        // Make a list of all the four lettered words in a file.
        // When the test passes, see if you can print out all the lines of the limerick before you break out the words.

        // TODO

        assertThat(fourLetteredWords).containsOnly("unam", "tibi", "tuum", "fili");
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

        // Sum the first twelve integers (1-12)

        // TODO

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

        // Start with List<Person> people which is defined above. Create a map with
        // key = last name and value = a list of people with that last name.

        // TODO

        assertThat(groups).containsKeys("Coniston", "Hawkshead", "Sawrey");

        // People with last name = "Coniston"
        assertThat(groups.get("Coniston")).containsExactlyElementsOf(Arrays.asList(
                new Person("Felicity", "Coniston")
        ));

        // People with last name = "Hawkshead"
        assertThat(groups.get("Hawkshead")).containsExactlyElementsOf(Arrays.asList(
                new Person("Gerald", "Hawkshead"),
                new Person("Eustace", "Hawkshead")
        ));

        // People with last name = "Sawrey"
        assertThat(groups.get("Sawrey")).containsExactlyElementsOf(Arrays.asList(
                new Person("Bernard", "Sawrey"),
                new Person("Duncan", "Sawrey"),
                new Person("Anastasia", "Sawrey"),
                new Person("Charlotte", "Sawrey"),
                new Person("Daphne", "Sawrey")
        ));
    }

    /*
    * Shows:
    *  Collection.stream()
    *  Stream.reduce()
    */
    @Test
    public void makeHashMapOfFirstNameToLastName() {

        Map<String, String> firstToLast = null;

        // This is similar to makeMapOfFirstNameToLastName() except we are generating a specific type of Map
        // rather than using the Map generated by Collectors.toMap().
        // Start with List<Person> people which is defined above.
        // Make a HashMap with key = first name, value = last name.

        // TODO

        assertThat(firstToLast).isExactlyInstanceOf(HashMap.class);
        assertThat(firstToLast).containsOnly(
                entry("Bernard", "Sawrey"),
                entry("Duncan", "Sawrey"),
                entry("Anastasia", "Sawrey"),
                entry("Charlotte", "Sawrey"),
                entry("Daphne", "Sawrey"),
                entry("Gerald", "Hawkshead"),
                entry("Eustace", "Hawkshead"),
                entry("Felicity", "Coniston")
        );
    }

    static class Person {
        private String firstName;
        private String lastName;

        Person(String firstName, String lastName) {

            this.firstName = firstName;
            this.lastName = lastName;
        }

        String getFirstName() {
            return firstName;
        }

        String getLastName() {
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

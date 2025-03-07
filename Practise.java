import java.lang.annotation.Target;
import java.util.*;
import java.util.stream.Collectors;

class Person{
    String name;
    String city;

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class StreamDemo{
    private <T> void print(List<T> list){
        list.forEach(System.out::println);
    }

    private <T> void print(Optional<T> optionalT){
        if(optionalT.isPresent()){
            System.out.println(optionalT.get());
        }
        else{
            System.out.println("Doesn't exist");
        }
    }
    public void filterByEven(){
        List<Integer> arrayList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<Integer> a = arrayList.stream().filter(num -> num%2 == 0).toList();
        print(a);
    }

    public void convertToUpper(){
        List<String> stringList = Arrays.asList("alice", "bob", "charlie");

        print(stringList.stream().map(s -> s.toUpperCase()).collect(Collectors.toList()));
    }

    public void findFirstElementGreaterThan10(){
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);

        print(arrayList.stream().filter(num -> num > 10).findFirst());

        arrayList.add(13);
        arrayList.add(12);
        arrayList.add(11);

        print(arrayList.stream().filter(num -> num > 10).findFirst());
    }

    public void sortListOfIntegersAsc(){
        List<Integer> arrayList = Arrays.asList(5,1,2,4,3);

        print(arrayList.stream().sorted().collect(Collectors.toList()));
    }

    public void sortListOfIntegersDesc(){
        List<Integer> arrayList = Arrays.asList(5,1,2,4,3);

        print(arrayList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }

    public void removeDuplicateElementsFromList(){
        List<Integer> arrayList = Arrays.asList(5,1,2,4,3,5,1,2,4,3,10,5,1,2,4,3,6,6,7,8);

        print(arrayList.stream().distinct().collect(Collectors.toList()));
    }

    public void findMaxValueInList(){
        List<Integer> arrayList = Arrays.asList(5,1,20,4,3,5,1,2,4,3,10,5,1,2,4,3,6,6,7,8);

        print(arrayList.stream().max(Integer::compareTo));
    }

    public void joinListOfStrings(){
        List<String> stringList = Arrays.asList("alice", "bob", "charlie", "doe", "eagle");

        String result = stringList.stream().reduce("", (acc, word)-> acc + word + ", ");

        System.out.println(result);
    }

    public void groupListOfStringsByLength(){
        List<String> stringList = Arrays.asList("alice", "bob", "charlie", "doe", "eagle", "srinivas");

        Map<Integer, List<String>> map = stringList.stream().collect(Collectors.groupingBy(String::length));

        map.forEach((length, listOfStrings) -> {
            System.out.print("For length " + length + ": ");
            listOfStrings.forEach(s -> {
                System.out.print(s + ", ");
            });
            System.out.println();
        });
    }

    public void sumOfSquaresOfOddNumbers(){
        int n = 1;
        List<Integer> integerList = new ArrayList<>();

        for(int i=0;i<n;i++){
            integerList.add(i+1);
        }

        Integer sumOfSquares = integerList
                .stream()
                .filter(val -> val%2 == 1)
                .map(val -> val*val)
                .reduce(0, (acc, val)-> acc+val);
        System.out.print(sumOfSquares);
    }

    public void groupListOfPeopleByCity(){
        List<Person> people = Arrays.asList(
                new Person("Alice", "New York"),
                new Person("Bob", "Los Angeles"),
                new Person("Charlie", "New York"),
                new Person("Srini", "New York"),
                new Person("Sai", "Los Angeles"),
                new Person("Preetham", "New York"),
                new Person("Hemadri", "New York")
        );

        Map<String, List<Person>> map = people.stream().collect(Collectors.groupingBy(person -> person.city));

        map.forEach((city, listOfStrings) -> {
            System.out.print("For City " + city + ": ");
            listOfStrings.forEach(person -> {
                System.out.print(person.getName() + ", ");
            });
            System.out.println();
        });

    }

    public void parallelStreamDemo(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        print(numbers.parallelStream().map(num -> num*num).collect(Collectors.toList()));
    }
}

public class Practise {

    @Target("main")
    public static void main(String[] args){
        StreamDemo streamDemo = new StreamDemo();
        streamDemo.parallelStreamDemo();
    }
}

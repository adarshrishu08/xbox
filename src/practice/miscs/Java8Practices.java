package practice.miscs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Java8Practices {

    public static void main(String[] args) {

        //Adding Integer List
        List<Integer> list = Arrays.asList(4,5,6,2,7,3,9);

        list = list.stream().filter(integer -> integer>5).collect(Collectors.toList());
        System.out.println("Filtered Valuie : "+ list);


//        int result = list.stream().mapToInt(Integer::intValue).sum();
//        System.out.println(result);


        //Converting List to Map
        List<Person> persons = Arrays.asList(new Person(31,"Adarsh", "Patna"),
                new Person(30,"Ayendreyee", "Kolkata"),new Person(28,"Yashu", "Patna"),
                new Person(64,"L.K.Ojha", "Patna"),new Person(59,"Bibha Ojha", "Patna"),
                new Person(25,"Arghya", "Kolkata"));

        Map<Integer, String> nameToAgeMap = persons.stream().collect(Collectors.toMap(Person::getAge, Person::getName));
        System.out.println(nameToAgeMap);
        Map<String, List<Person>> cityToPersonList = persons.stream().collect(Collectors.groupingBy(Person :: getCity));
        System.out.println("cityToPersonList -> " + cityToPersonList);
    }
}

class Person {
    private int age;
    private String name;
    private String city;


    public Person(int age, String name, String city) {
        this.age = age;
        this.name = name;
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name)
                && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, city);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
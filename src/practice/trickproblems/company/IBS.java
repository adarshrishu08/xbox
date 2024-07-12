import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class IBS {

    public static void main(String[] args) {
        Person person1 = new Person("ABC", "def", 111);
        Person person2 = new Person("ABC", "def", 222);
        Person person3 = new Person("ABC", "def", 333);
        Person person4 = new Person("ABC", "def", 111);
        Person person5 = new Person("XYZ", "ted", 444);
        Person person6 = new Person("XYZ", "ted", 555);
        Person person7 = new Person("XYZ", "ted", 666);

        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);
        persons.add(person7);

        Map<Person, Integer> map = new HashMap<>();
        for(Person person : persons){
            if(map.containsKey(person)){
                map.put(person, map.get(person)+1);
            } else {
                map.put(person, 1);
            }
        }
        System.out.println(map);
        Map<String, Integer> map2 = new HashMap<>();
        for(Person person : map.keySet()) {
            String name = person.getFirstName().concat(person.getLastName());
            if(map2.containsKey(name)){
                map2.put(name, map2.get(name)+1);
            } else {
                map2.put(name, 1);
            }
        }

        System.out.println(map2);

    }
}


class Person {
    private String firstName;
    private String lastName;
    private Number phoneNumber;

    public Person(String firstName, String lastName, Number phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Number getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(phoneNumber, person.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber);
    }

    @Override
    public String toString() {
        return "person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
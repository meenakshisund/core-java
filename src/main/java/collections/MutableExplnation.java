package collections;

import java.util.*;

public class MutableExplnation {

    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        Person p1 = new Person("Hari", 1, list);
        Person p2 = new Person("Prasad", 2, list);

        map.put(p1, "One");
        map.put(p2, "Two");
        map.put(new Person("Hari", 1, list), "three");

        System.out.println(map.size());
        System.out.println(map);

        /*p1.setName("ramu");
        System.out.println(map.get(p1));*/
    }
}

class Person {

    final String name;
    final Integer age;
    List<Integer> list;

    Person(String name, Integer age, List<Integer> list) {
        this.name = name;
        this.age = age;
        this.list = list;
    }

    public List<Integer> getList() {
        return Collections.unmodifiableList(list);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!Objects.equals(name, person.name)) return false;
        return Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + " " + age.toString();
    }
}

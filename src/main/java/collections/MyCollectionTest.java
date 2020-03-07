package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MyCollectionTest {
    public static void main(String[] args) {
        Map<Car, Integer> map = new HashMap<>();

        map.put(new Car(1,"One"), 1);
        map.put(new Car(2,"Two"), 2);
        map.put(new Car(1,"One"), 3);

        System.out.println("Size: " + map.size());
        System.out.println(map.get(new Car(1, "One")));
    }
}

class Car {
    private int id;
    private String name;

    Car(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
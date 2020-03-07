package generics;

import java.util.ArrayList;
import java.util.List;

public class TryMain {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        List<Integer> integers1 = integers;
        integers1.add(44);

        integers.add(12);
        integers.add(13);

        integers.forEach(System.out::println);
        System.out.println(integers.hashCode());

        integers1.forEach(System.out::println);
        System.out.println(integers1.hashCode());
    }
}

package generics;

import java.util.ArrayList;
import java.util.List;

public class SuperDemo {
    private static void addElements(List<? super Integer> list, int n, Class clazz){
        list.add(n);
        System.out.println("Added " + n + " to the list of type " + clazz);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        addElements(list, 0, Integer.class);

        List<Number> list1 = new ArrayList<>();
        list1.add(new Integer(5));
        addElements(list1, 1, Number.class);

        List<Object> list2 = new ArrayList<>();
        addElements(list2, 2, Object.class);

    }
}

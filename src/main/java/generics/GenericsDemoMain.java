package generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GenericsDemoMain {
    public static void main(String[] args) {
        CustomHashMap<Integer, String> integerStringCustomHashMap = new CustomHashMap<>();

        integerStringCustomHashMap.insert(100, "Hundred");
        integerStringCustomHashMap.insert(10, "Ten");
        integerStringCustomHashMap.retrieve(100);

        integerStringCustomHashMap.print();

        CustomHashMap<Double, String> doubleStringCustomHashMap = new CustomHashMap<>();

        doubleStringCustomHashMap.insert(98.4, "NINETY EIGHT.FOUR");
        doubleStringCustomHashMap.retrieve(98.4);

        CustomHashMap<Integer, Double> integerDoubleCustomHashMap = new CustomHashMap<>();
        integerDoubleCustomHashMap.insert(100, 100.0);
        integerDoubleCustomHashMap.insert(10, 10.0);

        integerDoubleCustomHashMap.print();

        GenericTest.display("Hello");
        GenericTest.display(10);

        DtoObject<String> stringDtoObject = new DtoObject<>("sample string");
        stringDtoObject.setData("sample string(edited) by setter method");
        System.out.println(stringDtoObject.getData());

        DtoObject<Integer> integerDtoObject = new DtoObject<>(10);
        integerDtoObject.setData(100);
        System.out.println(integerDtoObject.getData());

        List<Integer> integers = Arrays.asList(2, 4, 6);
        disp(integers);

        List<Double> doubles = Arrays.asList(3.14, 1.68, 2.94);
        disp(doubles);

        List<Number> numbers = Arrays.asList(2, 4, 6, 3.14, 1.68, 2.94);
        disp(numbers);

    }

    private static void disp(Collection<? extends Number> numbers) {
        for (Number num : numbers) System.out.println(num);
    }
}
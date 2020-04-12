package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Stream;

class Fruit {
    void print(){ System.out.println("Hello I am fruit"); }
}

class Apple extends Fruit {
    void display() { System.out.println("Hello I am Apple"); }
}

class ShimlaApple extends Apple {
    void show() { System.out.println("Hello I am Shimla Apple"); }
}

public class GenericsExamples
{
    public static void main(String[] args)
    {
        wildCardExtendsExample();
        wildCardSuperExample();

        describeAllTypes();

        /*Stream.of(1, 2).map(new Function<Integer, Object>() {
            @Override
            public Object apply(Integer integer) {
                return integer * integer;
            }
        }).forEach(System.out::println);

        System.out.println(sumList(Arrays.asList(2,3,4)));

        Person rahul = new Person("rahul", 45);
        Person ramesh = new Person("ramesh", 31);

        List<Person> personList = new ArrayList<>();
        personList.add(rahul);
        personList.add(ramesh);

        personList.stream().map(Person::getAge).forEach(System.out::println);

        personList
                .stream()
                //<R> Stream<R> map(Function<? super T, ? extends R> var1);
                .map(new Function<Person, Object>() {
                         @Override
                         public Object apply(Person person) {
                             return person.getAge();
                         }
                     }
                ).forEach(System.out::println);

        personList
                .stream()
                .map((Person person) -> { return person.getAge(); }
                ).forEach(System.out::println);*/
    }

    private static void describeAllTypes() {

        List<? extends Apple> applesExtends = new ArrayList<>();
        List<? super Apple> applesSuper = new ArrayList<>();
        List<Apple> apples = new ArrayList<>();

        List<Apple> appleList = Arrays.asList(new Apple(), new Apple());
        List<Fruit> fruitList = Arrays.asList(new Fruit(), new Fruit());
        List<ShimlaApple> shimlaAppleList = Arrays.asList(new ShimlaApple(), new ShimlaApple());
// -----------------------------  extends -------------------------------------------//
// Addition of items is never allowed
        applesExtends.add(new Fruit());
        applesExtends.add(new Apple());
        applesExtends.add(new ShimlaApple());
// able to assign only of that T and below. No super. B, C allowed. Not A)
        applesExtends = appleList;
        applesExtends = fruitList;
        applesExtends = shimlaAppleList;
// Iteration : known type : T
        for(Apple apple: applesExtends)
            System.out.println(apple + " hello : " + apple.getClass());
// -----------------------------  super -------------------------------------------//
// Addition of items allowed with a condition - Item addition allowed for T and below. No super
        applesSuper.add(new Fruit());
        applesSuper.add(new Apple());
        applesSuper.add(new ShimlaApple());
// able to assign only of that T and above. No subclasses assignment accepted
        applesSuper = appleList;
        applesSuper = fruitList;
        applesSuper = shimlaAppleList;
// Iteration: Unknown Type : Object
        for(Object apple: applesSuper)
            System.out.println(apple + " hello : " + apple.getClass());
// -----------------------------  normal -------------------------------------------//
// Addition of items allowed with a condition - Item addition allowed for T and below. No super; able to assign only of that type(no super class assignment)
        apples.add(new Fruit());
        apples.add(new Apple());
        apples.add(new ShimlaApple());
// able to assign only of that T. No subclass/superclass assignment accepted
        apples = appleList;
        apples = fruitList;
        apples = shimlaAppleList;
// Iteration : known type : T
        for(Apple apple: apples)
            System.out.println(apple + " hello : " + apple.getClass());
// -----------------------------  Collections.addAll(? extends T) -------------------------------------------//
// Addition of items allowed with a condition - Item addition allowed for T and below. No super; able to assign only of that type(no super class assignment)
        apples.addAll(fruitList);
        apples.addAll(appleList);
        apples.addAll(shimlaAppleList);

// -----------------------------  Collections.copy(List<? super T> dest, List<? extends T> src) -------------------------------------------//
// Collections.java copy(dest, src) describes copying src to dest;
// dest should be able to accept(add); src should be able to produce(read); ** di.set(si.next()) **

        /*public static <T > void copy (List < ? super T > dest, List < ? extends T > src){
            int srcSize = src.size();
            if (srcSize > dest.size()) {
                throw new IndexOutOfBoundsException("Source does not fit in dest");
            } else {
                if (srcSize < 10 || src instanceof RandomAccess && dest instanceof RandomAccess) {
                    for (int i = 0; i < srcSize; ++i) {
                        dest.set(i, src.get(i));
                    }
                } else {
                    ListIterator<? super T> di = dest.listIterator();
                    ListIterator<? extends T> si = src.listIterator();

                    for (int i = 0; i < srcSize; ++i) {
                        di.next();
                        di.set(si.next());
                    }
                }

            }
        }*/
    }

    private static void wildCardExtendsExample() {
        //List of apples
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Apple());
        fruits.add(new ShimlaApple());

        //We can assign a list of apples(sub type collection) to a basket of fruits(super type collection);
        //because apple is subtype of fruit
        acceptFruits(fruits);
    }

    private static void acceptFruits(List<? extends Fruit> fruitBasket){
        //Here we know that in basket there is nothing but fruit only
        for (Fruit item : fruitBasket)
            System.out.println(item + " : EXTENDS : " + item.getClass());

        (fruitBasket.get(0)).print();
        ((Apple) fruitBasket.get(0)).display();

        (fruitBasket.get(1)).print(); // No need to type cast , as we have got T (Fruit) type
        ((ShimlaApple) fruitBasket.get(1)).display();
        ((ShimlaApple) fruitBasket.get(1)).show();

        //basket.add(new Apple()); //Compile time error
        //basket.add(new Fruit()); //Compile time error
    }

    private static void wildCardSuperExample() {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());

        //We can assign a list of apples to a basket of apples
        List<? super Apple> appleBasket = apples;

        appleBasket.add(new Apple());      //Successful
        appleBasket.add(new ShimlaApple()); //Successful
        //basket.add(new Fruit());      //Compile time error

        for(Object apple : appleBasket) {
            System.out.println(apple + " : SUPER : " + apple.getClass());
        }

        // Need to type cast ALWAYS, because always Object is returned

        ((Apple) appleBasket.get(0)).print();
        ((Apple) appleBasket.get(0)).display();

        ((Apple) appleBasket.get(1)).print();
        ((Apple) appleBasket.get(1)).display();

        ((ShimlaApple) appleBasket.get(2)).print();
        ((ShimlaApple) appleBasket.get(2)).display();
        ((ShimlaApple) appleBasket.get(2)).show();
    }

    /*


    PECS:

    ------------------------------------
    | Producer extends | Consumer super |
    ------------------------------------

Use extends when you consume
Use super when you produce

Use wildcard when you do both


Producer extends: Upper bounded : "maximum class"

    1. List<Fruit> cannot accept List<Apples> as an argument. So, use <? extends Fruit> to accept List<Apple> as argument.
    2. Cannot add values further
    3. fruitBasket.add(new Apple()); - will not work
    4. All elements are either Fruit type or subType of fruit
    5. You can use all Fruit class methods. Iteration can be done with Fruit type.

Consumer super: Lower bounded :

    1.




     */
    private static double sumList(List<? extends Number> list) {
        return list.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
    }
}
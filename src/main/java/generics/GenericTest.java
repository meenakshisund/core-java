package generics;

class GenericTest {
    static <T> void display(T t){
        System.out.println(t.getClass().getName() + " " + t);
    }
}
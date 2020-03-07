package inheritance.com1;

public class A {
    private int i = 10;
    int j = 11;
    protected int k = 12;
    public int m = 13;
}

class C extends A {

    public static void main(String[] args) {

        C c = new C();
        // System.out.println(c.i);
        System.out.println(c.j);
        System.out.println(c.k);
        System.out.println(c.m);

        A a = new A();
        // System.out.println(a.i);
        System.out.println(a.j);
        System.out.println(a.k);
        System.out.println(a.m);
    }
}
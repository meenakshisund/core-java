package inheritance.com2;

import inheritance.com1.A;

public class D extends A {

    public static void main(String[] args) {
        D d = new D(); //object creation for a class outside package by extending Parent. protected and public members are accessible outside pkg
        // System.out.println(d.i);
        // System.out.println(d.j);
        System.out.println(d.k);
        System.out.println(d.m);

        A a = new A(); // object creation for a class outside package. only public members are accessible
        // System.out.println(a.i);
        // System.out.println(a.j);
        // System.out.println(a.k);
        System.out.println(a.m);
    }
}
package generics;

// https://www.geeksforgeeks.org/bounded-types-generics-java/

class Bound<T extends A & B>
{

    private T objRef;

    Bound(T obj){
        this.objRef = obj;
    }

    void doRunTest(){
        this.objRef.displayClass();
    }
}

interface B
{
    public void displayClass();
}

class A implements B
{
    public void displayClass()
    {
        System.out.println("Inside super class A");
    }
}

class C extends A {
    @Override
    public void displayClass() {
        System.out.println("Inside a child class of implemented class");
    }
}

public class BoundedClass
{
    public static void main(String[] args)
    {
        //Creating object of sub class A and
        //passing it to Bound as a type parameter.
        Bound<C> bec = new Bound<C>(new C());
        bec.doRunTest();

        Bound<A> bea = new Bound<A>(new A());
        bea.doRunTest();

    }
}
package abstraction;

abstract class AbstractClass {
    protected int i;
    protected AbstractClass() {
        i = 100;
    }
    void print(){
        System.out.println("AbstractClass " + i);
    }
}
class ConcreteClass extends AbstractClass {
    @Override
    protected void print(){
        System.out.println("In Concrete Class.. Calling abstract class method ");
        super.print();
        i = 200;
        System.out.println("i : " + i);
    }
}
class MainClass {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.print();
    }
}
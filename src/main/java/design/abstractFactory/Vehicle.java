package design.abstractFactory;

abstract class Vehicle {

    abstract int getWheels();
    abstract String getCompany();
    abstract String getModel();

    @Override
    public String toString() {
        return "Vehicle{" + "wheels=" + this.getWheels() + ", company='" + this.getCompany() + '\'' + ", model='" + this.getModel() + '\'' + '}';
    }
}
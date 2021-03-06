package design.factory;

class Car extends Vehicle {

    private int wheels;
    private String company;
    private String model;

    Car(int wheels, String company, String model) {
        this.wheels = wheels;
        this.company = company;
        this.model = model;
    }

    @Override
    int getWheels() {
        return this.wheels;
    }

    @Override
    String getCompany() {
        return this.company;
    }

    @Override
    String getModel() {
        return this.model;
    }
}

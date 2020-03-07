package design.abstractFactory;

class CarFactory implements VehicleAbstractFactory {

    private int wheels;
    private String company;
    private String model;

    CarFactory(int wheels, String company, String model) {
        this.wheels = wheels;
        this.company = company;
        this.model = model;
    }

    @Override
    public Vehicle createVehicle() {
        return new Car(wheels, company, model);
    }
}
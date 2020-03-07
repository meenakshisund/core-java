package design.abstractFactory;

class BusFactory implements VehicleAbstractFactory {

    private int wheels;
    private String company;
    private String model;

    BusFactory(int wheels, String company, String model) {
        this.wheels = wheels;
        this.company = company;
        this.model = model;
    }

    @Override
    public Vehicle createVehicle() {
        return new Bus(wheels, company, model);
    }
}
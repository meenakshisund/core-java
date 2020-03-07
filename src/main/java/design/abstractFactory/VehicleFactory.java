package design.abstractFactory;

class VehicleFactory {
    static Vehicle createVehicle(VehicleAbstractFactory factory) {
        return factory.createVehicle();
    }
}
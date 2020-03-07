package design.factory;

class VehicleFactory {
    static Vehicle createVehicle(String type, int wheels, String company, String model) {
        Vehicle vehicle = null;
        switch (type) {
            case "PassengerVehicle":
                vehicle = new Car(wheels, company, model);
                break;
            case "CommercialVehicle":
                vehicle = new Bus(wheels, company, model);
                break;
        }
        return vehicle;
    }
}

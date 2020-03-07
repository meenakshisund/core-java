package design.factory;

public class VehicleClient {
    public static void main(String[] args) {

        Vehicle car = VehicleFactory.createVehicle("PassengerVehicle", 4, "maruti", "swift");
        Vehicle bus = VehicleFactory.createVehicle("CommercialVehicle", 6, "tata", "MarcoPolo");

        System.out.println(car);
        System.out.println(bus);
    }
}

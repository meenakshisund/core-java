package design.abstractFactory;

public class VehicleClient {
    public static void main(String[] args) {

        Vehicle car = VehicleFactory.createVehicle(new CarFactory(4, "maruti", "alto"));
        Vehicle bus = VehicleFactory.createVehicle(new BusFactory(4, "leyland", "bus"));

        System.out.println(car);
        System.out.println(bus);
    }
}

package design.builder;

public class AddressBuilderClient {
    public static void main(String[] args) {
        Address address = new Address.AddressBuilder("2", "Street", 600119).setLandMark("Behind police station").build();
        System.out.println(address);
    }
}
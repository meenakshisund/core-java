package design.builder;

class Address {

    private String doorNumber;
    private String street;
    private int pinCode;

    private String landMark;

    private Address(AddressBuilder builder){
        this.doorNumber = builder.doorNumber;
        this.street = builder.street;
        this.pinCode = builder.pinCode;
        this.landMark = builder.landMark;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public String getStreet() {
        return street;
    }

    public int getPinCode() {
        return pinCode;
    }

    public String getLandMark() {
        return landMark;
    }

    @Override
    public String toString() {
        return "Address{" +
                "doorNumber='" + doorNumber + '\'' +
                ", street='" + street + '\'' +
                ", pinCode=" + pinCode +
                ", landMark='" + landMark + '\'' +
                '}';
    }

    public static class AddressBuilder {

        private String doorNumber;
        private String street;
        private int pinCode;

        private String landMark;

        public AddressBuilder(String doorNumber, String street, int pinCode){
            this.doorNumber = doorNumber;
            this.street = street;
            this.pinCode = pinCode;
        }

        public AddressBuilder setLandMark(String landMark) {
            this.landMark = landMark;
            return this;
        }
        public Address build(){
            return new Address(this);
        }
    }
}

package collections;

import java.util.*;

public class ComparatorExample {
    public static void main(String[] args) {

        Vehicle v1 = new Vehicle("Abc", "XUV", 2217);
        Vehicle v2 = new Vehicle("rst", "XUV", 221);
        Vehicle v3 = new Vehicle("mahi", "XUV", 22);
        Vehicle v4 = new Vehicle("Rst", "XUV", 2);

        List<Vehicle> list = new ArrayList<>();
        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);

        Collections.sort(list, Comparator.comparing(Vehicle::getBrand));

        System.out.println(list);
    }
}

class Vehicle {
    String brand;
    String name;
    Integer regNo;

    public String getBrand() {
        return brand.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public Integer getRegNo() {
        return regNo;
    }

    public Vehicle(String brand, String name, Integer regNo) {
        this.brand = brand;
        this.name = name;
        this.regNo = regNo;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "brand='" + brand + '\'' + ", name='" + name + '\'' + ", regNo=" + regNo + '}';
    }
}
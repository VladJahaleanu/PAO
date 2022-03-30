package main;

public class Restaurant {
    private String name;
    private String address;
    private int noOfDeliveries;

    public Restaurant ( String name,String address) {
        this.name = name;
        this.address = address;
        this.noOfDeliveries = 0;
    }

    public String getAddress () {
        return address;
    }

    public String getName() {
        return name;
    }

    public int getNoOfDeliveries() {
        return noOfDeliveries;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public void addDelivery() {
        this.noOfDeliveries += 1;
    }

    public void printRestaurant() {
        System.out.println("Restaurantul: " + getName());
        System.out.println("Are " + getNoOfDeliveries() + " comenzi efectuate.");
        System.out.println();
        System.out.println();
    }
}

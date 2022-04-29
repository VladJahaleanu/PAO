package entities;

public class Restaurant {
    private String name;
    private String address;
    private int noOfDeliveries;
    //composition
    private final String providerName;

    public Restaurant ( String name,String address, String providerName) {
        this.name = name;
        this.address = address;
        this.noOfDeliveries = 0;
        this.providerName = providerName;
    }

    public String getAddress () {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getProviderName() {
        return providerName;
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
        System.out.println("Cu furnizorul: " + getProviderName());
        System.out.println("Are " + getNoOfDeliveries() + " comenzi efectuate.\n\n");
    }
}

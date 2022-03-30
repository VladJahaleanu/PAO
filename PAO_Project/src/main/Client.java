package main;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class Client extends User{
    private String address;
    //aggregation
    private List<Order> orders;

    public Client(String name, String address){
        super(name);
        this.address = address;
        this.orders = new ArrayList<Order>();
    }

    public int getTotalAmountPaid() {
        int total = 0;
        for(Order o: orders) {
            total += o.getPrice();
        }
        return total;
    }

    public String getAddress() {
        return address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder (Order order) {
        this.orders.add(order);
    }

    public void printClient() {
        System.out.println("Clientul: " + getName());
        System.out.println("Cu adresa: " +getAddress());
        System.out.println("Are " + getOrders().size() + " comenzi");
        System.out.println("Cu valoarea totala de: " + getTotalAmountPaid() + "\n\n");
    }
}

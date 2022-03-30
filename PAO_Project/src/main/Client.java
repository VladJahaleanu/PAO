package main;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class Client extends User{
    private String address;
    private List<Order> orders;
    //private int totalAmountPaid;

    public Client(String name, String address){
        super(name);
        //this.totalAmountPaid = totalAmountPaid;
        this.address = address;
        this.orders = new ArrayList<Order>();
    }

    public int getTotalAmountPaid() {
        //return totalAmountPaid;
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

//    public void addAmountPaid(int price) {
//        this.totalAmountPaid += price;
//    }

    public void addOrder (Order order) {
        this.orders.add(order);
    }

    public void printClient() {
        System.out.println("Clientul: " + getName());
        System.out.println("Cu adresa: " +getAddress());
        System.out.println("Are " + getOrders().size() + " comenzi");
        System.out.println("Cu valoarea totala de: " + getTotalAmountPaid());
        System.out.println();
        System.out.println();
    }
}

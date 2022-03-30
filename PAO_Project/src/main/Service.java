package main;

import java.util.*;

public class Service {
    //to be changed to set
    private static List<Order> orders;
    private static List<Courier> couriers;
    private static List<Restaurant> restaurants;
    private static LinkedList<Client> clients;
    private static List<Car> cars;
    private static Service instance = null;

    private Service() {
        System.out.println("Service started!");
        orders = new ArrayList<>();
        couriers = new ArrayList<>();
        clients = new LinkedList<>();
        cars = new ArrayList<>();
        restaurants = new ArrayList<>();
    }

    public static Service Service() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    public void addOrder( Order o) {
        orders.add(o);
    }

    public void addClient (Client c) {
        clients.add(c);
    }

    public void addCar( Car c) {
        cars.add(c);
    }

    public void addRestaurant( Restaurant r) {
        restaurants.add(r);
    }

    public void removeOrder (Order o) {
        orders.remove(o);
    }

    public void removeClient (Client c) {
        clients.remove(c);
    }

    public void removeCar (Car c) {
        cars.remove(c);
    }

    public void removeRestaurant (Restaurant r) {
        restaurants.remove(r);
    }

    public void printClients() {
        for( Client c: this.clients) {
            c.printClient();
        }
    }

    public void printOrders() {
        for( Order o: this.orders) {
            o.printOrder();
        }
    }

    public void printRestaurants() {
        for( Restaurant r: this.restaurants) {
            r.printRestaurant();
        }
    }

    public void sortOrdersByPriceDescending() {
        orders.sort(Comparator.comparing(Order::getPrice).reversed());
    }

    public void sortRestaurantsByNoOfOrders() {
        restaurants.sort(Comparator.comparing(Restaurant::getNoOfDeliveries));
    }

    public List<Order> getOrders() {
        return orders;
    }


}

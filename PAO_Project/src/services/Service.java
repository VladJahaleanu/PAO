package services;

import entities.*;
import audit.Audit;
import CSVs.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Service {
    //to be changed to set
    private static List<Order> orders;
    private static List<Courier> couriers;
    private static List<Restaurant> restaurants;
    private static LinkedList<Client> clients;
    private static List<Car> cars;
    private static List<Provider> providers;

    private static Service instance = null;

    private Service() {
        System.out.println("Service started!\n");
        orders = new ArrayList<>();
        couriers = new ArrayList<>();
        clients = new LinkedList<>();
        cars = new ArrayList<>();
        restaurants = new ArrayList<>();
        providers = new ArrayList<>();
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

    public void readCouriers(){
        try {
            couriers = CSVReader.readCourierCSV("CouriersI.csv");
            Audit.writeAuditCSV("Read Couriers from CSV input file");
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void readCars(){
        try {
            cars = CSVReader.readCarsCSV("CarsI.csv");
            Audit.writeAuditCSV("Read Cars from CSV input file");
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void readProviders(){
        try {
            providers = CSVReader.readProvidersCSV("ProvidersI.csv");
            Audit.writeAuditCSV("Read Providers from CSV input file");
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void readOrders(){
        try {
            providers = CSVReader.readOrdersCSV("OrdersI.csv");
            Audit.writeAuditCSV("Read Orders from CSV input file");
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static boolean verifyCarCSV(String fileName, Car car) throws DocumentException {
        Path pathToFile = Paths.get(fileName);

        try {
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8);

            String line = br.readLine();
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] fields = line.split(",");
                String license = fields[0];
                String fuel = fields[1];
                String driver = fields[2];


                if (car.getLicenseNumber().equals(license) && car.getFuelType().equals(fuel) && car.getSofer().equals(driver)) {
                    return false;
                }
            }
            br.close();
            return true;
        } catch (FileNotFoundException e) {
            throw new DocumentException("File " + fileName + " not found!");
        } catch (IOException e) {
            throw new DocumentException("Error while reading from the file!", e);
        }
    }

    public void addCarToCSV(Car car) throws DocumentException {
        cars.add(car);
        if (verifyCarCSV("CarsO.csv", car)) {
            try {
                CSVWriter.writeCarCSV("CarsO.csv", car);
                Audit.writeAuditCSV("Write Car to CSV");
            } catch (DocumentException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }

    public void addOrderToCSV(Order order) throws DocumentException {
        orders.add(order);
        try {
            CSVWriter.writeOrderCSV("OrdersO.csv", order);
            Audit.writeAuditCSV("Write Order to CSV");
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void addProviderToCSV(Provider provider) throws DocumentException {
        providers.add(provider);
        try {
            CSVWriter.writeProviderCSV("ProvidersO.csv", provider);
            Audit.writeAuditCSV("Write Provider to CSV");
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void addCourierToCSV(Courier courier) throws DocumentException {
        couriers.add(courier);
        try {
            CSVWriter.writeCourierCSV("CouriersO.csv", courier);
            Audit.writeAuditCSV("Write Courier to CSV");
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }



}

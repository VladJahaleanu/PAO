package main;

import entities.*;
import services.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws DocumentException, IOException {
        Service service = Service.Service();

        Provider p = new Provider("Napolact", "Cluj-Napoca");
//        Provider p1 = new Provider("Marisan", "Bucuresti");
//
//        //create restaurants
//        Restaurant r = new Restaurant("Cocosul Rosu", "Str Margelelor nr 4", p.getName());
//        Restaurant r1 = new Restaurant("Cocosul Alb", "Str Aurel Vlaicu nr 5", p1.getName());
//
//        //create orders
//        Order o = new Order(0, 250, r.getAddress(), "Str Nandru", "20:30", "Mitica", 120);
//        Order o1 = new Order(1, 210, r.getAddress(), "Str Margeanului", "21:30", "Fane", 45);
//        Order o2 = new Order(2, 330, r1.getAddress(), "Str Margeanului", "09:45", "Fane", 22);
//
//        //add orders to service list
//        service.addOrder(o);
//        service.addOrder(o1);
//        service.addOrder(o2);
//        for(Order o3: service.getOrders()) {
//            if (r.getAddress() == o3.getPickUpLocation()) {
//                r.addDelivery();
//            }
//        }
//
//        for(Order o3: service.getOrders()) {
//            if (r1.getAddress() == o3.getPickUpLocation()) {
//                r1.addDelivery();
//            }
//        }
//
//        //add restaurants to service list and sort them by the number of orders
//        service.addRestaurant(r);
//        service.addRestaurant(r1);
//        service.sortRestaurantsByNoOfOrders();
//        service.printRestaurants();
//
//        //create clients and add them to service
//        Client c = new Client("vlad", "strada 2");
//        c.addOrder(o);
//        c.addOrder(o1);
//        service.addClient(c);
//        Client c1 = new Client("Vlad2", "strada 2");
//        c1.addOrder(o);
//        c1.addOrder(o1);
//        service.addClient(c1);
//        service.removeClient(c);
//        service.printClients();
//
//        //sort orders by the price, descending
//        service.sortOrdersByPriceDescending();
//        service.printOrders();
//
//        //Second phase, read and write stuff to csv files
//        service.readCars();
//
//        Car car = new Car("B 44 MIC", "Diesel", "Aurel");
//
//        service.addCarToCSV(car);
//
//        service.readCouriers();
//        Courier courier = new Courier("Victor", 2200, 2, 250 );
//        service.addCourierToCSV(courier);
//
//        service.readOrders();
//        service.addOrderToCSV(o1);
//        service.addOrderToCSV(o2);
//
//        service.readProviders();
//        service.addProviderToCSV(p);

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseHelper();
//        String query = "insert into cars values(null, 'BC001AAA', 'Alex')";
//        try {
//            databaseHelper.executeSql(databaseConnection, query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        Car c = new Car("SV99ALX", "LPG", "Alex");
        DatabaseService databaseService = new DatabaseService();
        //databaseService.addCar(c);
        databaseService.addProvider(p);


        //service.readCarsFromDB();
        //service.readCouriersFromDB();
        //databaseService.deleteCourierById(2);
        //service.printCouriers();
        databaseService.updateCourierSalary(1, 3333);


        System.out.println("Finished!");


    }
}

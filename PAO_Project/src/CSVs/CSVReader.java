package CSVs;

import entities.*;
import services.DocumentException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    public static List readCouriersCSV(String fileName) throws DocumentException {
        List<Courier> couriers = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try {
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8);

            String line = br.readLine();
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] fields = line.split(",");
                String name = fields[0];
                int salary = Integer.parseInt(fields[1]);
                int noOfOrders = Integer.parseInt(fields[2]);
                int totalDistanceTraveled = Integer.parseInt(fields[3]);


                Courier curier = new Courier(name, salary, noOfOrders, totalDistanceTraveled);
                couriers.add(curier);
            }
            br.close();
            return couriers;
        } catch (FileNotFoundException e) {
            throw new DocumentException("File " + fileName + " not found!");
        } catch (IOException e) {
            throw new DocumentException("Error while reading from file!", e);
        }
    }

    public static List readCarsCSV(String fileName) throws DocumentException {
        List<Car> cars = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try {
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8);

            String line = br.readLine();

            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] fields = line.split(",");
                String license = fields[0];
                String fuel = fields[1];
                String driver = fields[2];


                Car car = new Car(license, fuel, driver);
                cars.add(car);
            }
            br.close();
            return cars;
        } catch (FileNotFoundException e) {
            throw new DocumentException("File " + fileName + " not found!");
        } catch (IOException e) {
            throw new DocumentException("Error while reading from file!", e);
        }
    }

    public static List readProvidersCSV(String fileName) throws DocumentException {
        List<Provider> providers = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try {
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8);

            String line = br.readLine();

            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] fields = line.split(",");
                String name = fields[0];
                String address = fields[1];

                Provider provider = new Provider(name, address);
                providers.add(provider);
            }
            br.close();
            return providers;
        } catch (FileNotFoundException e) {
            throw new DocumentException("File " + fileName + " not found!");
        } catch (IOException e) {
            throw new DocumentException("Error while reading from file!", e);
        }
    }

    public static List readOrdersCSV(String fileName) throws DocumentException {
        List<Order> orders = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try {
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8);

            String line = br.readLine();

            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] fields = line.split(",");
                int orderNo = Integer.parseInt(fields[0]);
                int price = Integer.parseInt(fields[1]);
                String pickUp = fields[2];
                String dropOff = fields[3];
                String delTime = fields[4];
                String courierName = fields[5];
                int delDuration = Integer.parseInt(fields[6]);

                Order order = new Order(orderNo, price, pickUp, dropOff, delTime, courierName, delDuration);
                orders.add(order);
            }
            br.close();
            return orders;
        } catch (FileNotFoundException e) {
            throw new DocumentException("File " + fileName + " not found!");
        } catch (IOException e) {
            throw new DocumentException("Error while reading from file!", e);
        }
    }

}

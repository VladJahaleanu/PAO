package CSVs;

import entities.*;
import services.DocumentException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CSVWriter {
    public static void writeCourierCSV(String fileName, Courier courier) throws DocumentException {
        Path pathToFile = Paths.get(fileName);

        try {
            BufferedWriter bw = Files.newBufferedWriter(pathToFile, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            String stringToWrite = String.format("\n%s,%d,%d,%d",
                    courier.getName(),
                    courier.getSalary(),
                    courier.getNoOfOrders(),
                    courier.getTotalDistanceTraveled());

            bw.write(stringToWrite);
            bw.close();
        } catch (IOException e) {
            throw new DocumentException("Error while writing the file!", e);
        }
    }

    public static void writeCarCSV(String fileName, Car car) throws DocumentException {
        Path pathToFile = Paths.get(fileName);

        try {
            BufferedWriter bw = Files.newBufferedWriter(pathToFile, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            String stringToWrite = String.format("\n%s,%s,%s",
                    car.getLicenseNumber(),
                    car.getFuelType(),
                    car.getSofer());

            bw.write(stringToWrite);
            bw.close();
        } catch (IOException e) {
            throw new DocumentException("Error while writing the file!", e);
        }
    }

    public static void writeProviderCSV(String fileName, Provider provider) throws DocumentException {
        Path pathToFile = Paths.get(fileName);

        try {
            BufferedWriter bw = Files.newBufferedWriter(pathToFile, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            String stringToWrite = String.format("\n%s,%s",
                    provider.getName(),
                    provider.getAddress());

            bw.write(stringToWrite);
            bw.close();
        } catch (IOException e) {
            throw new DocumentException("Error while writing the file!", e);
        }
    }

    public static void writeOrderCSV(String fileName, Order order) throws DocumentException {
        Path pathToFile = Paths.get(fileName);

        try {
            BufferedWriter bw = Files.newBufferedWriter(pathToFile, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            String stringToWrite = String.format("\n%d,%d,%s,%s,%s,%s",
                    order.getOrderNo(),
                    order.getPrice(),
                    order.getPickUpLocation(),
                    order.getDropOffLocation(),
                    order.getDeliveryTime(),
                    order.getCourierName());

            bw.write(stringToWrite);
            bw.close();
        } catch (IOException e) {
            throw new DocumentException("Error while writing the file!", e);
        }
    }
}

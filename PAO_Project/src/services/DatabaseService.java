package services;

import entities.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {

    public void addCar(Car car) {
        String insertCarSql = String.format("INSERT INTO cars( license_number, fuel_type, driver) VALUES('%s','%s','%s')",
                car.getLicenseNumber(),car.getFuelType(), car.getSofer());

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseHelper();

        try {
            databaseHelper.executeSql(databaseConnection, insertCarSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProvider(Provider provider) {
        String insertProviderSql = String.format("INSERT INTO provider(name, address) VALUES('%s','%s')",
                provider.getName(),provider.getAddress());

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseHelper();

        try {
            databaseHelper.executeSql(databaseConnection, insertProviderSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCourier(Courier courier) {
        String insertCourierSql = String.format("INSERT INTO couriers(name, salary, no_of_orders, distance_traveled) VALUES('%s','%d','%d', '%d')",
                courier.getName(), courier.getSalary(), courier.getNoOfOrders(), courier.getTotalDistanceTraveled());

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseHelper();

        try {
            databaseHelper.executeSql(databaseConnection, insertCourierSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addOrder(Order order) {
        String insertOrderSql = String.format("INSERT INTO orders(id, price, delivery_duration, pick_up_location, drop_off_location, delivery_time, courier_name) VALUES('%d','%d','%d', '%s','%s','%s','%s')",
                order.getOrderNo(), order.getPrice(), order.getDeliveryDuration(), order.getPickUpLocation(), order.getDropOffLocation(), order.getDeliveryTime(), order.getCourierName());

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseHelper();

        try {
            databaseHelper.executeSql(databaseConnection, insertOrderSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Car mapToCar(ResultSet resultSet) throws SQLException {
        return new Car(resultSet.getString(2),  resultSet.getString(3),  resultSet.getString(4));
    }

    private static Courier mapToCourier(ResultSet resultSet) throws SQLException {
        return new Courier(resultSet.getString(2),  resultSet.getInt(3),  resultSet.getInt(4), resultSet.getInt(5));
    }


    public static List<Car> displayCars() {
        String selectSql = "SELECT * FROM cars";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseHelper();
        List<Car> car = new ArrayList<>(0);
        try {
            ResultSet resultSet = databaseHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getInt(1));
                System.out.println("License Plate:" + resultSet.getString(2));
                System.out.println("Fuel Type:" + resultSet.getString(3));
                System.out.println("Driver's Name:" + resultSet.getString(4));
                System.out.println();
                car.add(mapToCar(resultSet));
            }
            return car;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Courier> displayCouriers() {
        String selectSql = "SELECT * FROM couriers";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseHelper();
        List<Courier> courier = new ArrayList<>(0);
        try {
            ResultSet resultSet = databaseHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getInt(1));
                System.out.println("Courier Name:" + resultSet.getString(2));
                System.out.println("Salary:" + resultSet.getInt(3));
                System.out.println("No. of Orders:" + resultSet.getInt(4));
                System.out.println("Total Distance Traveled:" + resultSet.getInt(5));
                System.out.println();
                courier.add(mapToCourier(resultSet));
            }
            return courier;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteCourierById(int id) {
        String deleteSql = "DELETE FROM couriers WHERE id=" + id;

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseHelper();

        try {
            databaseHelper.executeSql(databaseConnection, deleteSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCarById(int id) {
        String deleteSql = "DELETE FROM cars WHERE id=" + id;

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseHelper();

        try {
            databaseHelper.executeSql(databaseConnection, deleteSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrderById(int id) {
        String deleteSql = "DELETE FROM orders WHERE id=" + id;

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseHelper();

        try {
            databaseHelper.executeSql(databaseConnection, deleteSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProviderById(int id) {
        String deleteSql = "DELETE FROM providers WHERE id=" + id;

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseHelper();

        try {
            databaseHelper.executeSql(databaseConnection, deleteSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCarDriver(int id, String driver) {
        String updateSql = String.format("UPDATE cars SET driver = '%s' WHERE id=%d", driver, id);

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseHelper();

        try {
            databaseHelper.executeSql(databaseConnection, updateSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCourierSalary(int id, int salary) {
        String updateSql = String.format("UPDATE couriers SET salary = '%d' WHERE id=%d", salary, id);

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseHelper();

        try {
            databaseHelper.executeSql(databaseConnection, updateSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

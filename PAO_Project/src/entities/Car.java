package entities;

public class Car {
    private String licenseNumber;
    private String fuelType;
    private String driver;

    public Car(String license , String fuel, String driver){
        this.fuelType = fuel;
        this.licenseNumber = license;
        this.driver = driver;
    }

    public String getSofer() {
        return driver;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setDriver( String name ) {
        this.driver = name;
    }

    public void setLicenseNumber( String license) {
        this.licenseNumber = license;
    }
}

package entities;

public class Order {
    private int orderNo;
    private int price;
    private int deliveryDuration;
    private String pickUpLocation;
    private String dropOffLocation;
    private String deliveryTime;
    private String courierName;

    public Order(int orderNo, int price, String pickUpLocation, String dropOffLocation, String deliveryTime, String courierName, int deliveryDuration) {
        this.orderNo = orderNo;
        this.price = price;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.deliveryTime = deliveryTime;
        this.courierName = courierName;
        this.deliveryDuration = deliveryDuration;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public int getPrice() {
        return price;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public String getCourierName() {
        return courierName;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public int getDeliveryDuration() { return deliveryDuration; }

    public void printOrder(){
        System.out.println("Comanda: " + getOrderNo());
        System.out.println("Cu pretul de: " + getPrice());
        System.out.println("Livrata de: " + getCourierName());
        System.out.println("Ridicata de la adresa: " + getPickUpLocation());
        System.out.println("Va fi predata la adresa: " + getDropOffLocation());
        System.out.println("La ora: " + getDeliveryTime() + "\n\n");
    }


}

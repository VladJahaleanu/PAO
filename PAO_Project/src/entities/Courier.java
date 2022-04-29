package entities;

public class Courier extends User{
    private int salary;
    private int noOfOrders;
    private int totalDistanceTraveled;

    public Courier( String name ){
        super(name);
        this.noOfOrders = 0;
        this.totalDistanceTraveled = 0;
        this.salary = 2000;
    }

    public Courier( String name, int salary, int noOfOrders, int totalDistanceTraveled){
        super(name);
        this.noOfOrders = noOfOrders;
        this.totalDistanceTraveled = totalDistanceTraveled;
        this.salary = salary;
    }

    public int getTotalDistanceTraveled() {
        return totalDistanceTraveled;
    }

    public void calculateSalary(){
        this.salary = 2000 + 10 / 100 * totalDistanceTraveled / noOfOrders * 2;
    }

    public int getNoOfOrders() {
        return noOfOrders;
    }

    public void addOrder() {
        this.noOfOrders += 1;
    }

    public void addTotalDistanceTraveled( int km ) {
        this.totalDistanceTraveled += km;
    }

    public int getSalary() {
        return salary;
    }

    public void printCourier(){
        System.out.println("Curierul: " + getName());
        System.out.println("Are salariul: " + getSalary());
        System.out.println("A facut pana acum: " + getNoOfOrders() + " livrari");
        System.out.println("A parcurs : " + getTotalDistanceTraveled() + " km.\n\n" );
    }
}

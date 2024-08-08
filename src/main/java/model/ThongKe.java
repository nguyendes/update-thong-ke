package model;

public class ThongKe {
    private int totalOrders;
    private double totalRevenue;
    private int month; // Add month field
    private int year;  // Add year field

    // Getters and setters
    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public int getMonth() { // Add getter for month
        return month;
    }

    public void setMonth(int month) { // Add setter for month
        this.month = month;
    }

    public int getYear() { // Add getter for year
        return year;
    }

    public void setYear(int year) { // Add setter for year
        this.year = year;
    }
}

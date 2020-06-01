package Entities;

public class Shirts extends Item {
    private String shirtType;

    public String getShirtType() {
        return shirtType;
    }
    public void setShirtType(String shirtType) {
        this.shirtType = shirtType;
    }

    public Shirts(String color, String brand, String gender, double price, int size, int currentStock, int baseStock, int itemId, String shirtType) {
        super(color, brand, gender, price, size, currentStock, baseStock, itemId);
        this.shirtType = shirtType;
    }
}

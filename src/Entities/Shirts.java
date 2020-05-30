package Entities;

public class Shirts extends Item {
    private String shirtType;

    public String getShirtType() {
        return shirtType;
    }
    public void setShirtType(String shirtType) {
        this.shirtType = shirtType;
    }

    public Shirts(String itemId, String color, String type, String brand, String gender, double price, int size, int howManySold, int howManyInStock, String shirtType) {
        super(itemId, color, type, brand, gender, price, size, howManySold, howManyInStock);
        this.shirtType = shirtType;
    }
}

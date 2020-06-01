package Entities;

public abstract class Item {
    private String color, brand, gender;
    private double price;
    private int size, currentStock, baseStock, itemId;

    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getCurrentStock() {
        return currentStock;
    }
    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }
    public int getBaseStock() {
        return baseStock;
    }
    public void setBaseStock(int baseStock) {
        this.baseStock = baseStock;
    }
    public int getHowManyInStock() {
        return baseStock;
    }
    public void setHowManyInStock(int baseStock) {
        this.baseStock = baseStock;
    }

    public Item(String color, String brand, String gender, double price, int size, int currentStock, int baseStock, int itemId) {
        this.color = color;
        this.brand = brand;
        this.gender = gender;
        this.price = price;
        this.size = size;
        this.currentStock = currentStock;
        this.baseStock = baseStock;
        this.itemId = itemId;
    }
}

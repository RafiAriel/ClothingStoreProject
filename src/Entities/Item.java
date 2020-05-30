package Entities;

public abstract class Item {
    private String itemId, color, type, brand, gender;
    private double price;
    private int size, howManySold, howManyInStock;

    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
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
    public int getHowManySold() {
        return howManySold;
    }
    public void setHowManySold(int howManySold) {
        this.howManySold = howManySold;
    }
    public int getHowManyInStock() {
        return howManyInStock;
    }
    public void setHowManyInStock(int howManyInStock) {
        this.howManyInStock = howManyInStock;
    }

    public Item(String itemId, String color, String type, String brand, String gender, double price, int size, int howManySold, int howManyInStock) {
        this.itemId = itemId;
        this.color = color;
        this.type = type;
        this.brand = brand;
        this.gender = gender;
        this.price = price;
        this.size = size;
        this.howManySold = howManySold;
        this.howManyInStock = howManyInStock;
    }
}

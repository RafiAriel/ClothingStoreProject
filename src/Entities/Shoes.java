package Entities;

public class Shoes extends Item{
    private String drawstringColor;

    public String getDrawstringColor() {
        return drawstringColor;
    }
    public void setDrawstringColor(String drawstringColor) {
        this.drawstringColor = drawstringColor;
    }

    public Shoes(String itemId, String color, String type, String brand, String gender, double price, int size, int howManySold, int howManyInStock, String drawstringColor) {
        super(itemId, color, type, brand, gender, price, size, howManySold, howManyInStock);
        this.drawstringColor = drawstringColor;
    }
}

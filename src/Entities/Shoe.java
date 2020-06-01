package Entities;

public class Shoe extends Item{
    private String drawstringColor;

    public String getDrawstringColor() {
        return drawstringColor;
    }
    public void setDrawstringColor(String drawstringColor) {
        this.drawstringColor = drawstringColor;
    }

    public Shoe(String color, String brand, String gender, double price, int size, int currentStock, int baseStock, int itemId, String drawstringColor) {
        super(color, brand, gender, price, size, currentStock, baseStock, itemId);
        this.drawstringColor = drawstringColor;
    }
}

package Entities;

public class Pants extends Item {
    private String pantsType;

    public String getPantsType() {
        return pantsType;
    }
    public void setPantsType(String pantsType) {
        this.pantsType = pantsType;
    }

    public Pants(String color, String brand, String gender, double price, int size, int currentStock, int baseStock, int itemId, String pantsType) {
        super(color, brand, gender, price, size, currentStock, baseStock, itemId);
        this.pantsType = pantsType;
    }
}

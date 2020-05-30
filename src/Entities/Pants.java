package Entities;

public class Pants extends Item {
    private String pantsType;

    public String getPantsType() {
        return pantsType;
    }
    public void setPantsType(String pantsType) {
        this.pantsType = pantsType;
    }

    public Pants(String itemId, String color, String type, String brand, String gender, double price, int size, int howManySold, int howManyInStock, String pantsType) {
        super(itemId, color, type, brand, gender, price, size, howManySold, howManyInStock);
        this.pantsType = pantsType;
    }
}

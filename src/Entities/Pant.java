package Entities;

public class Pant extends Item {
    private String pantsType;

    public String getPantsType() {
        return pantsType;
    }
    public void setPantsType(String pantsType) {
        this.pantsType = pantsType;
    }

    public Pant(String color, String brand, String gender, String type, double price, int size, int currentStock, int baseStock, int itemId, String pantsType) {
        super(color, brand, gender, type, price, size, currentStock, baseStock, itemId);
        this.pantsType = pantsType;
    }
    public Pant()
    {
        super();
    }
}

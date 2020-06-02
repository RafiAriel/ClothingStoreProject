package Entities;
import java.util.LinkedList;
import java.util.List;

public class Purchase {
    private Member clubMember;
    private List<Item> item;
    private double price;
    private int shoppingRating;

    public Member getClubMember() {
        return clubMember;
    }
    public void setClubMember(Member clubMember) {
        this.clubMember = clubMember;
    }
    public List<Item> getItem() {
        return item;
    }
    public void setItem(List<Item> item) {
        this.item = item;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getShoppingRating() {
        return shoppingRating;
    }
    public void setShoppingRating(int shoppingRating) {
        this.shoppingRating = shoppingRating;
    }

    public Purchase(Member clubMember, List<Item> item, double price, int shoppingRating) {
        this.clubMember = clubMember;
        this.item = item;
        this.price = price;
        this.shoppingRating = shoppingRating;
    }
}

package Entities;
import java.util.LinkedList;
import java.util.List;

public class Purchase {
    private List<Member> clubMember;
    private List<Item> item;
    private double price;
    private int shoppingRating;

    public List<Member> getClubMember() {
        return clubMember;
    }
    public void setClubMember(List<Member> clubMember) {
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

    public Purchase(List<Member> clubMember, List<Item> item, double price, int shoppingRating) {
        this.clubMember = clubMember;
        item = item;
        this.price = price;
        this.shoppingRating = shoppingRating;
    }
}

package Entities;
import java.util.ArrayList;

public class Purchase {
    private Member clubMember;
    private ArrayList<Item> item;
    private double price;
    private int shoppingRating;

    public Member getClubMember() {
        return clubMember;
    }
    public void setClubMember(Member clubMember) {
        this.clubMember = clubMember;
    }
    public ArrayList<Item> getItems() {
        return item;
    }
    public void setItem(ArrayList<Item> item) {
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

    public Purchase() {
        this.clubMember = new Member();
        this.item = new ArrayList<>();
        this.price = -1;
        this.shoppingRating = -1;
    }

    public Purchase(Member clubMember, ArrayList<Item> item, double price, int shoppingRating) {
        this.clubMember = clubMember;
        this.item = item;
        this.price = price;
        this.shoppingRating = shoppingRating;
    }

    public Purchase(Member clubMember, ArrayList<Item> item, int shoppingRating) {
        this.clubMember = clubMember;
        this.item = item;
        double sum = 0;
        for(int i=0;i<item.size();i++)
        {
           sum+= item.get(i).getPrice();
        }
        this.price = sum;
        this.shoppingRating = shoppingRating;
    }
}

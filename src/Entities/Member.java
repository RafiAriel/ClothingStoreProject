package Entities;

public class Member extends Person{
    private int pointsGained;
    private String lastBuy;

    public int getPointsGained() {
        return pointsGained;
    }
    public void setPointsGained(int pointsGained) {
        this.pointsGained = pointsGained;
    }
    public String getLastBuy() {
        return lastBuy;
    }
    public void setLastBuy(String lastBuy) {
        this.lastBuy = lastBuy;
    }

    public Member(String name, String dateOfBirth, int id, int pointsGained, String lastBuy) {
        super(name, dateOfBirth, id);
        this.pointsGained = pointsGained;
        this.lastBuy = lastBuy;
    }
}

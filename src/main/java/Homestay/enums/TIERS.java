package main.java.Homestay.enums;

public enum TIERS {
    STANDARD("Standard", 30),
    DELUXE("Deluxe", 52),
    COTTAGE("Cottage", 65);
    private final String type;
    private final int fare;
    TIERS(String type, int fare){
        this.type = type;
        this.fare = fare;
    }

    public int getFare() {
        return fare;
    }

    public String getType() {
        return type;
    }
}

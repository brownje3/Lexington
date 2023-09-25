package main.java.Homestay.enums;

import java.math.BigDecimal;

public enum TIERS {
    STANDARD("Standard", 30),
    DELUXE("Deluxe", 52),
    COTTAGE("Cottage", 65);
    private final String type;
    private final BigDecimal fare;
    TIERS(String type, int fare){
        this.type = type;
        this.fare = BigDecimal.valueOf(fare);
    }

    public BigDecimal getFare() {
        return fare;
    }

    public String getType() {
        return type;
    }
}

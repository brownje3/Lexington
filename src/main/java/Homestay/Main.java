package main.java.Homestay;

import main.java.Homestay.entity.RoomDetails;
import main.java.Homestay.enums.TIERS;

public class Main {
    public static void main(String[] args){
        RoomDetails r = new RoomDetails("Bairdotr", TIERS.COTTAGE, 2, 15);
        RoomDetails r1 = new RoomDetails("Tav", TIERS.COTTAGE, 1, 30);
        RoomDetails r2 = new RoomDetails("Carlo", TIERS.STANDARD, 0, 10);
        RoomDetails r3 = new RoomDetails("Gepetto", TIERS.DELUXE, 1, 2);

        System.out.println(r);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
    }
}

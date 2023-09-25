package main.java.Homestay;

import main.java.Homestay.entity.RoomDetails;
import main.java.Homestay.enums.TIERS;

public class Main {
    public static void main(String[] args){
        RoomDetails r = new RoomDetails("Bairdotr", TIERS.COTTAGE, 2, 15);
        StringBuilder s = new StringBuilder("Bill Id: ");
        s.append(r.getBillId());
        s.append("\nCustomer Name: " + r.getCustomerName());
        s.append("\nNo. of days: " + r.getNoOfDaysOfStay());
        s.append("\nTotal Bill: " + r.calculateBill());

        System.out.print(s);
    }
}

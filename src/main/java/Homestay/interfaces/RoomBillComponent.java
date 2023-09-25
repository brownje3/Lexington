package main.java.Homestay.interfaces;

public interface RoomBillComponent {
    float TAX = .125f;
    float EXTRA_PERSON_CHARGE = 500.00f;
    float FOOD_CHARGE = 800.00f;

    float calculateBill();
}

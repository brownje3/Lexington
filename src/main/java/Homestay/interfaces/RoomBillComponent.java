package main.java.Homestay.interfaces;

import java.math.BigDecimal;

public interface RoomBillComponent {
    BigDecimal TAX = BigDecimal.valueOf(.125);
    BigDecimal EXTRA_PERSON_CHARGE = BigDecimal.valueOf(500.00);
    BigDecimal FOOD_CHARGE = BigDecimal.valueOf(800.00);

    BigDecimal calculateBill();
}

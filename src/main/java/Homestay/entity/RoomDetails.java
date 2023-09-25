package main.java.Homestay.entity;

import main.java.Homestay.enums.TIERS;
import main.java.Homestay.interfaces.RoomBillComponent;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class RoomDetails implements RoomBillComponent {
    private static int counter = 101;
    private int billId;
    private String customerName;
    private TIERS typeOfRoom;
    private int noOfExtraPersons;
    private int noOfDaysOfStay;

    public RoomDetails(String customerName, TIERS typeOfRoom, int noOfExtraPersons,
                       int noOfDaysOfStay) {
        billId = counter;
        counter++;
        this.customerName = customerName;
        this.typeOfRoom = typeOfRoom;
        this.noOfExtraPersons = noOfExtraPersons;
        this.noOfDaysOfStay = noOfDaysOfStay;
    }

    @Override
    public BigDecimal calculateBill() {
        if (!validateDays()){
            System.out.println("Days must be greater than 0");
            throw new RuntimeException();
        }
        else if (!validateExtraPersons()){
            System.out.println("Invalid Extra Persons (VALID: 0-2 Person(s))");
            throw new RuntimeException();
        }

        BigDecimal amount = BigDecimal.ZERO;
        amount = baseAmount(amount);
        amount = fareDaysAndExtras(amount);

        return amount;
    }

    private BigDecimal baseAmount(BigDecimal amount){
        switch(typeOfRoom){
            case STANDARD:
                return TIERS.STANDARD.getFare();
            case DELUXE:
                return TIERS.DELUXE.getFare();
            case COTTAGE:
                return TIERS.COTTAGE.getFare();
            default:
                return BigDecimal.ZERO;
        }
    }

    private BigDecimal fareDaysAndExtras(BigDecimal amount){
        //total amount for stay before extras and tax
        amount = amount.multiply(BigDecimal.valueOf(noOfDaysOfStay));
        //flat rate extra person charge and food charge
        amount = amount.add(FOOD_CHARGE.multiply(BigDecimal.valueOf(noOfDaysOfStay)));
        amount = amount.add(EXTRA_PERSON_CHARGE.multiply(BigDecimal.valueOf(noOfExtraPersons)));
        //returns final price
        amount = amount.add(TAX.multiply(amount));
        amount = amount.setScale(2, RoundingMode.HALF_UP);
        return amount;
    }

    public String toString(){
        StringBuilder s = new StringBuilder("Bill Id: ");
        s.append(getBillId());
        s.append("\nCustomer Name: " + getCustomerName());
        s.append("\nNo. of days: " + getNoOfDaysOfStay());
        s.append("\nTotal Bill: " + calculateBill());
        return s.toString();
    }

    public boolean validateDays(){
        if(noOfDaysOfStay < 0){
            return false;
        } else return true;
    }
    public boolean validateExtraPersons(){
        if(noOfExtraPersons > 2 || noOfExtraPersons < 0){
            return false;
        }else return true;
    }

    public int getBillId() {
        return billId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getTypeOfRoom() {
        return typeOfRoom.getType();
    }
    public int getNoOfExtraPersons() {
        return noOfExtraPersons;
    }
    public int getNoOfDaysOfStay() {
        return noOfDaysOfStay;
    }
}

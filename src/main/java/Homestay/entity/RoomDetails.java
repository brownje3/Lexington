package main.java.Homestay.entity;

import main.java.Homestay.enums.TIERS;
import main.java.Homestay.interfaces.RoomBillComponent;

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
    public float calculateBill() {
        if (!validateDays()){
            System.out.println("Days must be greater than 0");
            throw new RuntimeException();
        }
        else if (!validateExtraPersons()){
            System.out.println("Invalid Extra Persons (VALID: 0-2 Person(s))");
            throw new RuntimeException();
        }

        float amount = 0;
        amount = baseAmount(amount);
        amount = fareDaysAndExtras(amount);

        return amount;
    }

    private float baseAmount(float amount){
        switch(typeOfRoom){
            case STANDARD:
                return TIERS.STANDARD.getFare();
            case DELUXE:
                return TIERS.DELUXE.getFare();
            case COTTAGE:
                return TIERS.COTTAGE.getFare();
            default:
                return 0;
        }
    }

    private float fareDaysAndExtras(float amount){
        //total amount for stay before extras and tax
        amount = noOfDaysOfStay * amount;
        //flat rate extra person charge and food charge
        amount = amount +
                (noOfExtraPersons * EXTRA_PERSON_CHARGE) +
                (noOfDaysOfStay * FOOD_CHARGE);
        //returns final price
        return amount + (amount * TAX);
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

package org.example;

public class Calculator {
    public static void main(String[] args) {
        System.out.println( new Calculator().cal(new HealthInsurance()));
    }


    public int cal(CustomerProfile isLoyal) {
        if (isLoyal.isLoyalCustomer())
            return 20;
        return 0;
    }



}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package statepattern;

import constants.ChangeConstants;
import java.util.Scanner;

/**
 *
 * @author sean
 */
public class InputChangeState implements VendingState {
    
    private String selectedCoin = "";
    private ChangeConstants changeConstants = new ChangeConstants();

    public int getInputValue() {
        return inputValue(Integer.parseInt(selectedCoin));
    }
    
    private int inputValue(int index) {    
        int value = 0;
        switch (index) {
            case 1 -> value = new ChangeConstants().ONE_PENNY;
            case 2 -> value = new ChangeConstants().TWO_PENCE;
            case 3 -> value = new ChangeConstants().FIVE_PENCE;
            case 4 -> value = new ChangeConstants().TEN_PENCE;
            case 5 -> value = new ChangeConstants().TWENTY_PENCE;
            case 6 -> value = new ChangeConstants().FIFTY_PENCE;
            case 7 -> value = new ChangeConstants().ONE_POUND;
            case 8 -> value = new ChangeConstants().TWO_POUNDS;
            case 9 -> value = 0;
        }   
        return value;      
    }
    
    @Override
    public void doAction(Context context) {
        Scanner input = new Scanner(System.in);
        while(!selectedCoin.equalsIgnoreCase("9")) {
            System.out.println(new ChangeConstants().toString());
            System.out.println(" Enter: 9 -> Exit");
            System.out.println("Enter change: (1 - 9)");
            selectedCoin = input.nextLine();
        }
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

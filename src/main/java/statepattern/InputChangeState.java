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
public class InputChangeState implements VendingMachineState {
    
    Scanner input = new Scanner(System.in); 
    private String optionValue = "";
    

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }    
    
    public double getInputValue() {
        return inputValue(Integer.parseInt(optionValue));
    }
    
    private double inputValue(int index) {    
        double value = 0;
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
    public void doAction(VendingMachineContext context) {
        print(); 
        optionValue = input.nextLine(); 
        setOptionValue(optionValue);
    }

    @Override
    public void print() {
        System.out.println("==== Insert Change ====");
        System.out.println(new ChangeConstants().toString());
        System.out.println("Enter: 9 -> Continue");
        System.out.println("Enter change: (1 - 9)");
    }
    
}

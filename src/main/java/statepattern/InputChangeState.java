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

    @Override
    public void doAction(Context context) {
        ChangeConstants coinConstants = new ChangeConstants();
        Scanner input = new Scanner(System.in);
        String selectedCoin = "";
        
        while(!selectedCoin.equalsIgnoreCase("9")) {
            System.out.println(coinConstants.toString());
            System.out.println(" Enter: 9 -> Exit");
            System.out.println("Enter change: (1 - 9)");
            selectedCoin = input.nextLine();
        }
    }
    
}

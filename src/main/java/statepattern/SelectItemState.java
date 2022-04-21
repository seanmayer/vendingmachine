/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package statepattern;

import java.util.Scanner;

/**
 *
 * @author sean
 */
public class SelectItemState implements VendingState{
    
    public String itemSelected;
    
    @Override
    public void doAction(Context context) {
        Scanner input = new Scanner(System.in);
        System.out.println("Select item state: ");
        this.itemSelected = input.nextLine(); 
    }
}

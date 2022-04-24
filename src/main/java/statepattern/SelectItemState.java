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
public class SelectItemState implements VendingMachineState {

  public String itemSelected;

  @Override
  public void doAction(VendingMachineContext context) {
    this.itemSelected = new Scanner(System.in).nextLine();
  }

  @Override
  public void print() {
    System.out.println("Select vending machine item: ");
  }
}

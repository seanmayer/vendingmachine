/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package statepattern;

import controllers.ChangeHandler;
import pojos.Change;

/**
 *
 * @author sean
 */
public class ChangeState implements VendingMachineState {

  private ChangeHandler changeHandler;

  public ChangeState(ChangeHandler changeHandler) {
    this.changeHandler = changeHandler;
  }

  @Override
  public void doAction(VendingMachineContext context) {
    print();
    System.out.println("===========================");
    for (Change c : changeHandler.getVendingMachineCoinList()) {
      System.out.println(c.toString());
    }
    System.out.println("===========================");
  }

  @Override
  public void print() {
    System.out.println("== Vending Machine Change =");
  }
}

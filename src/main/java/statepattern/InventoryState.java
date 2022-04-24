/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package statepattern;

import controllers.InventoryHandler;
import formatters.MoneyFormatter;
import pojos.InventoryItem;

/**
 *
 * @author sean
 */
public class InventoryState implements VendingMachineState {

  private InventoryHandler inventoryHandler;
  private MoneyFormatter moneyFormatter;

  public InventoryState(InventoryHandler inventoryHandler) {
    this.inventoryHandler = inventoryHandler;
    this.moneyFormatter = new MoneyFormatter("en", "GB");
  }

  @Override
  public void doAction(VendingMachineContext context) {
    for (InventoryItem i : inventoryHandler.getInventoryList()) {
      System.out.println("==================================");
      System.out.println(
        "= = = " +
        i.getName() +
        " | " +
        moneyFormatter.getCurrency(i.getPrice()) +
        " = = ="
      );
    }
    context.setState(this);
  }

  @Override
  public void print() {
    System.out.println("========= Vending Machine ========");
  }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package statepattern;

import controller.InventoryHandler;
import formatter.MoneyFormatter;
import pojo.InventoryItem;

/**
 *
 * @author sean
 */
public class InventoryState implements VendingState {

    private InventoryHandler inventoryHandler;   
    private MoneyFormatter moneyFormatter = new MoneyFormatter("en", "GB");
    
    public InventoryState(InventoryHandler inventoryHandler) {
        this.inventoryHandler = inventoryHandler;
    }
    
    @Override
    public void doAction(Context context) {
        System.out.println("========= Vending Machine ========");
        for (InventoryItem i : inventoryHandler.getInventoryList()) {
            System.out.println("==================================");
            System.out.println("= = = " + i.getName() + " | " + moneyFormatter.getCurrency(i.getPrice()) + " = = =");
        }
        context.setState(this);
    }
    
    @Override
    public String toString() {
        return "Start State";
    }
    
}

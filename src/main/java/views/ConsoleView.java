/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.ChangeHandler;
import controllers.InventoryHandler;
import formatters.MoneyFormatter;
import simulator.SimulateChange;
import simulator.SimulateInventory;
import statepattern.ChangeState;
import statepattern.InputChangeState;
import statepattern.InventoryState;
import statepattern.SelectItemState;
import statepattern.VendingMachineContext;

/**
 *
 * @author sean
 */
public class ConsoleView {
    
    private MoneyFormatter moneyFormatter;
    private InventoryHandler inventoryHandler;
    private ChangeHandler changeHandler;
    private VendingMachineContext context;
    
    float vendingMachineCoinsTotal = 0;
    boolean itemFound = false;
    float totalChangeInput = 0;
    float subtractPriceInput = 0;
    float totalValueOwed = 0;
    
    SelectItemState selectItemState;

    
    public ConsoleView() {
        moneyFormatter = new MoneyFormatter("en", "GB"); 
        context = new VendingMachineContext();  
    }
    
    public void runApp(){
        simulateData();
        viewItems();
        viewChangeInVendingMachine();
        getVendingMachineCoinTotal();
        selectItem();
        findItem();
        menu();
    }
    
    private void simulateData() {
        inventoryHandler = new SimulateInventory().simulateInventory();
        changeHandler = new SimulateChange().simulateChange();
    }
    
    private void viewItems() {
        InventoryState inventoryState = new InventoryState(inventoryHandler);
        inventoryState.doAction(context);
    }
    
    private void viewChangeInVendingMachine() {
        ChangeState changeState = new ChangeState(changeHandler);
        changeState.doAction(context);
    }
    
    private void getVendingMachineCoinTotal() {
        vendingMachineCoinsTotal = changeHandler.totalVendingMachineCoins();
        System.out.println("Total vending machine coins: " 
                    + vendingMachineCoinsTotal);
    }
    
    private void selectItem() {
        selectItemState = new SelectItemState();
        selectItemState.doAction(context);
    }
    
    private void findItem() {
        itemFound = inventoryHandler.findInventoryItem(selectItemState.itemSelected);
        System.out.println(itemFound ? "Found item" : "Item not found");
    }
    
    private void menu() {
        String option = "";
        if(itemFound) {
            while(!option.equalsIgnoreCase("9")) {
                
                float itemPrice = inventoryHandler.getInventoryItemPrice(selectItemState.itemSelected);

                //Insert change
                System.out.println("<----------------------");
                InputChangeState inputChangeState = new InputChangeState();
                inputChangeState.doAction(context); 
                option = inputChangeState.getOptionValue();

                //Input Change Value
                double inputChangeValue = inputChangeState.getInputValue();
                
                //Print Vending Machine Status
                System.out.println("---------------------->");
                System.out.println("Price of item: " + moneyFormatter.getCurrency(itemPrice));
                System.out.println("Inputted change value: " + moneyFormatter.getCurrency((float)inputChangeValue));
                totalChangeInput += inputChangeValue;
                System.out.println("Total change inputted: " + moneyFormatter.getCurrency((float)totalChangeInput));

                //Calculate money owed
                subtractPriceInput = (float)totalChangeInput - itemPrice;
                totalValueOwed = (subtractPriceInput > 0 ? subtractPriceInput:0);
                System.out.println("Total change owed: " + moneyFormatter.getCurrency(totalValueOwed));
            }

            //Check if user has inputted enough money and does vending machine have enough to give back?
            if(subtractPriceInput >= 0 && totalValueOwed <= vendingMachineCoinsTotal) {            
                    System.out.println("Total change returned: " + moneyFormatter.getCurrency(totalValueOwed)); 
                    changeHandler.calculateChangeToGive((float)totalValueOwed);
                    //changeHandler.getChangeListToRemove();
                    
            } else {
                System.out.println("Insufficient funds...");
                System.out.println("Return inputted amount: " + moneyFormatter.getCurrency((float)totalChangeInput));
            }
    }
    }
            

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.ChangeHandler;
import controllers.InventoryHandler;
import formatters.MoneyFormatter;
import java.util.Scanner;
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
    
    private float vendingMachineCoinsTotal = 0;
    private boolean itemFound = false;
    private float totalChangeInput = 0;
    private float subtractPriceInput = 0;
    private float totalValueOwed = 0;
    
    private SelectItemState selectItemState;

    public ConsoleView() {
        moneyFormatter = new MoneyFormatter("en", "GB"); 
        context = new VendingMachineContext(); 
    }
    
    public void runApp(){
        simulateData();
        Scanner input = new Scanner(System.in);
        while(true) {
        System.out.println("Vending machine options: (1-3)");
        System.out.println("1 - View items");
        System.out.println("2 - View Change In Vending Machine");
        System.out.println("3 - Select item");
        System.out.println("Select option: ");
        int option = input.nextInt();
        switch (option) {
            case 1 -> viewItems(); 
            case 2 -> viewChangeInVendingMachine();
            case 3 -> System.out.println(selectItem() ? "Found item" : "Item not found");
        }
        }
    }
    
    private void reinitilise() {
        totalChangeInput = 0;
        subtractPriceInput = 0;
        totalValueOwed = 0;
    }
    
    private void simulateData() {
        inventoryHandler = new SimulateInventory().simulateInventory();
        changeHandler = new SimulateChange().simulateChange();
        vendingMachineCoinsTotal = changeHandler.totalVendingMachineCoins();
    }
    
    private void viewItems() {
        InventoryState inventoryState = new InventoryState(inventoryHandler);
        inventoryState.print();
        inventoryState.doAction(context);
    }
    
    private void viewChangeInVendingMachine() {
        ChangeState changeState = new ChangeState(changeHandler);
        changeState.doAction(context);
        System.out.println("Total vending machine coins: £" + vendingMachineCoinsTotal);
        System.out.println("==================================");
    }
    
    private boolean selectItem() {
        selectItemState = new SelectItemState();
        selectItemState.print();
        selectItemState.doAction(context);
        itemFound = inventoryHandler.findInventoryItem(selectItemState.itemSelected);
        if(itemFound) {
            menu();
        }
        return itemFound;
    }
    
    private void printVendingMachineStatus(
            float itemPrice, 
            float inputChangeValue, 
            float totalChangeInput, 
            float totalValueOwed
    ) {
        //Print Vending Machine Status
        System.out.println("=== Vending Machine Status ===");
        System.out.println("Price of item: " + moneyFormatter.getCurrency(itemPrice));
        System.out.println("Inputted change value: " + moneyFormatter.getCurrency((float)inputChangeValue));
        System.out.println("Total change inputted: " + moneyFormatter.getCurrency((float)totalChangeInput));
        System.out.println("Total change owed: " + moneyFormatter.getCurrency(totalValueOwed));
        System.out.println("===============================");
    }
    

    
    private void menu() {
        String option = "";
        if(itemFound) {
            while(!option.equalsIgnoreCase("9")) {
                float itemPrice = inventoryHandler.getInventoryItemPrice(selectItemState.itemSelected);

                //Insert change
                InputChangeState inputChangeState = new InputChangeState();
                inputChangeState.doAction(context); 
                option = inputChangeState.getOptionValue();

                //Input Change Value
                double inputChangeValue = inputChangeState.getInputValue();
                

                changeHandler.addChange(inputChangeValue);
                
                totalChangeInput += inputChangeValue;
                subtractPriceInput = (float)totalChangeInput - itemPrice;
                totalValueOwed = (subtractPriceInput > 0 ? subtractPriceInput:0);
                
                printVendingMachineStatus(itemPrice,
                        (float)inputChangeValue,
                        totalChangeInput,
                        totalValueOwed
                );    
                
            }
            
            //Check if user has inputted enough money and does vending machine have enough to give back?
            if(subtractPriceInput >= 0 && totalValueOwed <= vendingMachineCoinsTotal) {            
                System.out.println("===== Total Change Return =====");
                System.out.println("Try to return change: " + moneyFormatter.getCurrency(totalValueOwed)); 
                
                

                
                boolean canGiveChange = changeHandler.calculateChangeToGive((float)totalValueOwed);
                
                if(canGiveChange || totalValueOwed == 0) {
                    inventoryHandler.removeInventoryItem(selectItemState.itemSelected);
                    System.out.println(selectItemState.itemSelected + " Item dispensed!");
                } else {
                    System.out.println("No item dispensed!");
                }
                
                for (Float f : changeHandler.getChangeListToRemove()) {
                    System.out.println("Change to return : " + f);
                    System.out.println(changeHandler.removeChange(f) ? 
                            "Change removed from machine successfully" : 
                            "Failed to remove change from machine");
                }
                reinitilise();
                    
            } else {
                changeHandler.returnPendingChange();
                System.out.println("Insufficient funds...");
                System.out.println("Return inputted amount: " + moneyFormatter.getCurrency((float)totalChangeInput));
                reinitilise();
            }
    }
    }
            

    
}

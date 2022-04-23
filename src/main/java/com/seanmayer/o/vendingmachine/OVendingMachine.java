/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.seanmayer.o.vendingmachine;

import controller.ChangeHandler;
import controller.InventoryHandler;
import simulator.SimulateInventory;
import formatter.MoneyFormatter;
import java.util.Scanner;
import pojo.InventoryItem;
import simulator.SimulateChange;
import statepattern.VendingMachineContext;
import statepattern.InputChangeState;
import statepattern.InventoryState;
import statepattern.SelectItemState;
import statepattern.VendingMachineState;


/**
 *
 * @author sean
 * 
 * Amount of inventory 
 * Amount of currency deposited 
 * Create change
 * Item selected
 */
public class OVendingMachine {
    
    
    
    public static void main(String[] args) {
    
    MoneyFormatter moneyFormatter = new MoneyFormatter("en", "GB");    
        
    //Simulate Vending Machine
    InventoryHandler inventoryHandler = new SimulateInventory().simulateInventory();
    ChangeHandler changeHandler = new SimulateChange().simulateChange();
    
    VendingMachineContext context = new VendingMachineContext();
    
    //View products
    InventoryState inventoryState = new InventoryState(inventoryHandler);
    inventoryState.doAction(context);
    
    //Select product
    SelectItemState selectItemState = new SelectItemState();
    selectItemState.doAction(context);
    
    //Find product
    System.out.println("Finding Item...");
    boolean itemFound = inventoryHandler.findInventoryItem(selectItemState.itemSelected);
        
    String option = "";
    if(itemFound) {
        
        float totalChangeInput = 0;
        float subtractPriceInput = 0;
        
        while(!option.equalsIgnoreCase("9")) {
            
            //purchase price?
            float itemPrice = inventoryHandler.getInventoryItemPrice(selectItemState.itemSelected);
            
            //Insert change
            System.out.println("<----------------------");
            InputChangeState inputChangeState = new InputChangeState();
            inputChangeState.doAction(context); 
            
            System.out.println("---------------------->");
            option = inputChangeState.getOptionValue();
            double inputChangeValue = inputChangeState.getInputValue();
            System.out.println("---------------------->");
            System.out.println("Option value: " + option);
            System.out.println("---------------------->");
            System.out.println("Price of item: " + moneyFormatter.getCurrency(itemPrice));
            System.out.println("Inputted change value: " + moneyFormatter.getCurrency((float)inputChangeValue));
            
            totalChangeInput += inputChangeValue;
            System.out.println("Total change inputted: " + moneyFormatter.getCurrency((float)totalChangeInput));
            
            subtractPriceInput = (float)totalChangeInput - itemPrice;
            float totalValueOwed = (subtractPriceInput > 0 ? subtractPriceInput:0);

            System.out.println("Total change owed: " + moneyFormatter.getCurrency(totalValueOwed));
            
        }
    }
    
    
    //do you have the correct amount?
    
        //if yes
            //continue
        //if no
            // give back change
    
    //does the machine have enough to give your money back?
        //if yes
            //receive change
            //receive product
        //if no
            //give back change
    
    //receive product

    
        
        //

        //InventoryState inventoryState = new InventoryState(inventoryHandler);
        //inventoryState.doAction(context);
        
        //SelectItemState selectItemState = new SelectItemState();
        //selectItemState.doAction(context);
        
        //System.out.println(inventoryHandler.findInventoryItem(selectItemState.itemSelected));
        //System.out.println(inventoryHandler.getInventoryItemPrice(selectItemState.itemSelected));
        
        //InputChangeState inputChangeState = new InputChangeState();
        //inputChangeState.doAction(context);
        
        


    }
}

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
import statepattern.Context;
import statepattern.InputChangeState;
import statepattern.InventoryState;
import statepattern.SelectItemState;
import statepattern.VendingState;


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
        
        SimulateInventory simulateInventory = new SimulateInventory();
        SimulateChange simulateVendingMachineChange = new SimulateChange();
        
        InventoryHandler inventoryHandler = simulateInventory.simulateInventory();
        ChangeHandler changeHandler = simulateVendingMachineChange.simulateChange();
        
        System.out.println(changeHandler.getVendingMachineCoinList());
        
        //Context context = new Context();

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

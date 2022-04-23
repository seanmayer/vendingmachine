/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulator;

import controllers.ChangeHandler;
import controllers.InventoryHandler;
import java.util.ArrayList;
import pojos.Change;
import pojos.InventoryItem;

/**
 *
 * @author sean
 */
public class SimulateInventory {
    
    private InventoryHandler inventoryHandler;
    private ArrayList<InventoryItem> inventoryList;
        
    public SimulateInventory() {
        inventoryHandler = new InventoryHandler();
        inventoryList = new ArrayList<>();
    }
    
    public InventoryHandler simulateInventory() {
        inventoryList.add(new InventoryItem("Walkers Crisps",(float)1.50));
        inventoryList.add(new InventoryItem("Walkers Crisps",(float)1.50));
        inventoryList.add(new InventoryItem("Walkers Crisps",(float)1.50));
        inventoryList.add(new InventoryItem("Walkers Crisps",(float)1.50));
        inventoryList.add(new InventoryItem("Pepsi",(float)1.50));
        inventoryList.add(new InventoryItem("Pepsi",(float)1.50));
        inventoryList.add(new InventoryItem("Pepsi",(float)1.50));
        inventoryList.add(new InventoryItem("Cola",(float)1.50));
        inventoryList.add(new InventoryItem("Cola",(float)1.50));
        inventoryList.add(new InventoryItem("Cola",(float)1.50));
        inventoryHandler.setInventoryList(inventoryList);
        return inventoryHandler;
    }

    
    
}

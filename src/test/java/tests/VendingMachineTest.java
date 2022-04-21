/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import controller.InventoryHandler;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pojo.InventoryItem;
/**
 *
 * @author sean
 */
public class VendingMachineTest {
    
    InventoryHandler inventoryHandler = new InventoryHandler();
    ArrayList<InventoryItem> inventoryList = new ArrayList<>();
    
    @Test
    @Order(1)
    void testAssertInventoryList() {
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
        assertTrue(inventoryList.size() == 10);
    }
    
    @Test
    @Order(2)
    void testAssertGetInventoryList() {
        assertTrue(inventoryList.size() == 10);
    }

}

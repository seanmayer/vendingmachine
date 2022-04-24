/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import controllers.InventoryHandler;
import java.util.ArrayList;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pojos.InventoryItem;

/**
 *
 * @author sean
 */
public class VendingMachineTest {

  private InventoryHandler inventoryHandler = new InventoryHandler();
  private ArrayList<InventoryItem> inventoryList = new ArrayList<>();

  @Test
  @Order(1)
  void testAssertInventoryList() {
    inventoryList.add(new InventoryItem("Walkers Crisps", (float) 1.50));
    inventoryList.add(new InventoryItem("Pepsi", (float) 1.50));
    inventoryList.add(new InventoryItem("Cola", (float) 1.50));
    inventoryHandler.setInventoryList(inventoryList);
    assertTrue(inventoryHandler.getInventoryList().size() == 3);
  }

  @Test
  @Order(2)
  void testAssertFindInventoryItem() {
    inventoryList.add(new InventoryItem("Cola", (float) 1.50));
    inventoryHandler.setInventoryList(inventoryList);
    assertTrue(inventoryHandler.findInventoryItem("Cola"));
  }

  @Test
  @Order(3)
  void testAssertFindInventoryItemPrice() {
    inventoryList.add(new InventoryItem("Cola", (float) 1.50));
    inventoryHandler.setInventoryList(inventoryList);
    assertTrue(inventoryHandler.getInventoryItemPrice("Cola") == 1.50);
  }
}

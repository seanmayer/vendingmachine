/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import pojos.InventoryItem;

/**
 *
 * @author sean
 */
public class InventoryHandler {

  private ArrayList<InventoryItem> inventoryList;

  public InventoryHandler() {
    inventoryList = new ArrayList<>();
  }

  public ArrayList<InventoryItem> getInventoryList() {
    return inventoryList;
  }

  public void setInventoryList(ArrayList<InventoryItem> inventoryList) {
    this.inventoryList = inventoryList;
  }

  public boolean findInventoryItem(String search) {
    for (int i = 0; i < inventoryList.size(); i++) {
      if (search.equalsIgnoreCase(inventoryList.get(i).getName())) {
        return true;
      }
    }
    return false;
  }

  public boolean removeInventoryItem(String search) {
    for (InventoryItem i : inventoryList) {
      if (search.equalsIgnoreCase(i.getName())) {
        System.out.println("Collecting item from vending machine");
        System.out.println(inventoryList.remove(i));
        return true;
      }
    }
    return false;
  }

  public float getInventoryItemPrice(String search) {
    for (int i = 0; i < inventoryList.size(); i++) {
      if (search.equalsIgnoreCase(inventoryList.get(i).getName())) {
        return inventoryList.get(i).getPrice();
      }
    }
    return 0;
  }
}

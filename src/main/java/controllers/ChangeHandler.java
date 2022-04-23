/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import pojos.Change;

/**
 *
 * @author sean
 */
public class ChangeHandler {

    private ArrayList<Change> vendingMachineCoinList; 
    private ArrayList<Change> pendingVendingMachineCoinList;
    
    public ChangeHandler() {
        vendingMachineCoinList = new ArrayList<>();
        pendingVendingMachineCoinList = new ArrayList<>();
    }
    
    public ArrayList<Change> getVendingMachineCoinList() {
        return vendingMachineCoinList;
    }

    public void setVendingMachineCoinList(ArrayList<Change> vendingMachineCoinList) {
        this.vendingMachineCoinList = vendingMachineCoinList;
    }

    public float totalVendingMachineCoins() {
        float total = 0;
        for(Change c : vendingMachineCoinList) {
            total += c.getValue();
        }
        return total;
    }
    
    public void addChange(String type, float change) {
        vendingMachineCoinList.add(new Change(type, change));
        pendingVendingMachineCoinList.add(new Change(type, change));
    }

    public ArrayList<Change> getPendingVendingMachineCoinList() {
        return pendingVendingMachineCoinList;
    }

    public void setPendingVendingMachineCoinList(ArrayList<Change> pendingVendingMachineCoinList) {
        this.pendingVendingMachineCoinList = pendingVendingMachineCoinList;
    }
    
}

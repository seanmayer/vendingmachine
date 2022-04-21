/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import pojo.Change;

/**
 *
 * @author sean
 */
public class ChangeHandler {

    private float totalChangeReceived;
    private float totalVendingMachineChange;
    private ArrayList<Change> vendingMachineCoinList; 

    public ChangeHandler() {
        this.totalChangeReceived = 0;
        this.totalVendingMachineChange = 0;
    }

    public ArrayList<Change> getVendingMachineCoinList() {
        return vendingMachineCoinList;
    }

    public void setVendingMachineCoinList(ArrayList<Change> vendingMachineCoinList) {
        this.vendingMachineCoinList = vendingMachineCoinList;
    }
    
    
    /**
     * Get the value of vendingMachineChange
     *
     * @return the value of vendingMachineChange
     */
    public float getVendingMachineChange() {
        return totalVendingMachineChange;
    }

    /**
     * Set the value of vendingMachineChange
     *
     * @param vendingMachineChange new value of vendingMachineChange
     */
    public void setVendingMachineChange(float vendingMachineChange) {
        this.totalVendingMachineChange = vendingMachineChange;
    }

    /**
     * Get the value of totalChangeReceived
     *
     * @return the value of totalChangeReceived
     */
    public float getTotalChangeReceived() {
        return totalChangeReceived;
    }

    /**
     * Set the value of totalChangeReceived
     *
     * @param totalChangeReceived new value of totalChangeReceived
     */
    public void setTotalChangeReceived(float totalChangeReceived) {
        this.totalChangeReceived = totalChangeReceived;
    }

    @Override
    public String toString() {
        return "ChangeHandler{" + "totalChangeReceived=" + totalChangeReceived + ", totalVendingMachineChange=" + totalVendingMachineChange + ", vendingMachineCoinList=" + vendingMachineCoinList + '}';
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import changemakingproblem.MakeChange;
import constants.ChangeConstants;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.MathContext;
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
    
    public void removeChange(float value) {
        for(Change c : vendingMachineCoinList) {
           if(value == c.getValue()) {
            vendingMachineCoinList.remove(c); 
           }
        }
    }
    
    public boolean calculateChangeToGive(float inputValue) {
        inputValue = new BigDecimal(inputValue, MathContext.DECIMAL32).floatValue() + (float)0.001;
        MakeChange makeChange = new MakeChange(vendingMachineCoinList);
        makeChange.copyChangeList();
        boolean enoughChange = makeChange.createChangeListToRemove(inputValue);
        
        for(Float f : makeChange.getChangeListToRemove()) {
            System.out.println(f);
        }
        
        return enoughChange;
        
    }
    
    public void getChangeListToRemove() {
        
    }
    
    
    

    


    public ArrayList<Change> getPendingVendingMachineCoinList() {
        return pendingVendingMachineCoinList;
    }

    public void setPendingVendingMachineCoinList(ArrayList<Change> pendingVendingMachineCoinList) {
        this.pendingVendingMachineCoinList = pendingVendingMachineCoinList;
    }
    
}

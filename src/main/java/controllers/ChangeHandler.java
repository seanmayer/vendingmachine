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
  private ArrayList<Float> changeListToRemove;

  public ChangeHandler() {
    vendingMachineCoinList = new ArrayList<>();
    pendingVendingMachineCoinList = new ArrayList<>();
    changeListToRemove = new ArrayList<>();
  }

  public ArrayList<Change> getPendingVendingMachineCoinList() {
    return pendingVendingMachineCoinList;
  }

  public void setPendingVendingMachineCoinList(
    ArrayList<Change> pendingVendingMachineCoinList
  ) {
    this.pendingVendingMachineCoinList = pendingVendingMachineCoinList;
  }

  public ArrayList<Change> getVendingMachineCoinList() {
    return vendingMachineCoinList;
  }

  public void setVendingMachineCoinList(
    ArrayList<Change> vendingMachineCoinList
  ) {
    this.vendingMachineCoinList = vendingMachineCoinList;
  }

  public float totalVendingMachineCoins() {
    float total = 0;
    for (Change c : vendingMachineCoinList) {
      total += c.getValue();
    }
    return total;
  }

  public String getChangeType(Double change) {
    if (change == 0.01) {
      return "ONE_PENNY";
    }
    if (change == 0.02) {
      return "TWO_PENCE";
    }
    if (change == 0.05) {
      return "FIVE_PENCE";
    }
    if (change == 0.10) {
      return "TEN_PENCE";
    }
    if (change == 0.20) {
      return "TWENTY_PENCE";
    }
    if (change == 0.50) {
      return "FIFTY_PENCE";
    }
    if (change == 1.00) {
      return "ONE_POUND";
    }
    if (change == 2.00) {
      return "TWO_POUNDS";
    }
    return "ERROR";
  }

  public void addChange(double change) {
    String type = getChangeType((double) change);

    if (change != 0) {
      vendingMachineCoinList.add(new Change(type, (float) change));
      pendingVendingMachineCoinList.add(new Change(type, (float) change));
    }
  }

  public boolean removeChange(float value) {
    for (Change c : vendingMachineCoinList) {
      if (value == c.getValue()) {
        return vendingMachineCoinList.remove(c);
      }
    }
    return false;
  }

  public boolean calculateChangeToGive(float inputValue) {
    System.out.println("= = Calculate Change to Give: = = ");
    inputValue =
      new BigDecimal(inputValue, MathContext.DECIMAL32).floatValue() +
      (float) 0.001;
    MakeChange makeChange = new MakeChange(vendingMachineCoinList);
    makeChange.copyChangeList();
    boolean enoughChange = makeChange.createChangeListToRemove(inputValue);
    this.changeListToRemove = makeChange.getChangeListToRemove();
    return enoughChange;
  }

  public void returnPendingChange() {
    for (Change c : getPendingVendingMachineCoinList()) {
      removeChange(c.getValue());
    }
  }

  public ArrayList<Float> getChangeListToRemove() {
    return changeListToRemove;
  }
}

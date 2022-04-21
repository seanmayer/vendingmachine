/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulator;

import controller.ChangeHandler;
import java.util.ArrayList;
import pojo.Change;

/**
 *
 * @author sean
 */
public class SimulateChange {
    
    private ChangeHandler changeHandler;
    private ArrayList<Change> changeList; 
    
        public SimulateChange() {
        changeHandler = new ChangeHandler();
        changeList = new ArrayList<>();
    }
    
     public ChangeHandler simulateChange() {
        changeList.add(new Change("One penny",(float)1));
        changeList.add(new Change("Two pence",(float)2));
        changeList.add(new Change("Five pence",(float)5));
        changeList.add(new Change("Ten pence",(float)10));
        changeList.add(new Change("Twenty pence",(float)20));
        changeList.add(new Change("Fifty pence",(float)50));
        changeList.add(new Change("One pound",(float)100));
        changeList.add(new Change("Two pounds",(float)200));
        changeList.add(new Change("Two pounds",(float)200));
        changeList.add(new Change("Two pounds",(float)200));
        changeHandler.setVendingMachineCoinList(changeList);
        return changeHandler;
    }   
}

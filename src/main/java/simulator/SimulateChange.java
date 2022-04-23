/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulator;

import constants.ChangeConstants;
import controllers.ChangeHandler;
import java.util.ArrayList;
import pojos.Change;

/**
 *
 * @author sean
 */
public class SimulateChange {
    
    private ChangeHandler changeHandler;
    private ArrayList<Change> changeList; 
    private ChangeConstants changeConstants;
    
        public SimulateChange() {
        changeHandler = new ChangeHandler();
        changeList = new ArrayList<>();
        changeConstants = new ChangeConstants();
    }
    
     public ChangeHandler simulateChange() {
        changeList.add(new Change("ONE_PENNY",
                (float)changeConstants.ONE_PENNY));
        changeList.add(new Change("TWO_PENCE",
                (float)changeConstants.TWO_PENCE));
        changeList.add(new Change("FIVE_PENCE",
                (float)changeConstants.FIVE_PENCE));
        changeList.add(new Change("TEN_PENCE",
                (float)changeConstants.TEN_PENCE));
        changeList.add(new Change("TWENTY_PENCE",
                (float)changeConstants.TWENTY_PENCE));
        changeList.add(new Change("FIFTY_PENCE",
                (float)changeConstants.FIFTY_PENCE));
        changeList.add(new Change("ONE_POUND",
                (float)changeConstants.ONE_POUND));
        changeList.add(new Change("TWO_POUNDS",
                (float)changeConstants.TWO_POUNDS));
        changeList.add(new Change("TWO_POIUNS",
                (float)changeConstants.TWO_POUNDS));
        changeList.add(new Change("TWO_POUNDS",
                (float)changeConstants.TWO_POUNDS));
        changeHandler.setVendingMachineCoinList(changeList);
        return changeHandler;
    }   
}

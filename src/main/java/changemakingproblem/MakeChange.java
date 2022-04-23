/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package changemakingproblem;

import controllers.ChangeHandler;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;
import pojos.Change;

/**
 *
 * @author sean
 */
public class MakeChange {
    private TreeSet<Float> coins = new TreeSet<>(Comparator.reverseOrder());
    private ArrayList<Change> tempChangeList;
    private ArrayList<Float> changeListToRemove;
    

    public MakeChange(ArrayList<Change> changeList) {
        this.changeListToRemove = new ArrayList<>();
        this.tempChangeList = new ArrayList(changeList);
    }
    
    public void copyChangeList() {
        for(Change c : tempChangeList) {
            coins.add(c.getValue());
        }
    }
    
    public boolean findChangeToRemove(float changeValue) {
        for(Change c : tempChangeList) {
            if (c.getValue() == changeValue) {
                tempChangeList.remove(c);
                return true;
            }
        }
        return false;
    }
    
    public boolean createChangeListToRemove(float changeInput) {
        changeInput = new BigDecimal(changeInput, MathContext.DECIMAL32).floatValue() + (float)0.001;   
        for (float coin : coins) {

            if (changeInput - coin >= 0) {

                double divideInputByCoin = Math.floor(changeInput / coin);
                
                for (int i = 0; i < divideInputByCoin; i++) {
                    if(!findChangeToRemove(coin)) {
                        System.out.println(findChangeToRemove(coin));
                        changeListToRemove.clear();
                        return false;
                    }
                    changeListToRemove.add(coin);
                 }
                
                System.out.println("amount: " + changeInput + " £" + coin + " * " + divideInputByCoin + " = " + coin * divideInputByCoin);

                changeInput -= coin * divideInputByCoin;
            }
        }
        return true;
    }

    public ArrayList<Float> getChangeListToRemove() {
        return changeListToRemove;
    }

    public void setChangeListToRemove(ArrayList<Float> changeListToRemove) {
        this.changeListToRemove = changeListToRemove;
    }
}

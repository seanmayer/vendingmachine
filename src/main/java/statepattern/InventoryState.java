/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package statepattern;

/**
 *
 * @author sean
 */
public class InventoryState implements VendingState {
    
    
    
    @Override
    public void doAction(Context context) {
        System.out.println("Vending state");
        context.setState(this);
    }
    
    @Override
    public String toString() {
        return "Start State";
    }
    
}

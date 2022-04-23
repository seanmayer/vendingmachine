/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package statepattern;

/**
 *
 * @author sean
 */
public class VendingMachineContext {
    private VendingMachineState state;
    
    public VendingMachineContext() {
        state = null;
    }
    
    public void setState(VendingMachineState state) {
        this.state = state;
    }
    
    public VendingMachineState getState() {
        return state;
    }
}

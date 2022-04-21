/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package statepattern;

/**
 *
 * @author sean
 */
public class Context {
    private VendingState state;
    
    public Context() {
        state = null;
    }
    
    public void setState(VendingState state) {
        this.state = state;
    }
    
    public VendingState getState() {
        return state;
    }
}

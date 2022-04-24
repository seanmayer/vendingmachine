/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package statepattern;

/**
 *
 * @author sean
 */
public interface VendingMachineState {
  public void doAction(VendingMachineContext context);

  public void print();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.seanmayer.o.vendingmachine;

import statepattern.Context;
import statepattern.StartState;
import statepattern.StopState;

/**
 *
 * @author sean
 * 
 * Amount of inventory 
 * Amount of currency deposited 
 * Create change
 * Item selected
 */
public class OVendingMachine {

    public static void main(String[] args) {
        
        
        
        Context context = new Context();
        
        StartState startState = new StartState();
        startState.doAction(context);
        
        System.out.println(context.getState().toString());
        
        StopState stopState = new StopState();
        stopState.doAction(context);
        
        System.out.println(context.getState().toString());
        
        
         
        //System.out.println("Hello World!");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constants;
/**
 *
 * @author sean
 */
public class ChangeConstants {
    public final int ONE_PENNY = 1;
    public final int TWO_PENCE = 2;
    public final int FIVE_PENCE = 5;
    public final int TEN_PENCE = 10;
    public final int TWENTY_PENCE = 20;
    public final int FIFTY_PENCE = 50;
    public final int ONE_POUND = 100;
    public final int TWO_POUNDS = 200;
    
    @Override
    public String toString() {
        return """
                Acceptable Coins:
                 Enter: 1 -> One penny: """ + ONE_PENNY + "p\n " +
                "Enter: 2 -> Two pence: " + TWO_PENCE + "p\n " +
                "Enter: 3 -> Five pence: " + FIVE_PENCE + "\n " +
                "Enter: 4 -> Ten pence: " + TEN_PENCE + "p\n " +
                "Enter: 5 -> Twenty pence: " + TWENTY_PENCE + "p\n " +
                "Enter: 6 -> Fifty pence: " + FIFTY_PENCE + "p\n " +
                "Enter: 7 -> One pound: " + ONE_POUND + "p\n " +
                "Enter: 8 -> Two pounds: " + TWO_POUNDS + "p"; 
    }

}

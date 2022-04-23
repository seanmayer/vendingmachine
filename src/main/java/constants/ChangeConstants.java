/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constants;

import formatters.MoneyFormatter;

/**
 *
 * @author sean
 */
public class ChangeConstants {
    
    private MoneyFormatter moneyFormatter;
    public final double ONE_PENNY = 0.01;
    public final double TWO_PENCE = 0.02;
    public final double FIVE_PENCE = 0.05;
    public final double TEN_PENCE = 0.10;
    public final double TWENTY_PENCE = 0.20;
    public final double FIFTY_PENCE = 0.50;
    public final double ONE_POUND = 1.00;
    public final double TWO_POUNDS = 2.00;

    public ChangeConstants() {
        moneyFormatter = new MoneyFormatter("en", "GB");
    }
    
    @Override
    public String toString() {
        return """
                Acceptable Coins:
                Enter: 1 -> One penny:  """ + moneyFormatter.getCurrency((float)ONE_PENNY)+ "\n" +
                "Enter: 2 -> Two pence: " + moneyFormatter.getCurrency((float)TWO_PENCE) + "\n" +
                "Enter: 3 -> Five pence: " + moneyFormatter.getCurrency((float)FIVE_PENCE) + "\n" +
                "Enter: 4 -> Ten pence: " + moneyFormatter.getCurrency((float)TEN_PENCE) + "\n" +
                "Enter: 5 -> Twenty pence: " + moneyFormatter.getCurrency((float)TWENTY_PENCE) + "\n" +
                "Enter: 6 -> Fifty pence: " + moneyFormatter.getCurrency((float)FIFTY_PENCE) + "\n" +
                "Enter: 7 -> One pound: " + moneyFormatter.getCurrency((float)ONE_POUND) + "\n" +
                "Enter: 8 -> Two pounds: " + moneyFormatter.getCurrency((float)TWO_POUNDS); 
    }

}

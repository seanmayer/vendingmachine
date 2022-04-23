/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formatters;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author sean
 */
public class MoneyFormatter {
    
    private String language;
    private String country;

    public MoneyFormatter(String language, String country) {
        this.language = language;
        this.country = country;
    }
    
    /**
     * Get the value of language
     *
     * @return the value of language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Set the value of language
     *
     * @param language new value of language
     */
    public void setLanguage(String language) {
        this.language = language;
    }


    /**
     * Get the value of country
     *
     * @return the value of country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set the value of country
     *
     * @param country new value of country
     */
    public void setCountry(String country) {
        this.country = country;
    }


    public String getCurrency(float moneyValue) {
        return NumberFormat.getCurrencyInstance(
                new Locale(language, country)).format(moneyValue);
    };
    
}

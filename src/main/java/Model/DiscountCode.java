/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ctandou
 */
public class DiscountCode {
    public String code;
    public float taux;
    
    public DiscountCode(String code, float taux) {
        this.code=code;
        this.taux=taux;
    }

    public String getCode() {
        return code;
    }

    public float getTaux() {
        return taux;
    }
    
    
    
}

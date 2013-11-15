/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

/**
 *
 * @author pol
 */

public class Ciutat {
    String nom;
    Relations rel;
    Solution S;
    
    public Ciutat(){
        rel = new Relations();
    }
    
    public Relations get_Relations(){
        return rel;
    }
    public String getNom(){
        return nom;
    }
    
    
    public Solution get_Solution(){
        return S;
    }
}

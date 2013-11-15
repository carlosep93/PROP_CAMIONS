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
    
    public Ciutat(){
        rel = new Relations();
    }
    
    public Relations getRelation(){
        return rel;
    }
    public String getNom(){
        return nom;
    }
}

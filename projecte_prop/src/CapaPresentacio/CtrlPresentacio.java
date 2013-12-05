package CapaPresentacio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import Controladors.CtrlDomini;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pol
 */
public class CtrlPresentacio {

    Boolean Genetic;
    Boolean Anealing;
    
    private List<Entry < Integer,Integer > > punts = new ArrayList <>();
    
    private List<String> nom_elements = new ArrayList <>();
    private CtrlDomini cd = new CtrlDomini("fuck"); 
    
    
    
    public void addPunt(int x,int y,String nom,ArrayList<Integer> list) {
        Entry<Integer,Integer> aux = new java.util.AbstractMap.SimpleEntry<Integer, Integer>(x,y);
        punts.add(aux); //llista de punts amb x,y
        nom_elements.add(nom);
        
        cd.addPunt(nom, x, y, list); //llista amb les distànceis
        
    }
    
    public ArrayList<String> getElementsActivats(){
        //for(int i=0; i< cd.getEnabled().size(); ++i) System.out.println(cd.getEnabled().get(i));
     return cd.getEnabled();   
    }
        
    public Integer numElementsActius(){
        return cd.numElementsActius();
    }
         
    
    
    
    public  List<String> getNomElements(){
        return nom_elements;     
    }
    
    
    public static void main(String[] args) {
        Genetic = true;
        Vista vist = new Vista();
        
    }   

    public List<Entry < Integer,Integer > > lpunts() {
        return punts;
    }
    
    
    
    
}

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

    private static Boolean Genetic;
    private static Boolean Anealing;
    private List<Entry < Integer,Integer > > punts = new ArrayList <>();
    private List<String> nom_elements = new ArrayList <>();
    private CtrlDomini cd; 
    
    public void addPunt(int x,int y,String noms_putilla) {
        Entry<Integer,Integer> aux = new java.util.AbstractMap.SimpleEntry<Integer, Integer>(x,y);
        punts.add(aux); //llista de punts amb x,y
        nom_elements.add(noms_putilla);
        for (int i=0; i<nom_elements.size(); ++i){
            System.out.println(nom_elements.get(i));
        }
        
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

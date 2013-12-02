package CapaPresentacio;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author helewt
 */
public class CtrlPresentacio {

    static Boolean Genetic;
    static Boolean Anealing;
    static List<Entry < Integer,Integer > > punts = new ArrayList <>();
    
    public void addPunt(int x,int y) {
        Entry<Integer,Integer> aux = new java.util.AbstractMap.SimpleEntry<Integer, Integer>(x,y);
        punts.add(aux);
    }
    
    public List<Entry < Integer,Integer > > lpunts() {
        return punts;
    }
    
    
}

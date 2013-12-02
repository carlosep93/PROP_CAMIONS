/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;
import java.util.ArrayList;
import projecte_prop.City;
import projecte_prop.Relation;
import projecte_prop.Punt;
/**
 *
 * @author joanbarrosogarrido
 */
public class Citytest {
    
    
    public static void main(String[] args) {
        System.out.println("test de city");
        System.out.println("Creem ciutat");
        City C = new City("Barcelona");
        System.out.println();
        System.out.println("addElement(punt,relation[])");
        Punt P1 = new Punt(1,1,"joan");
        Punt P2 = new Punt (2,2,"josepcassatambmisiusplautestimoJKSADJASKDJSADKSAJDAputa");
        Relation bodajosepjoan = new Relation(1,2,4);
        Relation[] R = new Relation[1];
        R[0] = bodajosepjoan;
        C.addElement(P1,R);
        Relation[] R2 = new Relation[2];
        Relation joanjosep = new Relation(2,1,4);
        R2[0] = bodajosepjoan;
        R2[1] = joanjosep;
        C.addElement(P2,R);
        System.out.println("getCost(id1,id2) = " + C.getCost(0,1));
        System.out.println();
        System.out.println("getCost(punt,punt) = " + C.getCost(P1,P2));
        System.out.println();
        System.out.println("isEnabled(id) = " + C.isEnabled(0));
        System.out.println();
        System.out.println("erase(id1 = 0)");
        C.erase(0);
        System.out.println("el elemento 0 esta "+ C.isEnabled(0));
        System.out.println();
        C.enable(0);
        System.out.println("enable id = 0");
        System.out.println("el elemento 0 esta "+ C.isEnabled(0));
        System.out.println();
        System.out.println("el size es: " + C.size());
        System.out.println();
        System.out.println("get lli");
        ArrayList<ArrayList<Integer>> lli = C.getAdjacency();
        System.out.println();
        System.out.println("get nom:" + C.getNom());
        System.out.println();
        System.out.println("get lp");
        ArrayList<Punt> lp = C.getPunts();
        
        
        
        
    }
}

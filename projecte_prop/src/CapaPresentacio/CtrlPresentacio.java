package CapaPresentacio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import Controladors.CtrlDomini;
import exception.ExceptionExistence;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pol
 */
public class CtrlPresentacio {

    private  static Boolean Genetic;
    private  static Boolean Anealing;
    
    private List<Entry < Integer,Integer > > punts = new ArrayList <Entry < Integer,Integer >>();
    private List<String> nom_elements = new ArrayList <String>();
    private CtrlDomini cd = new CtrlDomini("a"); 
    
    
    public ArrayList<String> solutionAnealing(double tmp,double cool,int parada,double mutR,
            double mutS,boolean TwoAp2, boolean mut2){
                    
                    int IsgI = 0;
                    if(TwoAp2) IsgI = 1;   
                    String nomSolution = "sensenom";
                    int mutI = 1; // 0 -> rate 1-> swaprate 2-> little
                    if(mut2) mutI = 2;
         ArrayList<String> Elems = new ArrayList<String>();           
         try {           
         Elems = cd.tsp(nomSolution ,0 ,0, 0 ,0 ,IsgI ,false ,0 , 
                0,0,mutI, mutR, mutS ,0,tmp ,cool ,parada);
         punts = cd.ListPuntsXY();
         }
         catch (ExceptionExistence e) {
             VistaError error = new VistaError(e.getMessage());
         }
         
        return Elems;
    }
    
     public ArrayList<String> solutionGenetic(int stop,int ng,int nt,double mr,
             int ts,double ms,int mutate,boolean Roulet,boolean Edge,boolean Elitism){
                    
                    int IsgI = 1;  //twoAp -> 1                      
                    int TSI = 0; // 0 -> random // 1 -> rouletwheel
                    if(Roulet) TSI = 1;
                    int crossI = 0; //1 -> crosover edge
                    if(Edge) crossI = 1;
                    int mutI = mutate; // 0 -> rate 1-> swaprate 2-> little
                   
         ArrayList<String> Elems = new ArrayList<String>();           
         try {           
         
             Elems = cd.tsp( "no",1 ,stop, ng ,nt ,IsgI ,Elitism ,TSI , 
                ts ,crossI ,mutI, mr,ms ,0 ,0 ,0 ,0);
         
         punts = cd.ListPuntsXY();
         }
         catch (ExceptionExistence e) {
             VistaError error = new VistaError(e.getMessage());
         }
         
        return Elems;
    }
     
    public Integer getCost(){
        return cd.getCostSol();
    } 
     
    
    public   ArrayList<ArrayList<Integer>> GetRelations(){
        ArrayList<ArrayList<Integer>> rel = new ArrayList<ArrayList<Integer>>();
        try {
            rel = cd.getRelations();
        }
        catch (ExceptionExistence e) {
            VistaError error = new VistaError(e.getMessage());
        }
        return rel;
    }
    
    public Integer getPosicio(String nom){
        for(int i =0; i<cd.getElements().size(); ++i){
            if(cd.getElements().get(i) == nom) return i;       
        }    
        return -1;
    }
    
    public ArrayList<String> getElements(){
        return cd.getElements();
    }
    
    public void modificarAdjacencies(String nom,ArrayList<Integer> adjac){
        try{
        cd.modificarAdjacencies(nom, adjac);
        }
        catch (ExceptionExistence e) {
            VistaError error = new VistaError(e.getMessage());
        }
    }
            
    public void resetDomini() {
       
         try {  
            System.out.println("Enabled "+ cd.getEnabled().size()); 
            int m = cd.getEnabled().size();
            for (int i=0; i<m;++i) {
                cd.eliminaElement(cd.getEnabled().get(cd.getEnabled().size()-1));
            }
            //cd.eliminaElement(cd.getEnabled().get(0));
         }
         catch( ExceptionExistence e) {
             VistaError error = new VistaError(e.getMessage());
         }
        
       cd.resetIdGlobal();
       punts = new ArrayList <Entry < Integer,Integer > >();
       nom_elements = new ArrayList <String>();
    }
    
    public void eliminaElement(String s) {
        try {
            Map.Entry<Integer,Integer> aux = cd.getXY(s);
            cd.eliminaElement(s);
            for (int i=0;i<punts.size();++i) {
                if (punts.get(i).getKey() == aux.getKey() && punts.get(i).getValue()==aux.getValue())
                    punts.remove(i);
            }
            
        }
        catch (ExceptionExistence e) {
            VistaError error = new VistaError(e.getMessage());
        }
    }
    
    public void addPunt(int x,int y,String nom,ArrayList<Integer> list) {
        try {
            cd.addPunt(nom, x, y, list); //llista amb les distÃ ncies
            Entry<Integer,Integer> aux = new java.util.AbstractMap.SimpleEntry<Integer, Integer>(x,y);
            punts.add(aux); //llista de punts amb x,y
            nom_elements.add(nom);
        }
        catch(ExceptionExistence e) {
            VistaError error = new VistaError(e.getMessage());
        }
    }
    
    
    public ArrayList<String> getElementsActivats(){
        ArrayList<String> res = new ArrayList<String>();
        
            res = cd.getEnabled();
        
        
        return res;
    }
    
    public Boolean isEnabled(String nom){
        for(int i=0; i < cd.getEnabled().size(); ++i) if(nom == cd.getEnabled().get(i)) return true;
            return false;
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
    public void ResetPunts(){
        punts = new ArrayList <Entry < Integer,Integer >>();
    }
    
    public void carregar_dades (String nom){
        cd.carregar_Elements_i_Adjacencies(nom);
        
    }
    public void guardar_dades (String nom){
        cd.guardar_Elements_i_Adjacencies(nom);
    }
    
    
}

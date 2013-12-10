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
    
    
    public ArrayList<String> solutionAnealing(){
                    
                    int IsgI = 0;
                    double tmp = 1000;
                    double fact = 0.03;
                    int parada = 25;
                    int StopCondition = 20;
                    int Ngeneracions = 1000;
                    int NTours = 50;
                    boolean Elitism = true;
                    int TS = 0;
                    int TournamentSize = 5;
                    int cross = 0;
                    double MutationRate = 0.15;
                    double MutationSwapProbability = 0.9;
                    String nomSolution = "sensenom";
                    int tspI = 0;
                    int TSI = 0; // 0 -> rendom // 1 -> rouletwheel
                    int crossI = 0; //1 -> crosover edge
                    int mutI = 3; // 0 -> rate 1-> swaprate 2-> little
                    int id_sol = 0;
         ArrayList<String> Elems = new ArrayList<String>();           
         try {           
         Elems = cd.tsp(nomSolution ,tspI ,StopCondition, Ngeneracions ,NTours ,IsgI ,Elitism ,TSI , 
                TournamentSize ,crossI ,mutI, MutationRate, MutationSwapProbability ,id_sol ,tmp ,fact ,parada);
         punts = cd.ListPuntsXY();
         }
         catch (ExceptionExistence e) {
             VistaError error = new VistaError(e.getMessage());
         }
         
        return Elems;
    }
    
     public ArrayList<String> solutionGenetic(){
                    
                    int IsgI = 0;
                    double tmp = 1000;
                    double fact = 0.03;
                    int parada = 25;
                    int StopCondition = 20;
                    int Ngeneracions = 1000;
                    int NTours = 50;
                    boolean Elitism = true;
                    int TS = 0;
                    int TournamentSize = 5;
                    int cross = 0;
                    double MutationRate = 0.15;
                    double MutationSwapProbability = 0.9;
                    String nomSolution = "sensenom";
                    int tspI = 1;
                    int TSI = 0; // 0 -> rendom // 1 -> rouletwheel
                    int crossI = 0; //1 -> crosover edge
                    int mutI = 3; // 0 -> rate 1-> swaprate 2-> little
                    int id_sol = 0;
         ArrayList<String> Elems = new ArrayList<String>();           
         try {           
         Elems = cd.tsp(nomSolution ,tspI ,StopCondition, Ngeneracions ,NTours ,IsgI ,Elitism ,TSI , 
                TournamentSize ,crossI ,mutI, MutationRate, MutationSwapProbability ,id_sol ,tmp ,fact ,parada);
         punts = cd.ListPuntsXY();
         }
         catch (ExceptionExistence e) {
             VistaError error = new VistaError(e.getMessage());
         }
         
        return Elems;
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
            
    public void resetDomini(boolean tot) {
       if(tot) {
         try {  
            System.out.println("Enabled "+ cd.getEnabled().size()); 
            for (int i=0; i<cd.getEnabled().size();++i) {
                cd.eliminaElement(cd.getEnabled().get(i));
            }
            cd.eliminaElement(cd.getEnabled().get(0));
         }
         catch( ExceptionExistence e) {
             VistaError error = new VistaError(e.getMessage());
         }
        
       }
       List <Entry < Integer,Integer > > punts2 = new ArrayList <Entry < Integer,Integer > >();
       punts = punts2;
       
       
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
        try{
            res = cd.getEnabled();
        }
        catch(ExceptionExistence e) {
            //VistaError error = new VistaError(e.getMessage());
        }  
        return res;
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
    
    
    public void carregar_dades (String nom){
        cd.carregar_Elements_i_Adjacencies(nom);
        
    }
    public void guardar_dades (String nom){
        cd.guardar_Elements_i_Adjacencies(nom);
    }
    
    
}

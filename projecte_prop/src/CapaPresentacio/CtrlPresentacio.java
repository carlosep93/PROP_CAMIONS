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

    private Boolean Genetic;
    private Boolean Anealing;
    
    private List<Entry < Integer,Integer > > punts = new ArrayList <Entry < Integer,Integer >>();
    private List<String> nom_elements = new ArrayList <String>();
    private CtrlDomini cd = new CtrlDomini("fuck"); 
    
    
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
        ArrayList<String> Elems = cd.tsp(nomSolution ,tspI ,StopCondition, Ngeneracions ,NTours ,IsgI ,Elitism ,TSI , 
                TournamentSize ,crossI ,mutI, MutationRate, MutationSwapProbability ,id_sol ,tmp ,fact ,parada);
        return Elems;
    }
    
    public   ArrayList<ArrayList<Integer>> GetRelations(){
        return cd.getRelations();
    }
            
    public void resetDomini() {
        CtrlDomini cd2 = new CtrlDomini("a");
        cd = cd2;
    }
    
    public void addPunt(int x,int y,String nom,ArrayList<Integer> list) {
        Entry<Integer,Integer> aux = new java.util.AbstractMap.SimpleEntry<Integer, Integer>(x,y);
        punts.add(aux); //llista de punts amb x,y
        nom_elements.add(nom);
        cd.addPunt(nom, x, y, list); //llista amb les distànceis
        
    }
    
    public ArrayList<String> getElementsActivats(){
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

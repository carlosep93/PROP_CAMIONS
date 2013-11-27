/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladors;

/**
 *
 * @author pol
 */

import java.util.List;
import projecte_prop.*;



public class CtrlDomini { //   Aquesta clase inicialitza les variables globals, estructures de dades...
   
    String path_adjacencies_store =
   "src\\Fitxers\\saved_adjacencys.txt";
    
    String path_adjacencies_load =
   "src\\Fitxers\\saved_adjacencys.txt";
     
    String path_elements_load =
   "src\\Fitxers\\saved_elements.txt";
    
    String path_elements_store =
   "src\\Fitxers\\saved_elements.txt";
    
    public int Id_global_element;
    public int Id_global_solution;
    
    private Ciutat ciutat;
    
    public CtrlDomini(){
      Id_global_element = 0;
      Id_global_solution = 0;
      ciutat = new Ciutat();
    }
    
    public int getnewID(){ //asignar un nou id a Element
    int id = Id_global_element;
    ++Id_global_element;
    return id;
    }
      
    public int getID_sol(){ //assignar un nou id a Solution
       int id = Id_global_solution;
    ++Id_global_solution;
    return id;       
    }
    
    public Ciutat getCity(){
        return ciutat;
    }
    
    public Relations getRelations(){
        return ciutat.get_Relations();
    }
    
    public Tour getCjtElement(){
        return ciutat.get_Tour();
    }
    
    public Solution getSolution(){
        return ciutat.get_Solution();
    }
    
    public boolean[] getActius(){
        return ciutat.getActius();
    }
    

    public  void addrelation(Relations rel){
        ciutat.add_Relations(rel);
    }
       
    public void addElement(Element E, List<Integer> pesos_resta){

        ciutat.addElement(E, pesos_resta);
    }
    
    public Element consultaElement(String nom){
        return ciutat.get_Tour().getElementNom(nom);
    }
    
    public void modificaElement(Element E, String nom){
        ciutat.get_Tour().replaceElement(E, nom);
    }
    

    public  void modificarRelationsCity(Relations r){
        ciutat.add_Relations(r);
    }
    
    
    public void eliminaElement(String nom){
        ciutat.removeElement(nom);
    }
    
    public Solution tspSA(String nomSolution, double tmp, double fact, int parada){
        Solution S = new Solution(getID_sol(), nomSolution);
        S.addTour(TspSA.TspSA(ciutat, tmp, fact, parada));
        S.addCost(S.getTour().getCost(ciutat));
        ciutat.add_Solution(S);
        return S;
    }
    
    public Solution tspGA(String nomSolution, int StopCondition, int NGeneracions, int NTours, 
            boolean Elitism, boolean Rouletewheel_TS, int TournamentSize, boolean Edge_crossover,
            boolean Mutate2, double MutationRate, double MutationSwapProbability){
        
        
            Solution S = new Solution(getID_sol(), nomSolution);
            
            S.addTour(TspGA.TspGA(ciutat, StopCondition, NGeneracions, NTours, Elitism,
                    Rouletewheel_TS, TournamentSize, Edge_crossover, Mutate2,
                    MutationRate, MutationSwapProbability));
            
            S.addCost(S.getTour().getCost(ciutat));
            ciutat.add_Solution(S);
            return S;
    }
    
    
    public String get_path_adjacencies_store(){
        return path_adjacencies_store;
    }
    public String get_path_adjacencies_load(){
        return path_adjacencies_load;
    }
    
    public void edit_path_adjacencies_store(String st){
        path_adjacencies_store = st;
    }
    public void edit_path_adjacencies_load(String st){
        path_adjacencies_load = st;
    }
    
     public String get_path_elements_store(){
        return path_elements_store;
    }
    public String get_path_elements_load(){
        return path_elements_load;
    }
    
    public void edit_path_elements_store(String st){
        path_elements_store = st;
    }
    public void edit_path_elements_load(String st){
        path_elements_load = st;
    }   
}

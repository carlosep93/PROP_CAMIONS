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
    
    private Ciutat ciutat;
    
    public CtrlDomini(){
        ciutat = new Ciutat();
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
       
    public void addElement(Punt E, List<Integer> pesos_resta){

        ciutat.addElement(E, pesos_resta);
    }
    
    public Element consultaElement(String nom){
        return ciutat.get_Tour().getElementNom(nom);
    }
    
    public void modificaElement(Punt E, String nom){
        ciutat.get_Tour().replaceElement(E, nom);
    }
    

    public  void modificarRelationsCity(Relations r){
        ciutat.add_Relations(r);
    }
    
    
    public void eliminaElement(String nom){
        ciutat.removeElement(nom);
    }
    
    public Solution tspSA(String nomSolution, double tmp, double fact, int parada, int id_sol){
        Solution S = new Solution(id_sol, nomSolution);
        S.addTour(TspSA.TspSA(ciutat, tmp, fact, parada));
        ciutat.add_Solution(S);
        return S;
    }
    
    public Solution tspGA(String nomSolution, int StopCondition, int NGeneracions, int NTours, 
            boolean Elitism, boolean Rouletewheel_TS, int TournamentSize, boolean Edge_crossover,
            boolean Mutate2, double MutationRate, double MutationSwapProbability, int id_sol){
        
        
            Solution S = new Solution(id_sol, nomSolution);
            
            S.addTour(TspGA.TspGA(ciutat, StopCondition, NGeneracions, NTours, Elitism,
                    Rouletewheel_TS, TournamentSize, Edge_crossover, Mutate2,
                    MutationRate, MutationSwapProbability));
            
            ciutat.add_Solution(S);
            return S;
    }  
}

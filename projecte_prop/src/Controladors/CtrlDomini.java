
package Controladors;

import java.util.ArrayList;
import projecte_prop.*;



public class CtrlDomini {
    
    private City ciutat;
    private Solution sol;
    
    public CtrlDomini(String nom){
        ciutat = new City(nom);
    }
    
    public Solution getSolution(){
        return sol;
    }
    
    public void addPunt(String nom, int x, int y, ArrayList<Integer> pesos_resta){
        Punt P = new Punt(x, y, nom);
        
        
        for(int i = 0; i < ciutat.size(); ++i){
            if(!ciutat.isEnabled(i)) pesos_resta.add(i, -1);
        }
        ciutat.addElement(P, pesos_resta);
    }
    
    public Punt consultaPunt(String nom){
        return null;
    }
    
    public void modificaElement(Punt E, String nom){
        
    }
        
    public void eliminaElement(String nom){
        
    }

    public Solution tsp(String nomSolution, Tsp tsp, int StopCondition, int NGeneracions, int NTours,
            InitialSolGenerator isg, boolean Elitism, TournamentSelection TS, int TournamentSize, 
            Crossover cross, Mutate mut, double MutationRate, double MutationSwapProbability, 
            int id_sol, double tmp, double fact, int parada){

        
            sol = new Solution(id_sol, nomSolution);

            sol.addTour(tsp.calSol(ciutat, StopCondition, NGeneracions, NTours, isg, 
                    Elitism, TS, TournamentSize, cross, mut, MutationRate, 
                    MutationSwapProbability, tmp, fact, parada));

            return sol;
    }  
}

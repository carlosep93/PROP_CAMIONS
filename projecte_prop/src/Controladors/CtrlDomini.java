
package Controladors;

import java.util.ArrayList;
import projecte_prop.*;



public class CtrlDomini {
    
    private City ciutat;
    private Solution sol;
    private Boolean SolucioCreada;
  
    
    public CtrlDomini(String nom){
        ciutat = new City(nom);
        SolucioCreada = false;
    }
    
    public City getCity(){
        return ciutat;
    }
    
    public Solution getSolution(){
        return sol;
    }
    
    public void addPunt(String nom, int x, int y, ArrayList<Integer> pesos_resta){
        Punt P = new Punt(x, y, nom);
         ciutat.addElement(P, pesos_resta);
    }
    
    public Integer[] consultaPunt(String nom){
        int idPunt = -1;
        for(int i = 0; i < ciutat.getPunts().size(); ++i){
            if(ciutat.getPunts().get(i).getNom().equals(nom)){ idPunt = i; break; }
        }
        if(idPunt == -1) return null;
        Integer[] pesos = new Integer[ciutat.getAdjacency().get(idPunt).size()];
        for(int i = 0; i < pesos.length; ++i){
            pesos[i] = ciutat.getAdjacency().get(idPunt).get(i);
        }
        return pesos;
    }
    
   
    public void modificaElement(String nom, Integer[] pesosNew){
        int idPunt = -1;
        for(int i = 0; i < ciutat.getPunts().size(); ++i){
            if(ciutat.getPunts().get(i).getNom().equals(nom)){ idPunt = i; break; }
        }
        
        if(idPunt != -1){
            ciutat.repPesos(idPunt, pesosNew);
        }
    }
        
    public void eliminaElement(String nom){
        
    }

    public Solution tsp(String nomSolution, int tspI, int StopCondition, int NGeneracions, int NTours,
            int isgI, boolean Elitism, int TSI, int TournamentSize, 
            int crossI, int mutI, double MutationRate, double MutationSwapProbability, 
            int id_sol, double tmp, double fact, int parada){
        
            sol = new Solution(id_sol, nomSolution);
            
            InitialSolGenerator isg;
            if(isgI == 0) isg = new InitialSolGenerator_Random(ciutat);
            else isg = new Mst_Prim();
            
            TournamentSelection TS;
            if(TSI == 0) TS = new TournamentSelection_Random(ciutat, TournamentSize);
            else TS = new TournamentSelection_RouletteWheel(ciutat);
            
            Crossover cross;
            if(crossI == 0) cross = new Crossover_Simple(ciutat);
            else cross = new Crossover_Edge(ciutat);
            
            Mutate mut;
            if(mutI == 0) mut = new Mutate_Rate(ciutat, MutationRate);
            else if(mutI == 1) mut = new Mutate_SwapRate(ciutat, MutationRate, MutationSwapProbability);
            else mut = new Mutate_Little(ciutat);
            
            Tsp tsp;
            if(tspI == 0) tsp = new Tsp_SA(ciutat, isg, mut, tmp, fact, parada);
            else tsp = new Tsp_GA(ciutat, StopCondition, NGeneracions, NTours, isg, Elitism,
                    TS, cross, mut);
            
            sol.addTour(tsp.calSol());

            return sol;
    }
    
    public ArrayList<String> getEnabled(){
        return ciutat.getEnabled();
    }
    
    public Integer numElementsActius(){
        return ciutat.getEnabled().size();
    }
    
    //funcions per obtenir el cami i la solucio per la capa de presentacio
    
    public ArrayList<String> tsp_CamiDeNoms(String nomSolution, int tspI, int StopCondition, int NGeneracions, int NTours,
            int isgI, boolean Elitism, int TSI, int TournamentSize, 
            int crossI, int mutI, double MutationRate, double MutationSwapProbability, 
            int id_sol, double tmp, double fact, int parada){
        
            sol = new Solution(id_sol, nomSolution);
            Tsp tsp = new Tsp_SA();
            if(tspI == 0) tsp = new Tsp_SA();
            else if(tspI == 1) tsp = new Tsp_GA();
            
            InitialSolGenerator isg = new InitialSolGenerator_Random();
            if(isgI == 0) isg = new InitialSolGenerator_Random();
            else if(isgI == 1) isg = new InitialSolGenerator_TwoApp();
            
            TournamentSelection TS = new TournamentSelection_Random();
            if(TSI == 0) TS = new TournamentSelection_Random();
            else if(TSI == 1) TS = new TournamentSelection_RouletteWheel();
            
            Crossover cross = new Crossover_Simple();
            if(crossI == 0) cross = new Crossover_Simple();
            else if(crossI == 1) cross = new Crossover_Edge();
            
            Mutate mut = new Mutate_Rate();
            if(mutI == 0) mut = new Mutate_Rate();
            else if(mutI == 1) mut = new Mutate_SwapRate();
            else if(mutI == 2) mut = new Mutate_Little();
            
            sol.addTour(tsp.calSol(ciutat, StopCondition, NGeneracions, NTours, isg, 
                    Elitism, TS, TournamentSize, cross, mut, MutationRate, 
                    MutationSwapProbability, tmp, fact, parada));
            
            ArrayList <String> NomsEnOrdre = sol.getNomElements();
            
            SolucioCreada = true;
            return NomsEnOrdre;
    }
    public Boolean SolucioGenerada(){
        return SolucioCreada;
    }
    
    public ArrayList<ArrayList<Integer>> getRelations(){
            return ciutat.getAdjacency();
     }
    
    
    
}

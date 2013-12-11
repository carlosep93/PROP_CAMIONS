
package Controladors;

import Domini.Tsp_SA;
import Domini.InitialSolGenerator;
import Domini.Crossover_Edge;
import Domini.Mutate_Rate;
import Domini.Mutate;
import Domini.City;
import Domini.Crossover_Simple;
import Domini.TournamentSelection_Random;
import Domini.Mutate_SwapRate;
import Domini.Solution;
import Domini.InitialSolGenerator_TwoApp;
import Domini.Mutate_Little;
import Domini.TournamentSelection;
import Domini.InitialSolGenerator_Random;
import Domini.Mst_Prim;
import Domini.Punt;
import Domini.Tsp;
import Domini.TournamentSelection_RouletteWheel;
import Domini.Tsp_GA;
import Domini.Crossover;
import exception.ExceptionExistence;
import exception.ExceptionEnabled;
import java.util.ArrayList;
import CapaDades.Gestor_Dades;
import Domini.Element;
import java.util.List;
import java.util.Map;


public class CtrlDomini {
    
    private City ciutat;
    private Solution sol;
    private Boolean SolucioCreada;
    private Gestor_Dades gd;
    
    public CtrlDomini(String nom){
        ciutat = new City(nom);
        SolucioCreada = false;
        gd = new Gestor_Dades();
    }
    
    
    public int getSolution() throws ExceptionExistence{
        if(!SolucioCreada){
            throw new ExceptionExistence("No hi ha solucio");
        }
        return sol.getCost(ciutat);
    }
    
    public void resetIdGlobal(){
        Element en = new Element();
        en.iniElements();
        
    }
    
    public void addPunt(String nom, int x, int y, ArrayList<Integer> pesos_resta) throws ExceptionExistence{
        for(int i = 0; i < ciutat.size(); ++i){
            if(ciutat.getPunts().get(i).getNom().equals(nom)) throw new ExceptionExistence("Exiteix un paquet amb el mateix nom");
        }
        
        Punt P = new Punt(x, y, nom);
        ciutat.addElement(P, pesos_resta);
    }
    
    public Integer[] consultaPunt(String nom) throws ExceptionExistence{
        int idPunt = NomtoPos(nom);
        Integer[] pesos = new Integer[ciutat.getAdjacency().get(idPunt).size()];
        for(int i = 0; i < pesos.length; ++i){
            pesos[i] = ciutat.getAdjacency().get(idPunt).get(i);
        }
        return pesos;
    }
    
    
    public void modificaElement(String nom, Integer[] pesosNew) throws ExceptionExistence{
        int idPunt = NomtoPos(nom);
        
        if(idPunt != -1){
            ciutat.repPesos(idPunt, pesosNew);
        }
    }
        
    public void eliminaElement(String nom) throws ExceptionExistence{
        int idPunt = NomtoPos(nom); 
        ciutat.erase(idPunt);
        
    }
    
    public void rehabilitaElement(String nom, ArrayList<Integer> pesos_resta) throws ExceptionExistence, ExceptionEnabled{
        int idPunt = NomtoPos(nom);
        if(ciutat.getPunts().get(idPunt).isEnabled()){
            throw new ExceptionEnabled("El paquet ja està habilitat");
        }
        ciutat.rehabilitaElement(idPunt, pesos_resta);
    }
    
    public ArrayList<String> tsp(String nomSolution, int tspI, int StopCondition, int NGeneracions, int NTours,
        int isgI, boolean Elitism, int TSI, int TournamentSize, 
        int crossI, int mutI, double MutationRate, double MutationSwapProbability, 
        int id_sol, double tmp, double fact, int parada) throws ExceptionExistence{

        SolucioCreada = false;
        sol = new Solution(id_sol, nomSolution);
        if(ciutat.size() == 0){
            throw new ExceptionExistence("No hi ha cap paquet");
        }
        
        if(ciutat.getEnabled().size() < 2){
            throw new ExceptionExistence("No hi ha suficients paquets!");
        }
        SolucioCreada = true;

        InitialSolGenerator isg;
        if(isgI == 0) isg = new InitialSolGenerator_Random(ciutat);
        else{
            
            Mst_Prim prim = new Mst_Prim(ciutat);
            isg = new InitialSolGenerator_TwoApp(prim);
        }

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

        ArrayList<String> S = new ArrayList<String>();
        for(int i = 0; i < sol.size(); ++i){
            S.add(ciutat.getPunts().get(sol.getElementPos(i).getID()).getNom());
        }
        return S;
    }
    
    public ArrayList<String> getEnabled() {
        ArrayList<String> en = ciutat.getEnabled();
        return en;
    }
    
    public ArrayList<String> getElements(){
        ArrayList<String> en = new ArrayList<String>();
        for(int i=0; i<ciutat.getPunts().size(); ++i){
            en.add(ciutat.getPunts().get(i).getNom());
        }
        return en;
    }
    
    public Integer numElementsActius(){        
        return ciutat.getEnabled().size();
    }
    
    public Map.Entry < Integer,Integer > getXY(String s) {
        int x = -1;
        int y = -1;
        for (int i=0;i<ciutat.getPunts().size();++i) {
            if (s.equals(ciutat.getPunts().get(i).getNom())) {
                x = ciutat.getPunts().get(i).getX();
                y = ciutat.getPunts().get(i).getY();
            }
        }
        Map.Entry<Integer,Integer> aux = new java.util.AbstractMap.SimpleEntry<Integer, Integer>(x,y);
        return aux;
    }
    
    
    
    //memoiraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
     
    public void guardar_Elements_i_Adjacencies(String path){
        gd.GuardarDades(ciutat.getPunts(),ciutat.getAdjacency(), path);
    }
    
    public void carregar_Elements_i_Adjacencies(String path){ 
      ciutat = new City("bcn");
      ciutat.setDades(gd.carregar_adjacencies(path),gd.carregar_elements(path));
    }
   // meomoriaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa end 
   
    public void modificarAdjacencies(String nom,ArrayList<Integer> adjac) throws ExceptionExistence{
        ArrayList<Punt> elements = ciutat.getPunts();
        int posicio = -1;
        for(int i=0; i<elements.size(); ++i){
            if(elements.get(i).getNom() == nom){
                posicio = i;
            break;
            
            }
        }
        if(posicio != -1) {
            ArrayList<ArrayList<Integer>> sol = ciutat.getAdjacency();
            sol.set(posicio, adjac);
            for(int i=0; i<sol.size(); ++i){
                for(int j=0; j<sol.size(); ++j){
                    sol.get(i).set(posicio,adjac.get(i));
                }
            }
            ciutat.setDades(sol, elements);
        }
         if(posicio == -1) throw new ExceptionExistence("No existeix el Paquet");
        
    }
    
    public Integer getCostSol(){
        return sol.getCost(ciutat);
    }
    
    public List<Map.Entry < Integer,Integer > > ListPuntsXY(){
        List<Map.Entry < Integer,Integer > > punts = new ArrayList <Map.Entry < Integer,Integer >>();
       
        for ( int i=0; i<sol.size(); ++i){
            Punt p = ciutat.getPunts().get(sol.getElementPos(i).getID());
            Map.Entry<Integer,Integer> aux = new java.util.AbstractMap.SimpleEntry<Integer, Integer>(p.getX(),p.getY());
            punts.add(aux);
        }
        return punts;
    }
    
    public Boolean SolucioGenerada(){
        return SolucioCreada;
    }
    
    public ArrayList<ArrayList<Integer>> getRelations() throws ExceptionExistence{
        
        if(ciutat.size() == 0) throw new ExceptionExistence("No hi ha cap paquet");     
        return ciutat.getAdjacency();
     }
    

    
    private int NomtoPos(String nom) throws ExceptionExistence{
        int idPunt = -1;
        for(int i = 0; i < ciutat.getPunts().size(); ++i){
            if(ciutat.getPunts().get(i).getNom().equals(nom)){ idPunt = i; break; }
        }
        if(idPunt == -1) throw new ExceptionExistence("El paquet " + nom + " no existeix");
        return idPunt;
    }
    
}

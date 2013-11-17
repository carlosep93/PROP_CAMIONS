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
import java.util.Date;


public class CtrlDomini { //   Aquesta clase inicialitza les variables globals, estructures de dades...
   
    static String path_adjacencies_store =
   "src\\Fitxers\\saved_adjacencys.txt";
    
    static String path_adjacencies_load =
   "src\\Fitxers\\saved_adjacencys.txt";
     
    static String path_elements_load =
   "src\\Fitxers\\saved_elements.txt";
    
    static String path_elements_store =
   "src\\Fitxers\\saved_elements.txt";
    
    static public int Id_global_element;
    static public int Id_global_solution;
    
    private static Ciutat ciutat;
    
    public static void iniciarDomini(){
      Id_global_element = 0;
      Id_global_solution = 0;
      ciutat = new Ciutat();
    }
    
    public static int getnewID(){ //asignar un nou id a Element
    int id = Id_global_element;
    ++Id_global_element;
    return id;
    }
      
    public static int getID_sol(){ //assignar un nou id a Solution
       int id = Id_global_solution;
    ++Id_global_solution;
    return id;       
    }
    
    public static Ciutat getCity(){
        return ciutat;
    }
    
    public static  Relations getRelations(){
        return ciutat.get_Relations();
    }
    
    public static Tour getCjtElement(){
        return ciutat.get_Tour();
    }
    
    public static Solution getSolution(){
        return ciutat.get_Solution();
    }
    
    public static boolean[] getActius(){
        return ciutat.getActius();
    }
    
    public static void addElement(Element E, List<Integer> pesos_resta){
        ciutat.addElement(E, pesos_resta);
    }
    
    public static Element consultaElement(String nom){
        return ciutat.get_Tour().getElementNom(nom);
    }
    
    public static void modificaElement(Element E, String nom){
        ciutat.get_Tour().replaceElement(E, nom);
    }
    
    public static void eliminaElement(String nom){
        ciutat.removeElement(nom);
    }
    
    public static Solution tspSA(String nomSolution, double tmp, double fact, int parada){
        Solution S = new Solution(nomSolution);
        S.addTour(TspSA.TspSA(tmp, fact, parada));
        S.addCost(S.getTour().getCost());
        ciutat.add_Solution(S);
        return S;
    }
    
    public static Solution tspGA(String nomSolution, int StopCondition, int NGeneracions, int NTours, 
            boolean Elitism, boolean Rouletewheel_TS, int TournamentSize, boolean Edge_crossover,
            boolean Mutate2, double MutationRate, double MutationSwapProbability){
        
        
            Solution S = new Solution(nomSolution);
            S.addTour(TspGA.TspGA(StopCondition, NGeneracions, NTours, Elitism,
                    Rouletewheel_TS, TournamentSize, Edge_crossover, Mutate2,
                    MutationRate, MutationSwapProbability));
            S.addCost(S.getTour().getCost());
            ciutat.add_Solution(S);
            return S;
    }
    
    
    
    
    
    public static String get_path_adjacencies_store(){
        return path_adjacencies_store;
    }
    public static String get_path_adjacencies_load(){
        return path_adjacencies_load;
    }
    
    public static void edit_path_adjacencies_store(String st){
        path_adjacencies_store = st;
    }
    public static void edit_path_adjacencies_load(String st){
        path_adjacencies_load = st;
    }
    
     public static String get_path_elements_store(){
        return path_elements_store;
    }
    public static String get_path_elements_load(){
        return path_elements_load;
    }
    
    public static void edit_path_elements_store(String st){
        path_elements_store = st;
    }
    public static void edit_path_elements_load(String st){
        path_elements_load = st;
    }   
}
    
    


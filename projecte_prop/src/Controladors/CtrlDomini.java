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
import projecte_prop.Ciutat;
import projecte_prop.Relations;
import projecte_prop.Solution;
import projecte_prop.Tour;
import projecte_prop.Element;


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
        ciutat.get_Tour().removeElement(nom);
    }
    
    public static Solution generaCami(){
        return Ctrl_Algorithm.inicialitzaAlgorithm();
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
    
    


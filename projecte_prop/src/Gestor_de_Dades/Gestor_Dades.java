/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestor_de_Dades;



//import static Controladors.CtrlDomini.*;
import static  Controladors.CtrlDomini.*;
import  projecte_prop.Element;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

/**
 *
 * @author Pol
 */

// s'han de guardar: ELEMENTS, ADJACENCIES, SOLUCIONS
public class Gestor_Dades {
    
    static String pathload_Element;
    static String pathload_Solution;
    static String pathload_Adjacencies;
    
    static String pathstore_Element;
    static String pathstore_Solution;
    static String pathstore_Adjacencies;
   
    //"src/Fitxers/saved_adjacencys.txt‏"
    //"src\\Fitxers\\saved_adjacencys.txt"
    
    
    public static List<List<Integer>> carregar_adjacencies(String path){
        
        List <List<Integer>>  adjacencies = new ArrayList();
        try{
           //String path = get_path_adjacencies_load();
           
           File file = new File(path);
           Scanner sc = new Scanner(file);
          
           while(sc.hasNext()){             //primer element és num d'elements
           int num = sc.nextInt();
           for(int i=0; i<num; ++i){
               List<Integer> temp = new ArrayList<Integer>();
               for(int j=0; j<i+1; ++j){
                   int dist=sc.nextInt();
                   temp.add(dist);
               }
               adjacencies.add(temp);
           }
       }
        //tanquem en arxiu
     sc.close();
    }catch (Exception e){
        System.err.println("Error desconegut " + e.getMessage());
    }
    
        return adjacencies;   
    
}
    
    
    public static void guardar_adjacencies( List <List<Integer>> adjac,String path){
 
        PrintWriter salida = null;
        try{
       // String path = get_path_adjacencies_store();
        salida = new PrintWriter(path);
       int mida = adjac.size();
       salida.println(mida);
        
        for(int i=0; i<mida; ++i){
            List<Integer> aux = adjac.get(i);
             for(int j=0; j<aux.size(); ++j)  salida.print(aux.get(j) + " ");
             salida.println();
        }
         salida.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {         
            salida.close();
        }
       
        
  }
    
   
    public static void print_list_list(List<List<Integer>> per_printar){
        int mida= per_printar.size();
        System.out.println(mida);
        for(int i=0; i<mida; ++i){
            List<Integer> aux = per_printar.get(i);
             for(int j=0; j<aux.size(); ++j){
                 System.out.print(aux.get(j) + " ");
             }
             System.out.println();
        }
        
    }
    
    public static String list_list_ToString(List<List<Integer>> per_printar){
        String result = null;
        int mida= per_printar.size();
        System.out.println(mida);
        for(int i=0; i<mida; ++i){
            List<Integer> aux = per_printar.get(i);
             for(int j=0; j<aux.size(); ++j){
                 System.out.print(aux.get(j) + " ");
             }
        }
        return result;
    }
    
    public static void canviar_path_adjacencies_load(String path){
         
         pathload_Adjacencies = path;     
    }
    
    public static void canviar_path_adjacencies_store(String path){
         
         pathstore_Adjacencies = path;   
    }
    
    public static String get_path_adjacencies_load(){
        return pathload_Adjacencies;    
    }
 
    public static String get_path_adjacencies_store(){
        return pathstore_Adjacencies;      
    }
 
  //------------ FUNCIONS DE GUARDAR/CARREGAR ELEMENTS ----------------- 
   
    public List<Element> saved_elements(){  //Retorna la llista d'elements guardats
        List<Element> saved_elements = new ArrayList<Element>() ; 
     
        try{
         String path = pathload_Element;
           
           File file = new File(path);
           Scanner sc = new Scanner(file);
        
        String strLinea;
        int id_elem;
        boolean active;
        
         while(sc.hasNext()){             //primer element és num d'elements
           int num = sc.nextInt();
           for(int i=0; i<num; ++i){
              Element temp = new Element(sc.nextInt());
              saved_elements.add(temp);
           }
         }
        //tanquem en arxiu
     sc.close();
    }catch (Exception e){
        System.err.println("Error desconegut " + e.getMessage());
    }
    
        return saved_elements;   
    
}

    
    public void save_Element(Element elem){   //guardem un element al conjunt d'elements
        PrintWriter salida = null;
        try{
        String path = get_path_adjacencies_store();
        salida = new PrintWriter(path);
        salida.println(elem.getID());
        
         salida.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {         
            salida.close();
        }
       
    }
    
    public void discatalogue_Element(Element elem){  //invalida un element
       PrintWriter salida = null;
        try{
        String path = get_path_adjacencies_store();
        salida = new PrintWriter(path);
        while(/*No trobem element ID*/ true){
       
       //mirem elements
        
            
        }
        //borrem element
        
        
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {         
            salida.close();
        }
    
    }
  

    
    
}

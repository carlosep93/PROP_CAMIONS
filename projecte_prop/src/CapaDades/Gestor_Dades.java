/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDades;



//import static Controladors.CtrlDomini.*;
import static  Controladors.CtrlDomini.*;
import  projecte_prop.Element;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import projecte_prop.Punt;
/**
 *
 * @author Pol
 */

// s'han de guardar: ELEMENTS, ADJACENCIES, SOLUCIONS
public class Gestor_Dades {
    
    static String Path_Elements = "Fitxer_Element.txt";
    static String Path_Relations = "Fitxer_Relations.txt";
   
    //"src/Fitxers/saved_adjacencys.txt‏"
    //"src\\Fitxers\\saved_adjacencys.txt"
    
    public Gestor_Dades(){
        
    }
    
    public  ArrayList<ArrayList<Integer>> carregar_adjacencies(){
        
        ArrayList <ArrayList<Integer>>  adjacencies = new ArrayList();
        try{
           //String path = get_path_adjacencies_load();
           
           File file = new File(Path_Elements);
           Scanner sc = new Scanner(file);
          
           while(sc.hasNext()){             //primer element és num d'elements
           int num = sc.nextInt();
           for(int i=0; i<num; ++i){
               ArrayList<Integer> temp = new ArrayList<Integer>();
               for(int j=0; j<num; ++j){
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
    
    
    public  void guardar_adjacencies( ArrayList <ArrayList<Integer>> adjac){
 
        PrintWriter salida = null;
        try{
       // String path = get_path_adjacencies_store();
        salida = new PrintWriter(Path_Relations);
       int mida = adjac.size();
       salida.println(mida);
        
        for(int i=0; i<mida; ++i){
            ArrayList<Integer> aux = adjac.get(i);
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
  //------------ FUNCIONS DE GUARDAR/CARREGAR ELEMENTS ----------------- 
   
    public ArrayList<Punt> carregar_elements(){  //Retorna la llista d'elements guardats
        ArrayList<Punt> elems = new ArrayList<Punt>() ; 
     
        try{
         String path = Path_Elements;
           
           File file = new File(path);
           Scanner sc = new Scanner(file);
           int mida = sc.nextInt();
        for(int i=0; i<mida; ++i){
               
             int x = sc.nextInt();
             int y = sc.nextInt();
             String nom = sc.next();
             int id= sc.nextInt();
             boolean enabled = sc.nextBoolean();   
             Punt aux = new Punt(x,y,nom);
             aux.modifyEnabled(enabled);
             elems.add(aux);
        }
        //tanquem en arxiu
     sc.close();
    }catch (Exception e){
        System.err.println("Error desconegut " + e.getMessage());
    }
    
        return elems;   
    
}

    
    public void guardar_elements(ArrayList<Punt> elems){   //guardem un element al conjunt d'elements
        PrintWriter salida = null;
        try{
        String path = Path_Elements;
        salida = new PrintWriter(path);
        salida.println(elems.size());
        for(int i=0; i< elems.size(); ++i){
             Punt aux = elems.get(i);
             int x = aux.getX();
             int y = aux.getY();
             String nom = aux.getNom();
             int id= aux.getID();
             boolean enabled = aux.isEnabled(); 
             salida.println(x + " " + y + " " + nom + " " + id + " " + enabled);
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
    
    
}

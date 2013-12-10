/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDades;



//import static Controladors.CtrlDomini.*;

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
    
    //static String Path_Elements = "src\\CapaDades\\";
    //static String Path_Relations = "src\\CapaDades\\";
  
    
    public Gestor_Dades(){
        
    }
    
    public  void GuardarDades(ArrayList<Punt> elems, ArrayList<ArrayList<Integer>> adjac , String path){
         PrintWriter salida = null;
        try{
        salida = new PrintWriter(path);
       int mida = adjac.size();
       //printem Elements
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
        //printem adjacencies
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
    
    public static ArrayList<ArrayList<Integer>> carregar_adjacencies(String path){
        
        ArrayList <ArrayList<Integer>>  adjacencies = new ArrayList();
        try{
           
           File file = new File(path);
           Scanner sc = new Scanner(file);
         
           int mida = sc.nextInt();
        for(int i=0; i<mida; ++i){     
             int x = sc.nextInt();
             int y = sc.nextInt();
             String nom = sc.next();
             int id= sc.nextInt();
             boolean enabled = sc.nextBoolean();   
        }
          
           int num = sc.nextInt();
           for(int i=0; i<num; ++i){
               ArrayList<Integer> temp = new ArrayList<Integer>();
               for(int j=0; j<num; ++j){
                   int dist=sc.nextInt();
                   temp.add(dist);
               }
               adjacencies.add(temp);
           }
       
        //tanquem en arxiu
     sc.close();
    }catch (Exception e){
        System.err.println("Error desconegut " + e.getMessage());
    }  
    return adjacencies;     
}
    
    public static ArrayList<Punt> carregar_elements(String path){  //Retorna la llista d'elements guardats
        ArrayList<Punt> elems = new ArrayList<Punt>() ; 
     
        try{
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
             aux.modifyid(id);
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
    
    /*
    public static void guardar_adjacencies( ArrayList <ArrayList<Integer>> adjac, String path){
 
        PrintWriter salida = null;
        try{
        salida = new PrintWriter(Path_Relations+path);
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
  
    public static void guardar_elements(ArrayList<Punt> elems, String path2){   //guardem un element al conjunt d'elements
        PrintWriter salida = null;
        try{
        String path = Path_Elements +path2;
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
*/  

    public static void print_list_list(ArrayList<ArrayList<Integer>> per_printar){
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

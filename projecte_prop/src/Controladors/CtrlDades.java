/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladors;



import static Controladors.CtrlDomini.*;
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
public class CtrlDades {
    
      
   
    public static List<List<Integer>> carregar_adjacencies(){
        
        List <List<Integer>>  adjacencies = new ArrayList();
        try{
           String path = path_adjacencies_load;
           
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
    
    
     public static void guardar_adjacencies( List <List<Integer>> adjac){
 
        PrintWriter salida = null;
        try{
        String path = path_adjacencies_store;
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
    

    
    public static void canviar_path_adjacencies_load(String path){
         
         path_adjacencies_load = path;
        
    }
    
    public static void canviar_path_adjacencies_store(String path){
         
         path_adjacencies_store = path;
        
    }
    
    public static void path_adjacencies(String SO){ 
       if(SO == "Linux"){
           path_adjacencies_load = "src/Fitxers/saved_adjacencys.txt‏";
           path_adjacencies_store = "src/Fitxers/saved_adjacencys.txt‏";
       }
       else{
           path_adjacencies_load= "src\\Fitxers\\saved_adjacencys.txt";
           path_adjacencies_store = "src\\Fitxers\\saved_adjacencys.txt";
       } 
    }
    
    
    
    public static void canviar_path_elements(String path){
         path_elements = path;
    }
    
    public static String get_path_actual_load(){
        return path_adjacencies_load;      
    }
 
    public static String get_path_actual_store(){
        return path_adjacencies_store;      
    }
 
 
 
 
 
  //------------ FUNCIONS DE GUARDAR/CARREGAR ELEMENTS ----------------- 
    /*
    public List<Element> saved_elements(){  //Retorna la llista d'elements guardats
        List<Element> saved_elements = new ArrayList<Element>() ; 
     
        try{
        //obrir arxiu
        FileInputStream llegir = new FileInputStream("Ficheros/saved_elements.txt");
        //creem objecte entrada
        DataInputStream entrada = new DataInputStream(llegir);
        //creem buffer de lectura
        BufferedReader buffer = new BufferedReader (new InputStreamReader(entrada));
        
        String strLinea;
        int id_elem;
        boolean active;
        
        while ((strLinea = buffer.readLine()) != null){
           
             id_elem = Integer.parseInt(strLinea); // si es un int
            saved_elements.add(new Element(id_elem));
        }
        //tanquem en arxiu
        entrada.close();
    }catch (Exception e){
        System.err.println("Error desconegut " + e.getMessage());
    }

    return saved_elements;
    }

    
    public void save_Element(Element elem){   //guardem un element al conjunt d'elements
        
        FileWriter fichero = null;
        PrintWriter pw;
        try
        {
            fichero = new FileWriter("Ficheros/saved_elements.txt");
            pw = new PrintWriter(fichero);
            int id_elem = elem.getID();
            String valid = "false";
            if (elem.isEnabled()) valid="true";
            pw.println(id_elem);
            pw.println(valid);
 
        } catch (Exception e) {
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
           }
        }
    }
    
    public void discatalogue_Element(Element elem){  //invalida un element
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("Ficheros/saved_elements.txt");
            pw = new PrintWriter(fichero);
           
            int id_elem = elem.getID();
            int id_llegit;
 
        } catch (Exception e) {
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
           }
        }
    
    }
  

 
*/
    
    
}

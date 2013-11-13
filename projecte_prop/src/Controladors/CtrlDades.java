/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladors;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

/**
 *
 * @author Pol
 */

// s'han de guardar: ELEMENTS, ADJACENCIES, SOLUCIONS
public class CtrlDades {
    
    
    
    
    
    public static List <List<Integer>> cjt_adjacencies(){
        
        List <List<Integer>> adjacencies = new ArrayList<List<Integer>>();
        try{
        
           
           File file = new File("./saved_adjacencys");
           Scanner sc = new Scanner(file); 
           System.out.println(sc.nextInt());
           
       while(sc.hasNext()){             //primer element és num d'elements
           int num = sc.nextInt();
           
           for(int i=0; i<num; ++i){
               for(int j=0; j<i+1; ++j){
                   int dist=sc.nextInt();
                   adjacencies.get(i).set(j,dist);
                   System.out.println(dist);
               }
           }
       } 
        //tanquem en arxiu
     sc.close();
    }catch (Exception e){
        System.err.println("Error desconegut " + e.getMessage());
    }
    
        return adjacencies;   
    
}
 public static void main(String[] args) {
     List <List<Integer>> adjacencies = cjt_adjacencies();
     
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

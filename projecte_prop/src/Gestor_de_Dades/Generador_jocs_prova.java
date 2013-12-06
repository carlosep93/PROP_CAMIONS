/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *  @author Pol

 */
package Gestor_de_Dades;




import java.util.List;
import Gestor_de_Dades.*;
import java.util.ArrayList;
import java.util.Scanner;
import projecte_prop.Relations;



public class Generador_jocs_prova {
    
     
     public static void main(String[] args){
         String pathload = "src/Fitxers/";
         Scanner sc = new Scanner(System.in);
         String path;
         List <List<Integer>> lists = new ArrayList <List<Integer>>();

         System.out.println("Ubuntu(1) o windows(2) o definir path(3)?");
        if( sc.nextInt()==2 ) pathload = "src\\Fitxers\\";
        else if( sc.nextInt()==3 ) pathload = sc.next();  

         System.out.println("Ubuntu(1) o windows(2) ?");
        if( sc.nextInt()==2 ) pathload = "src\\Fitxers\\";

        System.out.println("Quin nom fitxer vols crear? (acavat amb .txt) ");
        String aux = sc.next();
        pathload = pathload+aux;
         
         System.out.println("Quants elements vols ?");
         int mida = sc.nextInt();
         
         for(int i=0; i<mida; ++i){
          List<Integer> auxl = new ArrayList<Integer>();
           for (int q=0; q<i;++q){
               auxl.add((int)(Math.random()*100));
           }
           auxl.add(0);
           lists.add(auxl);
            }         
         
         Gestor_Dades.guardar_adjacencies(lists,pathload);
         System.out.println("Guardat!!!!");
     }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *  @author Pol

 */
package CapaDades;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import Domini.Punt;




public class Generador_jocs_prova {
    
     
     public static void main(String[] args){
         Gestor_Dades gd = new Gestor_Dades();
         String pathload;
         Scanner sc = new Scanner(System.in);
         ArrayList <ArrayList<Integer>> lists = new ArrayList <ArrayList<Integer>>();
        String b = System.getProperty("file.separator");
         pathload = "src" + b + "CapaDades" + b ;
         
         
       
        System.out.println("Quin nom fitxer vols crear?");
        String aux = sc.next();
        pathload = pathload+aux+".txt";
        System.out.println(pathload);
        
         System.out.println("Quants elements vols ?");
         int mida = sc.nextInt();
         
       ArrayList<Punt> lp = new ArrayList<Punt>();
       
        for(int i=0; i< mida; ++i){
            String nom = "id"+i;
             Punt aux2 = new Punt((int)(Math.random()*400),
                                 (int)(Math.random()*400),nom);
             lp.add(aux2);
        }
         //adjacencies
         for(int i=0; i<mida; ++i){
          ArrayList<Integer> auxl = new ArrayList<Integer>();
           for (int q=0; q<i;++q){
               int num = (int)(Math.random()*100)+1;
               auxl.add(num);
           }
           auxl.add(0);
           lists.add(auxl);
            }
         
         for(int i=0; i<lists.size();++i){
             for(int j=0; j<i;++j){
                 int nu = lists.get(i).get(j);
                 lists.get(j).add(nu);
             }
         }
         
         
         gd.GuardarDades(lp, lists, pathload);
         System.out.println("Guardat!!!!");
     }
    
}

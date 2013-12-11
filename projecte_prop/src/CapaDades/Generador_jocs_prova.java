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
        pathload = pathload+aux;
        
         System.out.println("Quants elements vols ?");
         int mida = sc.nextInt();
         
        System.out.println("1-Random , 2-Nomes un cami ");
        int opcio = sc.nextInt();
      
        if(opcio == 1){
       ArrayList<Punt> lp = new ArrayList<Punt>();
       
        for(int i=0; i< mida; ++i){
            String nom = "id_"+i;
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
         
         pathload +=".txt";
         gd.GuardarDades(lp, lists, pathload);
         System.out.println("Guardat a " + pathload);
        }
        
      if(opcio == 2){
         ArrayList<Punt> lp = new ArrayList<Punt>();
         for(int i=0; i< mida; ++i){
            String nom = "id_"+i;
             Punt aux2 = new Punt((int)(Math.random()*400),
                                 (int)(Math.random()*400),nom);
             lp.add(aux2);
        }
         System.out.println("1-Valors Max , 2-Valors Random ");
        int opcio2 = sc.nextInt();
      
        if(opcio2 == 1){
            for(int i=0; i<mida; ++i){
          ArrayList<Integer> auxl = new ArrayList<Integer>();
           for (int q=0; q<i;++q){
               int num;
               if(q==i-1) num = 1;
               else if(i==mida-1 && q ==0) num = 1;
               else num = 99;
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
         
         pathload +="-ValorsMAX_Cost_"+mida+".txt";
         gd.GuardarDades(lp, lists, pathload);
         System.out.println("Guardat a " + pathload);
        }
        if(opcio2 == 2){
            for(int i=0; i<mida; ++i){
          ArrayList<Integer> auxl = new ArrayList<Integer>();
           for (int q=0; q<i;++q){
               int num;
                if(q==i-1) num = 1;
                else if(i==mida-1 && q ==0) num = 1;
               else {
                   num = (int)(Math.random()*100)+1;
                   if(num==1) num =2;
               }
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
         
         
          pathload +="-ValorsRandom_Cost_"+mida+".txt";
         gd.GuardarDades(lp, lists, pathload);
         System.out.println("Guardat a " + pathload);
        }
        }
          
      }  
        
     
    
}

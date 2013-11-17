/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;

/**
 *
 * @author pol
 */
import java.util.Scanner;

import projecte_prop.Ciutat;
import projecte_prop.Element;
import projecte_prop.Relations;
import projecte_prop.Tour;
import projecte_prop.Solution;

import java.util.List;
import java.util.ArrayList;

public class DriverClass_Ciutat {
    
    private static void write_Relation(Relations r) {
        String s;
        for (int i=0;i<r.size();++i) {
            s = r.toString(i);
            System.out.println(s);
        }
    }
   
    private static void write_Tour(Tour tour){
     for(int i=0; i<tour.size(); ++i) System.out.print(" " + tour.getElementPos(i).getID());
       }
      
    private static void write_Solution(Solution sol){
         Tour tour = sol.getTour();
         
        // System.out.println("Les dades de la Solució d'aquesta ciutat són:");
         System.out.println();
         System.out.println("Id: " + sol.getid());
         System.out.println("Nom : " + sol.getNom());
         System.out.print("Tour:");
         write_Tour(tour);
         System.out.println();
         System.out.println("El Tour té mida: " + tour.size());
         System.out.println("La solució es va crear el:  " + sol.getData());
         System.out.println("La solució te cost de:  " + sol.getCostSolution());
         System.out.println();
         System.out.println();
    }
  
    private static Solution Read_Solution(){
        
         Scanner sc = new Scanner(System.in);
         System.out.println("Entra un nom");
         String nom = sc.next();
         System.out.println("Entra un Cost");
         int lectura = sc.nextInt();
         Solution sol = new Solution(nom,lectura);
         System.out.println("Solució creada");  
         return sol;
    }
    
    private static List<Integer> Read_NewElement(int num_Elements){
        List<Integer> relacions = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
      
        if(num_Elements>0){
        System.out.println("Entra les " + num_Elements + " relacions amb els altres elements");
         System.out.println();
         for(int i=0; i<num_Elements; ++i){
            System.out.println();
            System.out.println("Entra la relació amb l'element " + (i) );    
            int lectura = sc.nextInt();
            relacions.add(lectura);
         }       
        }
        else relacions.add(0);
         System.out.println();
         System.out.println();
         System.out.println("Element afegit! :)");
         return relacions;
    }
    
     public static void main(String[] args) {
        
         Scanner sc = new Scanner(System.in);
          boolean Sistema_definit = false;
          int lectura = 0;
          boolean Elemini = false;
          Ciutat city = new Ciutat();
      
     while(lectura != 6){   
        System.out.println();
        System.out.println("-------  Informació  -------");
        System.out.println();
        System.out.println();
        System.out.println("Tria una opció: ");
        System.out.println("1- Crea una nova Ciutat");
        System.out.println("2- Veure dades de la Ciutat");
        System.out.println("3- Afegir una Solution ");
        System.out.println("4- Afegir un Element");
        System.out.println("5- Eliminar un Element");
        System.out.println("6- Sortir");
        lectura = sc.nextInt();
     
    //comprovacions
          
   //  if (lectura >1 && !Elemini) System.out.println("Inicialitza Ciutat!!");
         
     //Opcions
     
     if(lectura == 1){
         System.out.println("Entra un nom");
         String nom = sc.next();
         city = new Ciutat(nom);
     }
           
     else if(lectura == 2 ){
         System.out.println("Dades de la ciutat: ");
          System.out.println();
          System.out.println("Nom: " + city.get_Nom());
          System.out.println();
          System.out.println("Tour: " );
          write_Tour(city.get_Tour());
          System.out.println();
          System.out.println("Relations: " );
          write_Relation(city.get_Relations());
          System.out.println();
           System.out.println("Solution: " );
          write_Solution(city.get_Solution());
          System.out.println();
       
     }
     else if(lectura == 3 ){
         Solution sol = Read_Solution();
         city.add_Solution(sol);
       
     }
     else if(lectura == 4){   //afegim un element
      List elems = Read_NewElement(city.num_Elements());
      System.out.println("Quin nom vols per l'element? " );
      String nom = sc.next();
      System.out.println("Quina posicó x,y tindrà ?" );
      int x = sc.nextInt();
      int y = sc.nextInt();
      int id = Element.assign_id();
      Element elem = new Element(id,nom,x,y,true );
      city.addElement(elem,elems);  
      
     }
     else if (lectura == 5){
     System.out.println("Quin element vols eliminar? (escriu nom) " );
     String elem = sc.next();
     city.removeElement(elem);
     System.out.println("Element amb nom " + elem + " s'ha eliminat" );
     
     }
     
     System.out.println();
     System.out.println();
     System.out.print("Prem la tecla Enter per continuar");
     sc.nextLine();
     sc.nextLine(); 
       
    }
  }
}


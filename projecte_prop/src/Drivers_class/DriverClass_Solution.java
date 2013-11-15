/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;

import projecte_prop.Solution;
import java.util.Scanner;

import projecte_prop.Tour;
import projecte_prop.Element;
/**
 *
 * @author pol
 */
public class DriverClass_Solution {
    
    
     private static void write_Tour(Tour tour){
     for(int i=0; i<tour.size(); ++i) System.out.print(" " + tour.getElementPos(i).getID());
       }
    
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          boolean Sistema_definit = false;
          int lectura = 0;
          boolean Elemini = false;
          Solution sol = new Solution();
     while(lectura != 4){   
        System.out.println();
        System.out.println("-------  Informació  -------");
        System.out.println();
        System.out.println();
        System.out.println("Tria una opció: ");
        System.out.println("1- Crea una nova Solution");
        System.out.println("2- Veure dades de la Solució");
        System.out.println("3- afegir nou Tour de la Solució");
        System.out.println("4- Sortir");
        lectura = sc.nextInt();
     
    //comprovacions
          
     if (lectura >1 && !Elemini) System.out.println("Inicialitza Solució!!");
         
     //Opcions
     
     else if(lectura == 1){
         System.out.println("Entra un nom");
         String nom = sc.next();
         System.out.println("Entra un Cost");
         lectura = sc.nextInt();
         sol = new Solution(nom,lectura);
         System.out.println("Solució creada");   
         Elemini = true;
     }
           
     else if(lectura == 2 ){
         Tour tour = sol.getTour();
         System.out.println();
         System.out.println("Les dades de la solució actual són:");
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
     else if(lectura == 3 ){
        System.out.println("Afageix els valors del nou Tour:");
         Tour tour = new Tour();
         System.out.println();
         System.out.println("Quants elements vols afegir al Tour?");
         int mida = sc.nextInt();
         for(int i=0; i<mida; ++i){
            System.out.println();
            System.out.println("Entra l' ID de l'element " + (i) );    
            lectura = sc.nextInt();
            Element elem = new Element(lectura);
            tour.addElement(elem);
         }
         sol.addTour(tour);
         System.out.println();
         System.out.println();
         System.out.println("Tour afegit! :)");
     }
        
     System.out.println();
     System.out.println();
     System.out.print("Prem la tecla Enter per continuar");
     sc.nextLine();
     sc.nextLine(); 
       
    }
  }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;

/**
 *
 * @author pol
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import projecte_prop.Mutate;
import projecte_prop.Tour;
import projecte_prop.Relations;
import projecte_prop.Element;

public class DriverClass_Mutate {
    
    private static void write_Tour(Tour tour){
     for(int i=0; i<tour.size(); ++i) System.out.print(" " + tour.getElementPos(i).getID());
       }
    private static Tour Tour_prova(int mida){
        Tour tour = new Tour();
        for(int i=0; i<mida; ++i){
            Element elem = new Element(i);
            tour.addElement(elem);
        }
        return tour;
    }
    
     public static Relations Relations_prova(int mida) {
        Scanner sc2 = new Scanner(System.in);
        Relations r = new Relations();
        for (int i=0;i<mida;++i) {
            List<Integer> aux = new ArrayList <Integer>();
            for(int j=0; j<i;++j) aux.add(j);
            aux.add(0);
            r.addElement(aux);
        }
        return r;
    }
    
 public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);
    int lectura = 0;
    boolean Elemini = false;

    Tour tour = new Tour();
    double mutationRate = 0.015;
    double mutationSwapProbability = 0.90;
    Relations rel = new Relations();
  
    while(lectura != 7){   
        System.out.println();
        System.out.println("-------  Informació  -------");
        System.out.println();
        System.out.println("Valor actual de mutationRate es " + mutationRate);
        System.out.println("Valor actual de mutationSwapProbability es " + mutationSwapProbability);
        System.out.print("Tour actual ");
        write_Tour(tour);
        System.out.println();
        System.out.println("Tria una opció: ");
        System.out.println("1- Definir mutationRate");
        System.out.println("2- Definir mutationSwapProbability");
        System.out.println("3- Definir el Tour");
        System.out.println("4- Provar Mutate_1");
        System.out.println("5- provar Mutate_2");
        System.out.println("6- provar Mutate_3");
        System.out.println("7- Sortir");
        lectura = sc.nextInt();
        System.out.println();
     
    //comprovacions
          
    if (lectura >3 && !Elemini) System.out.println("Inicialitza Tour!!");
         
     //Opcions
     
    else if(lectura == 1){
         System.out.println("Entra el nou valor");
        mutationRate = sc.nextDouble();
         
     }
           
     else if(lectura == 2 ){
         System.out.println("Entra el nou valor");
        mutationSwapProbability = sc.nextDouble();  
     }
     
     else if(lectura == 3 ){
       System.out.println("Mida del Tour? ");
       int mida = sc.nextInt();
       tour = Tour_prova(mida);
       System.out.println();
       System.out.println("Hem creat un tour de mida " + mida + " amb id correlatius");
       rel = Relations_prova(mida);
       Elemini = true;
     }
     else if(lectura == 4){  
        System.out.println();
        Tour newtour = Mutate.mutate(tour, mutationRate);
        System.out.println("El tour origina és ");
        write_Tour(tour);
        System.out.println();
        System.out.println("El tour NOU és ");
        write_Tour(newtour);
        System.out.println();
        System.out.println("Vols reemplaçar el Tour original per el NOU?");
        String opc = sc.next();
        if("si".equals(opc)) tour = newtour;
        System.out.println();
        
     }
     else if (lectura == 5){
        System.out.println();
        Tour newtour = Mutate.mutate2(tour, mutationRate,mutationSwapProbability);
        System.out.println("El tour origina és ");
        write_Tour(tour);
        System.out.println();
        System.out.println("El tour NOU és ");
        write_Tour(newtour);
        System.out.println();
        System.out.println("Vols reemplaçar el Tour original per el NOU?");
        String opc = sc.next();
        if("si".equals(opc)) tour = newtour;
        System.out.println();
     }
    else if (lectura == 6){
        System.out.println();
        Tour newtour = tour;
        Mutate.mutate3(tour);
        System.out.println("El tour origina és ");
        write_Tour(tour);
        System.out.println();
        System.out.println("El tour NOU és ");
        write_Tour(newtour);
        System.out.println("Vols reemplaçar el Tour original per el NOU?");
        String opc = sc.next();
        if("no".equals(opc)) tour = newtour;
        System.out.println();
     }
     
     System.out.println();
     System.out.println();
     System.out.print("Prem la tecla Enter per continuar");
     sc.nextLine();
     sc.nextLine(); 
       
    }
  }
}

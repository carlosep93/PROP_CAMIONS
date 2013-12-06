/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;

import CapaDades.Gestor_Dades;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Pol
 */
public class DriverClass_Gestor_Dades {

    
     
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          ArrayList <ArrayList<Integer>> adjacencies = new  ArrayList <ArrayList<Integer>>();
          boolean Sistema_definit = false;
          int lectura = 0;

         String path_Elements= "/src/CapaDades/Elements.txt";
         String path_Adjacencies = "/src/CapaDades/Fitxer_Relations.txt";
    
         while(lectura != 6){   
      
        if(!Sistema_definit) {
         System.out.println("Triar S.O :");
            System.out.println("Vols path de Linux (1)  Windows (2)");
           
            if( sc.nextInt()==2 ){
                
                path_Elements = "src\\CapaDades\\Elements.txt";
                path_Adjacencies = "src\\CapaDades\\Fitxer_Relations.txt";
            }
            Sistema_definit = true;
            }
            
     
        
        System.out.println();
        System.out.println("Tria una opció:");
        System.out.println("1 - Crear adjacencies");
        System.out.println("2 - Carregar Adjacencies de Disc");
        System.out.println("3 - Guardar Adjacencies al Disc");
        System.out.println("4 - Imprimir per Pantalla Adjacencies");
        System.out.println("5 - torna a seleccionar SO");
        System.out.println("6 - Sortir");
        System.out.println();
        
       lectura = sc.nextInt();
       
       if (lectura == 1) {
        System.out.println("Quina mida");
        adjacencies = new  ArrayList <ArrayList<Integer>>();
        int mida= sc.nextInt();
        for(int i=0; i<mida; ++i){
            ArrayList<Integer> aux = new ArrayList<Integer>();
             for(int j=0; j<mida; ++j){
                 System.out.print("Element a la posicio [" + i + "][" + j + "]");
                 aux.add(sc.nextInt());
             }
             adjacencies.add(aux);
             System.out.println();
        }
       }
  
       else if (lectura == 2) {
                System.out.println();
                adjacencies = Gestor_Dades.carregar_adjacencies();
                System.out.println("Adjacencies carregades desde el fixer " + path_Adjacencies + " :) ");
       
             

         }
        else if (lectura == 3){
                
                Gestor_Dades.guardar_adjacencies(adjacencies);
                System.out.println("Adjacencies guardades a " + " :)" );
     }
       
        else if(lectura == 4)  Gestor_Dades.print_list_list(adjacencies);
        else if(lectura == 5) Sistema_definit = false;
        
        System.out.println();
        System.out.print("Prem la tecla Enter per continuar");
        sc.nextLine();
        sc.nextLine();      
    }    
  }
}



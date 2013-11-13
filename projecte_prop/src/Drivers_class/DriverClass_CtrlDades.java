/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;

import static Controladors.CtrlDades.*;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Pol
 */
public class DriverClass_CtrlDades {

    
     
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          List <List<Integer>> adjacencies = null;
          boolean Sistema_definit = false;
          int lectura = 0;
     
     while(lectura != 5){   
        System.out.println();
        
        System.out.println("-------  Informació  -------");
         System.out.println();
        System.out.println("PATH actual de LOAD: "  + get_path_actual_load());
        System.out.println("PATH actual de STORE: "  + get_path_actual_store());
         System.out.println();
        System.out.print("Adjacencies carregades ");
        if(adjacencies == null) System.out.println( "--> CAP");
        else System.out.println( "SI");
       
        if(!Sistema_definit) {
         System.out.println("Triar S.O :");
            System.out.println("Utilitzes  Linux (1) o Windows (2)");
            String nom = sc.next();
            if (("1".equals(nom)) || ("Linux".equals(nom))) path_adjacencies("Linux");
            else if (("2".equals(nom)) || ("Windows".equals(nom))) path_adjacencies("Windows");
            Sistema_definit = true;
     }
        
        System.out.println();
        System.out.println("Tria una opció:");
        System.out.println("1 - Carregar Adjacencies de Disc");
        System.out.println("2 - Guardar Adjacencies al Disc");
        System.out.println("3 - Imprimir per Pantalla Adjacencies");
        System.out.println("4 - torna a seleccionar SO");
        System.out.println("5 - Sortir");
        System.out.println();
        
       lectura = sc.nextInt();
  
        if((lectura == 2 || lectura == 3) && adjacencies == null)
        System.out.println("Adjacencies no carregades, primer opcio 1");
        
        if (lectura == 1) {
            String path = get_path_actual_load();
                System.out.println();
                System.out.println("Vols canviar el PATH del fixer d' entrada? (1-> si 2-> no)");
                 
                int SI = sc.nextInt();
                if (SI == 1){
                System.out.println("Entra el nou PATH amb el format correcte");
                 path = sc.next();
                canviar_path_adjacencies_load(path);
                }
                adjacencies = carregar_adjacencies();
                System.out.println("Adjacencies carregades desde el fixer " + path + " :) ");
         }
        else if (lectura == 2){
          String path = get_path_actual_store();
          System.out.println();
          System.out.println("Vols canviar el PATH on es guarden les Adjacencies? (1->si 2->no) ");
          
          int SI = sc.nextInt();
                if (SI == 1){
                System.out.println("Entra el nou PATH amb el format correcte");
                path = sc.next();
                canviar_path_adjacencies_store(path);
                }
                guardar_adjacencies(adjacencies);
                System.out.println("Adjacencies guardades a " + path + " :)" );
     }
       
        else if(lectura == 3)  print_list_list(adjacencies);
        else if(lectura == 4) Sistema_definit = false;
        
        System.out.println();
        System.out.print("Prem la tecla Enter per continuar");
        sc.nextLine();
        sc.nextLine();
        
    }    
  }
}



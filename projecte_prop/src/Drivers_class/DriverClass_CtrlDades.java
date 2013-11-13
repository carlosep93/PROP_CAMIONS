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
          
          int lectura = 0;
      while(lectura != 5){   
        System.out.println();
        System.out.println("Tria una opció:");
        System.out.println("1 - Carregar Adjacencies de Disc");
        System.out.println("2 - Guardar Adjacencies a Disc");
        System.out.println("3 - Imprimir per Pantalla Adjacencies");
        System.out.println("4 - Canviar path de fichers");
        System.out.println("5 - Sortir");
        System.out.println();
        
        lectura=sc.nextInt();
        
      
     if(lectura == 1) adjacencies = carregar_adjacencies();
     if(lectura == 2) guardar_adjacencies(adjacencies);
     if(lectura == 3)  print_list_list(adjacencies);
     if(lectura == 4){
         System.out.println("escriu el nou path");
         String path = sc.nextLine();
         canviar_path_adjacencies(path);
     }
    }   
    
  }
}


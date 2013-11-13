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
          boolean path_definit = false;
          boolean adja_carregada = false;
          int lectura = 0;
      while(lectura != 5){   
        System.out.println();
        
        System.out.println("-------  Informació  -------");
        System.out.println("PATH actual: "  + get_path_actual());
        System.out.println();
        System.out.println("Tria una opció:");
        System.out.println("1 - Definir PATH de fixers");
        System.out.println("2 - Carregar Adjacencies de Disc");
        System.out.println("3 - Guardar Adjacencies a Disc");
        System.out.println("4 - Imprimir per Pantalla Adjacencies");
        System.out.println("5 - Sortir");
        System.out.println();
        
       lectura = sc.nextInt();
        
        if(lectura != 1 && lectura <5 && path_definit==false) {
           System.out.println("PATH NO DEFINIT!   SISPLAU FES LA OPCIO 1");
         } 
      
        else if((lectura == 3 || lectura == 4) && adja_carregada == false)
        System.out.println("Adjacencies no carregades, primer opcio 2");
        
        
        else if(lectura == 1){
            System.out.println("Vols path de Linux (1) o de Windows (2) o definir PATH (3) ?");
            String nom = sc.next();
            if (("1".equals(nom)) || ("Linux".equals(nom))) path_adjacencies_Linux();
            else if (("2".equals(nom)) || ("Windows".equals(nom))) path_adjacencies_Windows();
            else {
                System.out.println();
                System.out.println("DEFINEIX UN NOU PATH");
                String path = sc.next();
                canviar_path_adjacencies(path);
            }
            path_definit =true;
            System.out.println();
            System.out.println("Path definit :) ");
            }
        
        
        else if (lectura == 2){
         adjacencies = carregar_adjacencies();
         adja_carregada = true;
          System.out.println();
          System.out.println("Adjacencies carregades a MEMORIA :) ");
     }
        else if(lectura == 3){
            guardar_adjacencies(adjacencies);
            System.out.println();
          System.out.println("Adjacencies guardades a DISC  :) ");
        }
        else if(lectura == 4)  print_list_list(adjacencies);
        
        System.out.println();
        System.out.print("Prem la tecla Enter per continuar");
        sc.nextLine();
        sc.nextLine();
    }    
  }
}



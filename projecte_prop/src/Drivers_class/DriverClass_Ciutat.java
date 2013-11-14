/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;

import java.util.Scanner;
import projecte_prop.Ciutat;

/**
 *
 * @author pol
 */
public class DriverClass_Ciutat {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          boolean Sistema_definit = false;
          int lectura = 0;
          boolean Elemini = false;
      
     while(lectura != 4){   
        System.out.println();
        System.out.println("-------  Informació  -------");
        System.out.println();
        System.out.println();
        System.out.println("Tria una opció: ");
        System.out.println("1- Crea una nova Ciutat");
        System.out.println("2- Veure dades de la Ciutat");
        System.out.println("3- afegir ");
        System.out.println("4- Sortir");
        lectura = sc.nextInt();
     
    //comprovacions
          
     if (lectura >1 && !Elemini) System.out.println("Inicialitza Solució!!");
         
     //Opcions
     
     else if(lectura == 1){
         System.out.println("Entra un nom");
         String nom = sc.next();
         
     }
           
     else if(lectura == 2 ){
       
     }
     else if(lectura == 3 ){
        System.out.println("Afageix els valors del nou Tour:");
         
         int mida = sc.nextInt();
       
     }
        
     System.out.println();
     System.out.println();
     System.out.print("Prem la tecla Enter per continuar");
     sc.nextLine();
     sc.nextLine(); 
       
    }
  }
}

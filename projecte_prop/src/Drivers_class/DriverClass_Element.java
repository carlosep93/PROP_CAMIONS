/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;


import java.util.List;
import java.util.Scanner;
import Stubs.Element;

/**
 *
 * @author pol
 */
public class DriverClass_Element {
    
    
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          boolean Sistema_definit = false;
          int lectura = 0;
          
          Element elem = new Element();
          boolean Elemini = false;
     while(lectura != 6){   
        System.out.println();
        System.out.println("-------  Informació  -------");
        System.out.println();
        System.out.println();
     
       
         System.out.println("Tria una opció: ");
         System.out.println("1- Crea un nou element");
         System.out.println("2- Obtenir ID d'element");
         System.out.println("3- Obtenir boolean del element");
         System.out.println("4- Modificar boolean del element");
         System.out.println("5- Modificar id del element");
         System.out.println("6- Sortir");
         lectura = sc.nextInt();
     
    //comprovacions
          
     if (lectura >1 && !Elemini) System.out.println("Inicialitza element!!");
         
     
     
     //Opcions
     
     if(lectura == 1){
         elem = new Element();
         Elemini = true;
          System.out.println("Element creat");
     }
     else if(lectura == 2 ) System.out.println("L' ID d'element és " + elem.getID());
     else if(lectura == 3 ){
         String print = "false";
         if((elem.isEnabled())) print = "true";
         System.out.println("L'element està " + print);
     }
     
     else if(lectura == 4 ){
     System.out.println("Quin nou valor vols ? (enable (1) disable (2)");
     lectura = sc.nextInt();
     boolean newvalue = false;
     if(lectura == 1) newvalue = true;
     elem.modifyEnabled(newvalue);
    }
     else if (lectura == 5){
     System.out.println("Quin nou id vols?");
     lectura = sc.nextInt();
     elem.modifyid(lectura);    
     }
   
   
     System.out.println();
     System.out.println();
     System.out.print("Prem la tecla Enter per continuar");
     sc.nextLine();
     sc.nextLine(); 
    }
    
    
}

}
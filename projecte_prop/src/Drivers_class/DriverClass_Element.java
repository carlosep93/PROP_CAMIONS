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
          
          Element elem;
          
     while(lectura != 5){   
        System.out.println();
        System.out.println("-------  Informació  -------");
        System.out.println();
        System.out.println();
     
       
         System.out.println("Trua una opció: ");
         System.out.println("1- Crea un nou element");
       
        
         
          lectura = sc.nextInt();
     if(lectura == 1) elem = new Element();
     
        
    }
    
    
}

}
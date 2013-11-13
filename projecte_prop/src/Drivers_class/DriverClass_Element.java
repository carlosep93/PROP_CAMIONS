/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;

import static Controladors.CtrlDades.get_path_actual_load;
import static Controladors.CtrlDades.get_path_actual_store;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author helewt
 */
public class DriverClass_Element {
    
    
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
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
       
       
        
        
    }
    
    
}

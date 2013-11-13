
package Drivers_class;

import projecte_prop.Tour;
import java.util.Scanner;

/**
 *
 * @author josep
 */
public class DriverClass_Tour {
    
    public static void main(){
        Scanner sc = new Scanner(System.in);
        
        int lectura = 0;
        while(lectura != 5){   
          System.out.println();
          System.out.println("Tria una opció:");
          System.out.println("1 - Crear un Tour complet");
          System.out.println("2 - Crear un Tour parcial");
          System.out.println("3 - Afegeix Element");
          System.out.println("4 - Afegeix Element en la pos");
          System.out.println("5 - Contain Element");
          System.out.println("6 - Get Pos Element");
          System.out.println("7 - Remove Element");
          System.out.println("8 - Remove Element en la pos");
          System.out.println("9 - Get Element Pos");
          System.out.println("10 - Swap Elements");
          System.out.println("11 - Swap Element Pos");
          System.out.println("12 - Size");
          System.out.println("13 - getCost");
          System.out.println("14 - getID");
          System.out.println("15 - getData");
          System.out.println("16 - getNom");
          System.out.println();

          lectura=sc.nextInt();
        }  
    }
}

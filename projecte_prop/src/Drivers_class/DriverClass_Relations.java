/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;

import projecte_prop.Relations;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Carlos2
 */
public class DriverClass_Relations {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lectura = 0;
        Relations r = new Relations();
        while(lectura != 5) {
            System.out.println();
            System.out.println("------Informació--------");
            System.out.println("Tria una opció:");
            System.out.println("1- Llegir un nou Relations de teclat");
            System.out.println("2- Llegir un nou Relaions de fitxer");
            System.out.println("3- Esborrar un Punt");
            System.out.println("4- Tranformar Relation a matriu");
            System.out.println("5- Sortir");
            
            lectura = sc.nextInt();
            if (lectura == 1) {
                int n = sc.nextInt();
                r.readRelations(n);
                r.writeRelations();
            }
            else if (lectura == 2) {}
            else if (lectura == 3) {
                int aux = sc.nextInt();
                r.erase(aux);
                r.writeRelations();
            }
            else if (lectura == 4) {
                int [][] res = r.toMatrix();
                for (int i=0;i<res.length;++i) {
                    for (int j=0;j<res.length;++j) {
                        System.out.print(" "+res[i][j]);
                    }
                    System.out.println();
                }
            }
        }
    }
    
}

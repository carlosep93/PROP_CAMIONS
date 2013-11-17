/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;

import projecte_prop.Relations;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Carlos2
 */
public class DriverClass_Relations {
    
    private static void write(Relations r) {
        String s;
        for (int i=0;i<r.size();++i) {
            s = r.toString(i);
            System.out.println(s);
        }
    }
    
    public static void read(Relations r) {
        Scanner sc2 = new Scanner(System.in);
        int x = sc2.nextInt();
        for (int i=0;i<x;++i) {
            List<Integer> aux = new ArrayList <Integer>();
            for(int j=0; j<i;++j) {
                x = sc2.nextInt();
                aux.add(x);
            }
            aux.add(0);
            r.addElement(aux);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lectura = 0;
        Relations r = new Relations();
        while(lectura != 6) {
            System.out.println();
            System.out.println("------Informació--------");
            System.out.println("Tria una opció:");
            System.out.println("1- Llegir un nou Relations");
            System.out.println("2- Esborrar un Punt");
            System.out.println("3- Consultar una relació");
            System.out.println("4- Afegir un nou element");
            System.out.println("5- Tranformar Relation a matriu");
            System.out.println("6- Sortir");
            
            lectura = sc.nextInt();
            if (lectura == 1) {
                int n = sc.nextInt();
                r.readRelations(n);
                write(r);
            }
            else if (lectura == 2) {
                int aux = sc.nextInt();
                r.erase(aux);
                write(r);
                 int [][] res = r.toMatrix();
                for (int i=0;i<res.length;++i) {
                    for (int j=0;j<res.length;++j) {
                        System.out.print(" "+res[i][j]);
                    }
                }
            }    
            else if (lectura == 3) {
                int id1 = sc.nextInt();
                int id2 = sc.nextInt();
                System.out.println("Cost: "+r.getCost(id1, id2));
            }        
            else if (lectura == 4) {
                r.addElement(r.size());
                write(r);
            }
            else if (lectura == 5) {
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

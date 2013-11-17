/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;

/**
 *
 * @author joanbarrosogarrido
 */
import projecte_prop.TwoApp;
import projecte_prop.Tour;
import java.util.Scanner;
public class DriverClass_TwoApp {
    
        public static void main(String[] args) {
            Scanner sc = new Scanner (System.in);
            int opt = sc.nextInt();
            System.out.println("1 - Per fer una crida a Twoapp envia un 1");
            while (opt == 1) {
                System.out.println("entra una matriu, indica el tamany (es cuadrada)");
                System.out.println("Tamany de les files i les columnes: ");
                int size = sc.nextInt();
                int[][] M = new int[size][size];
                System.out.println("¿vols que el contingut de la matriu sigui aleatori? 1 --> si, 0 --> no");
                int r = sc.nextInt();
                if (r == 1) {
                    for (int i = 0; i < M.length; ++i) {
                        for (int j = i+1; j < M.length; ++j) {
                            if (i != j) {
                                M[i][j] = M[j][i] = (int)((Math.random() *100)+1);
                            }
                        }
                    }
                }
                else  {
                    System.out.println("entra les dades de la matriu:");
                    for (int i = 0; i < M.length; ++i) {
                        for (int ii = 0; ii < M.length; ++ii) {
                            M[i][ii] = M[ii][i] = sc.nextInt();
                        }
                    }
                }
                System.out.println("Amb aquestes dades, cridem a la funcio twoapp:");
                Tour t = TwoApp.Twoapp(M);
                for (int i = 0; i < M.length; ++i) {
                    System.out.print(t.getElementPos(i).getID() +" ");
                }
                opt = sc.nextInt();
            }
        }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;

/**
 *
 * @author Carlos2
 */
import projecte_prop.TspSA;
//import Stubs.Tour;
import projecte_prop.Tour;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
 
public class DriverClass_TspSA {
    private static void write(Tour t) {
        for(int i=0;i<t.size();++i) {
            System.out.print(" "+t.getElementPos(i).getID());
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        double temp;
        double cool;
        int p;
            
        System.out.println("Temperatura inicial:" );
        temp = sc.nextDouble();
        
        System.out.println("Factor de refredament:");
        cool = sc.nextDouble();
        
        System.out.println("Iteracions sense millorar solució abans de parar:");
        p = sc.nextInt();
        
        Tour T;
        T = TspSA.TspSA(temp, cool, p);
        
        for (int i=0;i<T.size();++i) {
            T.getElementPos(i).getNom();
        }
    }
    
}
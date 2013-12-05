/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;
import java.util.Scanner;
import projecte_prop.Punt;
import projecte_prop.City;
import java.util.ArrayList;
import projecte_prop.*;

/**
 *
 * @author joanbarrosogarrido
 */
public class CityGenerator {
    
    public static void main (String [] args) {
        City C = new City("joan");
        System.out.println("Escull numero de punts");
        Scanner sc = new Scanner(System.in);
        int qp = sc.nextInt();
        int x = 0;
        int y = 0;
        String s;
        for (int i = 0; i < qp; ++i) {
            ArrayList<Integer> ali = new ArrayList();
            s = Integer.toString(x);
            Punt P = new Punt(x,y,s);
            ++x;++y;
            for(int j = 0; j <i; ++j) {
                System.out.println("sus mertos");
                ali.add((int)(Math.random()*8+1));
            }
                C.addElement(P, ali);
        }
        Prim prim = new Prim();
        Tour T = prim.generateInitialSol(C);
        
    }
}

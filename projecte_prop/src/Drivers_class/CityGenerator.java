/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;
import java.util.Scanner;
import projecte_prop.Punt;
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
            s = Integer.toString(x);
            Punt P = new Punt(x,y,s);
            ++x;++y;
        }
        for (int i = 0; i < qp; ++i) {
            for(int j = 0; j < qp-1; ++j) {
                
            }
        }
    }
}

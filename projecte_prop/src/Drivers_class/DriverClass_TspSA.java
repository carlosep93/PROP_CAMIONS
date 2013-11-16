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
import projecte_prop.Ciutat;
import projecte_prop.Tour;
import projecte_prop.Relations;
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
        int lectura = 0;
        Ciutat c = new Ciutat("Barcelona");
        while (lectura != 3) {
            System.out.println("------Informació------");
            System.out.println("1-Afegir element a la ciutat");
            System.out.println("2-Calcular un camí");
            System.out.println("3-Sortir");
            
            lectura = sc.nextInt();
            if (lectura == 1) {
                int x;
                List<Integer> aux = new ArrayList<Integer>();
                for (int i=0;i<n;++i) {
                    x = sc.nextInt();
                    aux.add(x);
                }
                ++n;
                c.addElement(aux);
                write(c.get_Tour());
                
            }
            else if (lectura == 2) {
                System.out.println("Introdueix la temperatura del sistema: ");
                double temp = sc.nextDouble();
                System.out.println("Introdueix el factor de refredament: ");
                double cool = sc.nextDouble();
                System.out.println("Introdueix les iteracions sense millorar fins la parada: ");
                int p = sc.nextInt();
                System.out.println("Distancia inicial: "+ c.get_Tour().getCost());
                Tour t = TspSA.TspSA(temp,cool,c.get_Tour(),p);
                System.out.println("Distancia final: "+t.getCost());
                 write(t);
            }
        }
    }
    
}
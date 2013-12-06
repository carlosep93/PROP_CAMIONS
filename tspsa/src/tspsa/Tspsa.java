/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tspsa;

/**
 *
 * @author Carlos2
 */
public class Tspsa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Population p = new Population(1000,3);
        p.ompla_pesos_jp3();
        p.ompla_population_random();
        twopt.twoOpt(p);
        System.out.println("Pes: "+p.getCost_ruta(2));
        System.out.println("Pes: "+p.getCost_ruta(0)); 
    }
}

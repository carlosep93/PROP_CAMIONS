/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package camio;

import tsp_sa.Population;


public class Tsp_sa {
   
    public static double Acceptar(int energy, int newEnergy, double temp) {
        if (newEnergy < energy) {
            return 1.0;
        }
        return Math.exp ((energy - newEnergy)/ temp);
    }

    public static void main(String[] args) {
        //Temperatura inicial
        double temperature = 10000;
        //Factor por el que se enfria
        double enfriamiento = 0.003;
        Population pop = new Population(1000,3);// 1: best, 2: actual 3: new
        pop.ompla_pesos_jp3();
        pop.ompla_population_random();
        int cost = pop.getCost_ruta(2);
        System.out.println("Distancia inicial: "+ cost);
        //pop.escriu_population();
        //Population best = new Population(pop);
        while (temperature > 1) {
            //Population newpop = new Population(pop);
            //swap de posicions random
            int p1=(int)(Math.random()*newpop.tamany());
            int p2=(int)(Math.random()*newpop.tamany());
            newpop.swap(p1, p2);
            
            //calcula si s'accepta la nova solució
            int ener = pop.getCost_ruta();
            int newener = newpop.getCost_ruta();
            if (Acceptar(ener,newener,temperature)> Math.random()){
                pop = newpop;
            }
            //actualitza si cal la nova solució
            if (best.getCost_ruta() >= pop.getCost_ruta())
                best = pop;
            //Enfriamiento
            temperature *= 1-enfriamiento;
        }
        System.out.println("Distancia de la solucíó final "+best.getCost_ruta());
        System.out.println("Ruta final ");
        best.escriu_population();
    }
}
  
    

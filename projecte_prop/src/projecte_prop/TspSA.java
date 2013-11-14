/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;




public class TspSA {
    static double temperature;
    static double cooling;
   
    public static double Acceptar(int energy, int newEnergy) {
        if (newEnergy < energy) {
            return 1.0;
        }
        return Math.exp ((energy - newEnergy)/ temperature);
    }

    public static void TspSA(double temp, double cool,Ciutat c) {
        //Temperatura inicial
        temperature = temp;
        //Factor por el que se enfria
        cooling = cool;
        Cjt_tours ct = new Cjt_tours(3); //0: best, 1: actual, 2: new               
        for (int i=0;i<3;++i) {
            ct.addTour(i, c.get_Tour());
        }
        Relations r = new Relations();
        r = c.get_Relations();
        int cost = ct.getCostTour(cost);
        System.out.println("Distancia inicial: "+ cost);
        int tamany = ct
        while (temperature > 1) {
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

  
    

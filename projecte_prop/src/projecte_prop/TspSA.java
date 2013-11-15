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

    public static Tour TspSA(double temp, double cool,Ciutat c) {
        //Temperatura inicial
        temperature = temp;
        //Factor por el que se enfria
        cooling = cool;
        Tour t;
        CjtTours ct = new CjtTours(2); //0: best, 1: actual               
        for (int i=0;i<2;++i) {
            ct.addTour(i, c.get_Tour());
        }
        int best = ct.getTour(0).getCost();
        System.out.println("Distancia inicial: "+ best);
        int tamany = ct.sizeCjtTours();
        while (temperature > 1) {
            //int p1=(int)(Math.random()*tamany);
            //int p2=(int)(Math.random()*tamany);
            t = ct.getTour(1);
            Mutate.mutate3(t);
            
            //calcula si s'accepta la nova solució
            int ener = ct.getTour(1).getCost();
            int newener = t.getCost();
            if (Acceptar(ener,newener)> Math.random()){
                ct.addTour(1, t);
            }
            //actualitza si cal la nova solució
            if (best >  t.getCost()) {
                best = t.getCost();
                System.out.println("best > t "+best);
                ct.addTour(0,t);
            }    
            //Enfriamiento
            temperature *= 1-cooling;
        }
        return ct.getTour(0);
    }
}

  
    

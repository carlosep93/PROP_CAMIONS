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

    public static Tour TspSA(double temp, double cool,Tour t,int p) {
        //Temperatura inicial
        temperature = temp;
        //Factor por el que se enfria
        cooling = cool;
        CjtTours ct = new CjtTours(2); //0: best, 1: actual               
        for (int i=0;i<2;++i) {
            ct.addTour(i, t);
        }
        int n = 0;
        int best = ct.getTour(0).getCost();
        int tamany = ct.sizeCjtTours();
        while (temperature > 1 && n < p) {
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
                ct.addTour(0,t);
                n = 0;
            }
            else ++n;
            //Enfriamiento
            temperature *= 1-cooling;
        }
        return ct.getTour(0);
    }
}

  
    


package projecte_prop;

/*import Stubs.Tour;
import Stubs.CtrlDomini;
import Stubs.CjtTours;
import Stubs.Mutate;
import Stubs.TwoApp;*/

public class SA extends Local{
    static double temperature;
    static double cooling;
   
    public static double Acceptar(int energy, int newEnergy) {
        if (newEnergy < energy) {
            return 1.0;
        }
        return Math.exp ((energy - newEnergy)/ temperature);
    }

    public static Tour TspSA(Ciutat C, double temp, double cool,int p) {
        //Temperatura inicial
        temperature = temp;
        //Factor por el que se enfria
        cooling = cool;
        CjtTours ct = new CjtTours(3); //0: best, 1: actual
        Tour ti = TwoApp.Twoapp(C.get_Relations().toMatrix(),
                    C.get_Relations().Actius());
        for (int i=0;i<3;++i) {
            ct.addTourEmpty(i, ti);
        }
        int n = 0;
        int best = ct.getTour(0).getCost(C);
        int tamany = ct.sizeCjtTours();
        while (temperature > 1 && n < p) {
            Mutate.mutate3(C, ct.getTour(2));
            //calcula si s'accepta la nova solució
            int ener = ct.getTour(1).getCost(C);
            int newener = ct.getTour(2).getCost(C);
            if (Acceptar(ener,newener)> Math.random()){
                ct.copyTour(2,1);
            }
            else {
                ct.copyTour(1,2);
            }
            //actualitza si cal la nova solució
            if (best >  ct.getTour(1).getCost(C)) {
                best = ct.getTour(1).getCost(C);
                ct.copyTour(1,0);
                n = 0;
            }
            else ++n;
            //Enfriamiento
            temperature *= 1-cooling;
        }
        return ct.getTour(0);
    }
}

  
    

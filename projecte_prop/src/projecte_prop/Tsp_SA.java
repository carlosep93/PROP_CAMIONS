
package projecte_prop;

/*import Stubs.Tour;
import Stubs.CtrlDomini;
import Stubs.CjtTours;
import Stubs.Mutate;
import Stubs.TwoApp;*/

public class Tsp_SA extends Tsp{
    
    private double temperature;
    private double cooling;
    private int p;
    
    private City C;
    private InitialSolGenerator isg;
    private Mutate mut;
    
    public Tsp_SA(City C, InitialSolGenerator isg, Mutate mut, double temp,
            double cool, int p){
        this.C = C;
        this.isg = isg;
        this.mut = mut;
        this.temperature = temp;
        this.cooling = cool;
        this.p = p;
    }
    
   
    @Override public Tour calSol(){
        
        CjtTours ct = new CjtTours(3); //0: best, 1: actual, 2: nueva
        //genera una solució inicial i ompla el CjtTours amb aquesta

        Tour ti = isg.generateInitialSol();

        /*System.out.println("inicial <<<<<<<<<<<<<<<<<<<<<<<<<<");
        for(int i = 0; i < ti.size(); ++i){
             System.out.print(ti.getElementPos(i).getID() + "   ");
        }
        System.out.println();*/
        
        for(int i = 0; i < 3; ++i){
            ct.addTour(i,ti);
        }
        
        int n = 0;
        int best = ct.getCostTour(C,1);
        int tamany = ct.sizeCjtTours();
        while (temperature > 1 && n < p) {

            ti = mut.mutate(ct.getTour(2));

            /*System.out.println("Solucion despues del mutate");
            for(int i = 0; i < ti.size(); ++i){
                System.out.print(ti.getElementPos(i).getID() + "   ");
            }
            System.out.println();*/

            //calcula si s'accepta la nova solució
            int ener = ct.getCostTour(C,2);
            //igual esta es la causa del error
            int newener = ti.getCost(C);
            if (Acceptar(ener,newener)> Math.random()){
                ct.addTour(1,ti);
                ct.addTour(2, ti);
            }
            //actualitza si cal la nova solució
            if (best >  ct.getCostTour(C,1)) {
                best = ct.getCostTour(C,1);
                ct.addTour(0, ti);
                n = 0;
            }
            else ++n;
            //Enfriamiento
            temperature *= 1-cooling;
        }
        for(int i = 0; i < ct.getTour(0).size(); ++i){
             System.out.print(ct.getTour(0).getElementPos(i).getID() + "   ");
        }
        System.out.println();
        return ct.getTour(0);
    }
    
    private double Acceptar(int energy, int newEnergy) {
        if (newEnergy < energy) {
            return 1.0;
        }
        return Math.exp ((energy - newEnergy)/ temperature);
    }

}

  
    

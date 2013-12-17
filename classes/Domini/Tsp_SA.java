
package Domini;

public class Tsp_SA extends Tsp{
    
    private double temperature;
    private double cooling;
    private int p;
    
    private City C;
    private InitialSolGenerator isg;
    private Mutate mut;
    
    public Tsp_SA(InitialSolGenerator isg, Mutate mut, double temp,
            double cool, int p){
        this.isg = isg;
        this.mut = mut;
        this.temperature = temp;
        this.cooling = cool;
        this.p = p;
    }
    
   
    @Override public Tour calSol(City C){
        this.C = C;
        
        CjtTours ct = new CjtTours(3); //0: best, 1: actual, 2: nueva
        //genera una solució inicial i ompla el CjtTours amb aquesta

        Tour ti = isg.generateInitialSol(C);

        
        for(int i = 0; i < 3; ++i){
            ct.addTour(i,ti);
        }
        
        int n = 0;
        int best = ct.getCostTour(C,1);
        int tamany = ct.sizeCjtTours();
        while (temperature > 1 && n < p) {

            ti = mut.mutate(C, ct.getTour(2));


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
        return ct.getTour(0);
    }
    
    private double Acceptar(int energy, int newEnergy) {
        if (newEnergy < energy) {
            return 1.0;
        }
        return Math.exp (-1*((energy - newEnergy)/ temperature));
    }

}

  
    

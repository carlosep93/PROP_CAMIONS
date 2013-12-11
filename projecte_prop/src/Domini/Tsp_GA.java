
package Domini;

//quan usem el driver de TspGA:
/*  import Stubs.CjtTours;
    import Stubs.Tour;
    import Stubs.TournamentSelection;
    import Stubs.Crossover;
    import Stubs.Mutate;
    import Stubs.CtrlDomini;
    import Stubs.Ciutat;*/

public class Tsp_GA extends Tsp{
    private City C;
    //nombre de generacions sense variar per donar una solució per bona
    private int stopCondition;
    //max de generacions que es crearan
    private int nGeneracions;
    //numero de punts
    private int nPunts;
    //el valor de la quantitat de toure sobre la qual operarà
    public int nTours;
    //guarda el millor de cada generació a la posició de population
    private boolean elitism;
    //defineix la grandaria del subconjunt de pares del qual escollirem el millor
    private int tournamentSize;
    //rati deom mutació
    private double mutationRate;
    //
    private double mutationSwapProbability;
    
    private InitialSolGenerator isg;
    private TournamentSelection ts;
    private Crossover cross;
    private Mutate mut;
    
    public Tsp_GA(City C, int StopCondition, int NGeneracions, int NTours, InitialSolGenerator isg,
            boolean Elitism, TournamentSelection ts, Crossover cross, Mutate mut){
        this.C = C;
        this.stopCondition = StopCondition;
        this.nGeneracions = NGeneracions;
        this.nTours = NTours;
        this.elitism = Elitism;
        
        this.isg = isg;
        this.ts = ts;
        this.cross = cross;
        this.mut = mut;
    }
    
    
    //passant una condició de parada, el nombre de generacions màximes,
    //el nombre de tours, elitisme, rouletewheel_TS, tournamentSize(si rouletewh...==true => tour...=null)
    //edge_crossover, mutate2, mutationRate, mutationSwapProbability(si mutate_2==true)
    @Override public Tour calSol(){
        

        nPunts = C.getPunts().size();
        
        Tour t = isg.generateInitialSol();
        
        CjtTours pop = new CjtTours(nTours);
        for(int i = 0; i < nTours; ++i){
            pop.addTour(i, t);
            pop.getTour(i).swap((int)(Math.random()*nPunts), (int)(Math.random()*nPunts));
        }
        
        /*System.out.println("inicial <<<<<<<<<<<<<<<<<<<<<<<<<<");
        for(int i = 0; i < NTours; ++i){
            for(int ii = 0; ii < nPunts; ++ii){
                System.out.print(pop.getTour(i).getElementPos(ii).getID() + "   ");
            }
            System.out.println();
        }*/
        
        Tour Fittest = pop.getFittestTour(C);
        int Fitness = pop.getFitness(C); 
        int nCicles = 0;

        //iteracions per evolucionar la població
        for(int i = 1; i <= nGeneracions; ++i){
            //evoluciona la població en una generació
            
            pop = evolvePopulation(C, pop, ts, cross, mut);
                    
            //System.out.println("Generació " + i + "     Fitness: " + Fitness);

            //si fa tantes generacions que no ha cambiat el millor element de
            //la població com defineix "stopCondition" no crea més generacions
            if(Fitness > pop.getFitness(C)){
                Fittest = pop.getFittestTour(C);
                Fitness = pop.getFitness(C);
                nCicles = 0;
            }
            else{
                ++nCicles;
                if(nCicles == stopCondition) break;
            }
        }

        return Fittest;
    }
    
    
    private CjtTours evolvePopulation(City C, CjtTours pop, TournamentSelection ts, Crossover cross, Mutate mut){
        CjtTours newPopulation = new CjtTours(nTours);
        Tour T = new Tour();
        int elitismOffset = 0;
        if(elitism){
            newPopulation.addTour(0, pop.getFittestTour(C));
            elitismOffset = 1;
        }
        
        //Crossover population
        for(int i = elitismOffset; i < nTours; ++i){
            Tour parent1 = ts.selTour(pop);
            /*System.out.print("Parent1:");
            for(int ii = 0; ii < parent1.size(); ++ii){
                System.out.print(parent1.getElementPos(ii).getID());
            }
            System.out.println("        pes " +  parent1.getCost(C));*/
            
            Tour parent2 = ts.selTour(pop);
            /*System.out.print("Parent2:");
            for(int ii = 0; ii < parent2.size(); ++ii) System.out.print(parent2.getElementPos(ii).getID());
            System.out.println("        pes " +  parent2.getCost(C));*/
            
            T = cross.getChild(parent1, parent2);
            /*¿System.out.print("Child:");
            for(int ii = 0; ii < T.size(); ++ii) System.out.print(T.getElementPos(ii).getID());
            System.out.println("        pes " +  T.getCost(C));
            System.out.println();*/
            
            newPopulation.addTour(i, T);
        }
        //muta els nous tours de la població
        for(int i = elitismOffset; i < nTours; ++i){
            Tour t = mut.mutate(newPopulation.getTour(i));
            
            /*System.out.print("mutate: ");
            for(int ii = 0; ii < t.size(); ++ii) System.out.print(t.getElementPos(ii).getID() + "  ");
            System.out.println();*/
            newPopulation.addTour(i, t);
        }
        
        //retorna la nova població amb una generació més
        return newPopulation;
    }
}

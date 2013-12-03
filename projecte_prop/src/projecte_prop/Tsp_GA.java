
package projecte_prop;

//quan usem el driver de TspGA:
/*  import Stubs.CjtTours;
    import Stubs.Tour;
    import Stubs.TournamentSelection;
    import Stubs.Crossover;
    import Stubs.Mutate;
    import Stubs.CtrlDomini;
    import Stubs.Ciutat;*/

public class Tsp_GA extends Tsp{
    //nombre de generacions sense variar per donar una solució per bona
    private int stopCondition;
    //max de generacions que es crearan
    private int nGeneracions;
    //numero de punts
    private int nPunts;
    
    public int nTours = 20;              //el valor de la quantitat de toure sobre la qual operarà
    private boolean elitism = true;        //guarda el millor de cada generació a la posició de population
    private int tournamentSize = 5;         //defineix la grandaria del subconjunt de pares del qual escollirem el millor
    private double mutationRate = 0.015;    //rati deom mutació
    private double mutationSwapProbability = 0.90;
    
    
    //passant una condició de parada, el nombre de generacions màximes,
    //el nombre de tours, elitisme, rouletewheel_TS, tournamentSize(si rouletewh...==true => tour...=null)
    //edge_crossover, mutate2, mutationRate, mutationSwapProbability(si mutate_2==true)
    @Override public Tour calSol(City C, int StopCondition, int NGeneracions, int NTours, InitialSolGenerator isg,
            boolean Elitism, TournamentSelection ts, int TournamentSize, Crossover cross,
            Mutate mut, double MutationRate, double MutationSwapProbability, double temp, double cool, int p){
        
        stopCondition = StopCondition;
        nGeneracions = NGeneracions;
        nTours = NTours;
        elitism = Elitism;
        tournamentSize = TournamentSize;
        mutationRate = MutationRate;
        mutationSwapProbability = MutationSwapProbability;

        nPunts = C.getPunts().size();                                         
        
        
        CjtTours pop = new CjtTours(nTours);
        for(int i = 0; i < nTours; ++i){
            pop.addTour(i, isg.generateInitialSol(C));
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
                    
            System.out.println("Generació " + i + "     Fitness: " + Fitness);

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

        System.out.println("escric el tour final !!!!!!!!");
        for(int i = 0; i < Fittest.size(); ++i){
            System.out.print(Fittest.getElementPos(i).getID() + "  ");
        }
        System.out.println();
        //escriu la ruta més òptima
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
            Tour parent1 = ts.selTour(C, pop, tournamentSize);
            /*System.out.print("Parent1:");
            for(int ii = 0; ii < parent1.size(); ++ii){
                System.out.print(parent1.getElementPos(ii).getID());
            }
            System.out.println();*/
            
            Tour parent2 = ts.selTour(C, pop, tournamentSize);
            /*System.out.print("Parent2:");
            for(int ii = 0; ii < parent2.size(); ++ii) System.out.print(parent2.getElementPos(ii).getID());
            System.out.println();*/
            
            T = cross.getChild(C, parent1, parent2);
            /*System.out.print("Child:");
            for(int ii = 0; ii < T.size(); ++ii) System.out.print(T.getElementPos(ii).getID());
            System.out.println();*/
            newPopulation.addTour(i, T);
        }
        //muta els nous tours de la població
        for(int i = elitismOffset; i < nTours; ++i){
            Tour t = mut.mutate(C, newPopulation.getTour(i),mutationRate, mutationSwapProbability);
            
            /*System.out.print("mutate: ");
            for(int ii = 0; ii < t.size(); ++ii) System.out.print(t.getElementPos(ii).getID() + "  ");
            System.out.println();*/
            newPopulation.addTour(i, t);
        }
        
        //retorna la nova població amb una generació més
        return newPopulation;
    }
}

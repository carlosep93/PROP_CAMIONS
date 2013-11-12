
package camio;

import java.util.Scanner;

public class tspGA {
    //nombre de generacions sense variar per donar una solució per bona
    static int stopCondition;
    //max de generacions que es crearan
    static int nGeneracions;
    //numero de ciutats
    static int nCiutats;
    
    static int nTours = 20;              //el valor de la quantitat de toure sobre la qual operarà
    static boolean elitism = true;        //guarda el millor de cada generació a la posició de population
    static int tournamentSize = 5;         //defineix la grandaria del subconjunt de pares del qual escollirem el millor
    static double mutationRate = 0.015;    //rati deom mutació
    static double mutationSwapProbability = 0.90;
    
    public static void tspGA(int Scond, int nGen){
        stopCondition = Scond;
        nGeneracions = nGen;
        
        //inicialització de la variable per llegir de la entrada estàndart
        Scanner in = new Scanner(System.in);


        //System.out.println("Escriu el nombre de punts: ");    //lectura del teclat
        //int npunts = in.nextInt();

        nCiutats = 1000;         //pel joc de proves ja fet                                         

        Population pop = new Population(nCiutats, nTours);

        pop.ompla_pesos_jp3();
        pop.ompla_population_random();
        twopt.twoOpt(pop);
        pop.ompla_pesosRutes();
        int Fittest = pop.getFittest();
        int Fitness = (int)pop.getFitness(Fittest); 
        System.out.println("Generació 0     Fitness: " + Fitness);

        int nCicles = 0;
        int bFittest = Fittest;
        int bFitness= Fitness;

        //iteracions per evolucionar la població
        for(int i = 1; i <= nGeneracions; ++i){
            //evoluciona la població en una generació
            envolvePopulation(pop);
                    
            //obtè el millor element de la població i el seu cost total
            Fittest = pop.getFittest();
            Fitness = (int)pop.getFitness(Fittest);
            System.out.println("Generació " + i + "     Fitness: " + Fitness);

            //si fa tantes generacions que no ha cambiat el millor element de
            //la població com defineix "stopCondition" no crea més generacions
            if(bFitness > Fitness){
                bFittest = Fittest;
                bFitness = Fitness;
                nCicles = 0;
            }
            else{
                ++nCicles;
                if(nCicles == stopCondition) break;
            }
        }

        //escriu la ruta més òptima
        //System.out.println("La ruta final és: ");
        //pop.escriu_ruta(Fittest);

    }
    
    
    private static void envolvePopulation(Population pop){
        Population newPopulation = new Population(nCiutats, nTours);
        
        int elitismOffset = 0;
        if(elitism){
            newPopulation.addNewTour(0, pop.getTour(pop.getFittest()));
            elitismOffset = 1;
        }
        
        //Crossover population
        for(int i = elitismOffset; i < nTours; ++i){
            int parent1[], parent2[];
            parent1 = tournamentSelection.tournamentSelection_roulettewheel(pop);
            parent2 = tournamentSelection.tournamentSelection_roulettewheel(pop);
            
            
            /*System.out.println("Pare 1: ");
            for(int ii = 0; ii < npunts; ++ii){
                System.out.print(" " + parent1[ii]);
            }
            System.out.println("");
            
            
            System.out.println("Pare 1: ");
            for(int ii = 0; ii < npunts; ++ii){
                System.out.print(" " + parent1[ii]);
            }
            System.out.println("");*/
            
            
            newPopulation.addNewTour(i, crossover.crossover_edgeRecombination(parent1,parent2));   
        }
        
        for(int i = elitismOffset; i < nTours; ++i){
            newPopulation.addNewTour(i, mutate.mutate2(newPopulation.getTour(i),mutationRate, mutationSwapProbability));
        }
        pop = newPopulation;
        pop.ompla_pesosRutes();
    }
}

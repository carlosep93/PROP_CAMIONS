/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_ga;

import java.util.Scanner;       //importa llibreries per poder llegir de teclat

public class Population {

    int npunts;
    int pesos[][];
    int population[][];
    int pes_ruta[];
    
    int numTours = 50;              //el valor de la quantitat de toure sobre la qual operarà
    boolean elitism = true;        //guarda el millor de cada generació a la posició de population
    int tournamentSize = 5;         //defineix la grandaria del subconjunt de pares del qual escollirem el millor
    double mutationRate = 0.015;    //rati de mutació
    
    
    Scanner in = new Scanner(System.in);
    
    public Population(int npunts) {
        this.npunts=npunts;
        pesos = new int[npunts][npunts];
        population = new int[numTours][npunts];
        pes_ruta = new int[numTours];
    }
    
    public void ompla_pesos(){
        

        System.out.println("Escriu els valors dels costos d'anar del punt: ");
        for(int i=0;i<npunts;++i){
            for(int ii=0;ii<npunts;++ii){
                System.out.print(i + ", " + ii + ": ");
                pesos[i][ii]=in.nextInt();
                System.out.println();
            }
        }
    }
    
    public void ompla_population_random(){
        
        //omplim la population
        for(int i=0;i<numTours;++i){
            for(int ii=0;ii<npunts;++ii){
                population[i][ii]=ii;
            }
        }
        
        //es fa un suffle de la population inicial
        mutationRate = 0.4;
        for(int i = 0; i < 10; ++i){
            for(int ii = 0; ii < numTours; ++ii){
                population[ii] = mutate(population[ii]);
            }
        }
        mutationRate = 0.015;
    }
    
    public int getFittest(){
        int Fittest=0;
        int pes_Fittest = pes_ruta[0] = getCost_ruta(0);
        for(int i = 1; i < numTours; ++i){
            pes_ruta[i] = getCost_ruta(i);
            if(pes_ruta[i] < pes_Fittest){
                pes_Fittest=pes_ruta[i];
                Fittest=i;
            }
        }
        return Fittest;
    }
    
    private int getCost_ruta(int ruta){
        int cost=0;
        int p, p2;
        for(int i = 0; i < npunts-1; ++i){
            p = population[ruta][i];
            p2 = population[ruta][i+1];
            cost+=pesos[p][p2];
        }
        return cost;
    }
    
    public int getFitness(int Fittest){
        return pes_ruta[Fittest];
    }
    
    public void envolvePopulation(){
        int newpopulation[][] = new int[numTours][npunts];
        
        int elitismOffset = 0;
        if(elitism){
            newpopulation[0] = population[getFittest()];
            elitismOffset = 1;
        }
        
        //Crossover population
        for(int i = elitismOffset; i < numTours; ++i){
            int parent1[], parent2[];
            parent1 = tournamentSelection_roulettewheel();
            parent2 = tournamentSelection_roulettewheel();
            
            
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
            
            
            newpopulation[i]=crossover(parent1,parent2);
        }
        
        for(int i = elitismOffset; i < numTours; ++i){
            newpopulation[i] = mutate(newpopulation[i]);
        }
        population = newpopulation;
    }
    
    private int[] mutate(int tour[]){
        for(int i = 0; i < npunts; ++i){
            if(Math.random() <= mutationRate){
                //trobar una altra posició random per fer switch
                int punt2 = (int)(Math.random() * npunts);
                
                //un switch de les dues posicions
                int aux = tour[punt2];
                tour[punt2] = tour[i];
                tour[i] = aux;
            }
        }
        return tour;
    }
    
    private int[] tournamentSelection(){
        int Fittest, Fitness; Fittest = Fitness = 0;
        boolean ini = false;
        for(int i = 0; i < tournamentSize; ++i){
            int randomId = (int)(Math.random() * numTours);
            if(!ini){
                Fittest = randomId;
                Fitness = getFitness(randomId);
                ini=true;
            }
            else if(Fitness > getFitness(randomId)){
                Fittest = randomId;
                Fitness = getFitness(randomId);
            }
        }
        return population[Fittest];
    }
    
    private int[] tournamentSelection_roulettewheel(){
        int totalFitness, acom; int point;
        totalFitness = total_fitness();
        acom = (int)Math.random() * totalFitness;
        point = (int)Math.random() * numTours;
        while(acom > 0){
            ++point; if(point >= numTours) point = 0;
            acom -=  pes_ruta[point];
        }
        return population[point];
    }
    
    private int total_fitness(){
        int totalFitness = 0;
        for(int i = 0; i < numTours; ++i) totalFitness += pes_ruta[i];
        return totalFitness;
    }
    
    private int[] crossover(int[] parent1, int[] parent2){
        int child[] = new int[npunts];
        
        int startPos = (int)(Math.random() * npunts);
        int endPos = (int)(Math.random() * npunts);
        
        for(int i = 0; i < npunts; ++i){
            child[i]=-1;
            if(startPos < endPos && i > startPos && i < endPos){
                child[i] = parent1[i];
            }
            else if(startPos > endPos){
                if(!(i < startPos && i > endPos)){
                    child[i] = parent1[i];
                }
            }
        }
        
        for(int i = 0; i < npunts; ++i){
            if(!containsCity(child,i)){
                for(int ii = 0; ii < npunts; ++ii){
                    if(child[ii] == -1){
                        child[ii] = i;
                        break;
                    }
                }
            }
        }
        
        return child;
    }
    
    private boolean containsCity(int child[], int punt){
        boolean conte = false;
        for(int i = 0; i < npunts && !conte; ++i){
            if(child[i]==punt) conte = true;
        }
        return conte;
    }
    
    public void escriu_pesos(){
        //escriu els pesos
        for(int i=0;i<npunts;++i){
            for(int ii=0;ii<npunts;++ii){
                System.out.print(" "+pesos[i][ii]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void escriu_population(){
        //escriu la population
        for(int ii=0;ii<npunts;++ii){
            for(int i=0;i<numTours;++i){
                System.out.print(" "+population[i][ii]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void escriu_ruta(int ruta){
        for(int i = 0; i < npunts; ++i){
            System.out.println(" " + population[ruta][i]);
        }
    }
    
    
    //joc de proves
    public void ompla_pesos_jp(){
        pesos[0][0] = 0;
        pesos[0][1] = 5;
        pesos[0][2] = 10;
        pesos[0][3] = 11;
        pesos[0][4] = 5;
        pesos[0][5] = 12;
        
        pesos[1][0] = 5;
        pesos[1][1] = 0;
        pesos[1][2] = 11;
        pesos[1][3] = 5;
        pesos[1][4] = 12;
        pesos[1][5] = 13;
        
        pesos[2][0] = 10;
        pesos[2][1] = 11;
        pesos[2][2] = 0;
        pesos[2][3] = 12;
        pesos[2][4] = 5;
        pesos[2][5] = 5;
        
        pesos[3][0] = 10;
        pesos[3][1] = 5;
        pesos[3][2] = 11;
        pesos[3][3] = 0;
        pesos[3][4] = 12;
        pesos[3][5] = 5;
        
        pesos[4][0] = 5;
        pesos[4][1] = 10;
        pesos[4][2] = 5;
        pesos[4][3] = 11;
        pesos[4][4] = 0;
        pesos[4][5] = 12;
        
        pesos[5][0] = 10;
        pesos[5][1] = 11;
        pesos[5][2] = 5;
        pesos[5][3] = 5;
        pesos[5][4] = 12;
        pesos[5][5] = 0;
        
    }
    
    public void ompla_pesos_jp2(){
        for (int i = 0; i < 100; ++i){
            for(int ii = 0; ii <= i; ++ii){
                if(i == ii) pesos[i][ii] = 0;
                else{
                    if(i%2 == 0){ //parell
                        pesos[i][ii] = pesos[ii][i] = 5;
                    }
                    else{
                        if(ii%2 == 0){
                            pesos[i][ii] = pesos[ii][i] = 10;
                        }
                        else pesos[i][ii] = pesos[ii][i] = 20;
                    }
                }
            }
        } 
    }
    
    public void ompla_pesos_jp3(){
        for (int i = 0; i < 1000; ++i){
            for(int ii = 0; ii <= i; ++ii){
                if(i == ii) pesos[i][ii] = 0;
                else{
                    if(i%2 == 0){ //parell
                        pesos[i][ii] = pesos[ii][i] = 5;
                    }
                    else{
                        if(ii%2 == 0){
                            pesos[i][ii] = pesos[ii][i] = 10;
                        }
                        else pesos[i][ii] = pesos[ii][i] = 20;
                    }
                }
            }
        } 
    }
    
}
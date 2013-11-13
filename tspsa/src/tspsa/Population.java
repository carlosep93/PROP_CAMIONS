
package tspsa;

import java.util.Scanner;       //importa llibreries per poder llegir de teclat

public class Population {

    int npunts;
    int pesos[][];
    int population[][];
    double pes_ruta[];
    double TotalFitness = 0;
    int nTours;
    
    
    Scanner in = new Scanner(System.in);
    
    public Population(int npunts, int nTours) {
        this.npunts = npunts;
        this.nTours = nTours;
        pesos = new int[npunts][npunts];
        population = new int[this.nTours][npunts];
        pes_ruta = new double[this.nTours];
    }
    
    public int[] getTour(int pos){
        return population[pos];
    }
    
    public void addNewTour(int pos, int[] Tour){
        population[pos] = Tour;
    }
    
    public int getSize() {
        return npunts;
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
    //Funciones para el sa y el 2opt
    public void clonevec(int x, int y) {
        //Copia el recorrido x en el recorrido y
        for (int i=0;i<npunts;++i) {
            population[y][i] = population[x][i];
        }
    }
    
    public void twoSwap(int i,int j,int p) {
        int aux = i+(j-i)/2;
        for (int k=i;k<aux;++k) {
            int aux2 = population[p][i];
            population[p][i] = population[p][j];
            population[p][j] = aux2;
            ++i;
            --j;
        }
    }
    
    public void ompla_population_random(){
        
        //omplim la population
        for(int i=0;i<nTours;++i){
            for(int ii=0;ii<npunts;++ii){
                population[i][ii]=ii;
            }
        }
    }    
    /*    
        //es fa un suffle de la population inicial
        mutationRate = 0.4;
        for(int i = 0; i < 10; ++i){
            for(int ii = 0; ii < numTours; ++ii){
                population[ii] = mutate(population[ii]);
            }
        }
        mutationRate = 0.015;
    }
    
    public void ompla_pesosRutes(){
        TotalFitness = 0;
        for(int i = 0; i < numTours; ++i){
            pes_ruta[i] = 1/(double)getCost_ruta(i);
            TotalFitness += pes_ruta[i];
        }
    }
    
    */
    public double getCostRuta(int ruta){
        return pes_ruta[ruta];
    }
    
    public int getCost_ruta(int ruta){
        int cost=0;
        int p, p2;
        for(int i = 0; i < npunts-1; ++i){
            p = population[ruta][i];
            p2 = population[ruta][i+1];
            cost+=pesos[p][p2];
        }
        return cost;
    }
    
    private int getCost_ruta2(int[] Tour){
        int cost=0;
         int p, p2;
        for(int i = 0; i < npunts-1; ++i){
             cost+=pesos[Tour[i]][Tour[i+1]];
        }
        return cost;
        
        
    }
    
    /*    
    public int getFittest(){
        int Fittest = 0;
        double pes_Fittest = pes_ruta[0];
        for(int i = 1; i < numTours; ++i){
            if(pes_ruta[i] > pes_Fittest){
                pes_Fittest = pes_ruta[i];
                Fittest = i;
            }
        }
        return Fittest;
    }
    
    public double getFitness(int Fittest){
        return 1/pes_ruta[Fittest];
    }

    public double getTotalFitness(){
        return TotalFitness;
    }
    */
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
            for(int i=0;i<nTours;++i){
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
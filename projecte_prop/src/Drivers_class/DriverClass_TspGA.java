
package Drivers_class;
/**
 *
 * @author josep
 */

import projecte_prop.Tsp_GA;
import java.util.Scanner;
import projecte_prop.Tour;
//import Stubs.Tour;

public class DriverClass_TspGA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int StopCondition, NGeneracions, NTours, TournamentSize;
        double MutationRate, MutationSwapProbability;
        boolean Elitism, Rouletewheel_TS, Edge_crossover, Mutate2;
        
        System.out.println("Stop Condition:");
        StopCondition = sc.nextInt();
        
        System.out.println("NGeneracions:");
        NGeneracions = sc.nextInt();
        
        System.out.println("NTours:");
        NTours = sc.nextInt();
        
        System.out.println("Elitism:");
        Elitism = sc.nextBoolean();
        
        System.out.println("Rouletewheel_TS:");
        Rouletewheel_TS = sc.nextBoolean();
        
        if(!Rouletewheel_TS){
            System.out.println("TournamentSize:");
            TournamentSize = sc.nextInt();
        }
        else TournamentSize = 0;
        
        System.out.println("Edge_crossover:");
        Edge_crossover = sc.nextBoolean();
        
        System.out.println("MutationRate:");
        MutationRate = sc.nextDouble();
        
        System.out.println("Mutate2:");
        Mutate2 = sc.nextBoolean();
        
        if(Mutate2){
            System.out.println("MutationSwapProbability");
            MutationSwapProbability = sc.nextDouble();
        }
        else MutationSwapProbability = 0;
        
        Tour T;
        T = Tsp_GA.TspGA(StopCondition, NGeneracions, NTours, Elitism, Rouletewheel_TS, TournamentSize, 
        Edge_crossover, Mutate2, MutationRate, MutationSwapProbability);
        
        for(int i = 0; i < T.size(); ++i){
            T.getElementPos(i).getNom();
        }
    }
}
  
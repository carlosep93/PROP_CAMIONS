
package projecte_prop;

public abstract class Tsp {

    public abstract Solution calSol(Ciutat C, int StopCondition, int NGeneracions, int NTours, InitialSolGenerator isg,
            boolean Elitism, boolean Rouletewheel_TS, int TournamentSize, boolean Edge_crossover,
            boolean Mutate2, double MutationRate, double MutationSwapProbability);
    
    public abstract Tour TspSA(Ciutat C, double temp, double cool,int p);
}

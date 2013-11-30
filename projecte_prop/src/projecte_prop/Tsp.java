
package projecte_prop;

public abstract class Tsp {

    public abstract Solution calSol(Ciutat C, int StopCondition, int NGeneracions, int NTours, InitialSolGenerator isg,
            boolean Elitism, TournamentSelection ts, int TournamentSize, Crossover cross,
            Mutate mut, double MutationRate, double MutationSwapProbability, double temp, double cool, int p);

}

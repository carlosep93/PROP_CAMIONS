
package projecte_prop;

public abstract class Crossover{
    
    public abstract Tour getChild(Ciutat C, Tour child1, Tour child2);
    
    public abstract Tour getChild(Tour parent1, Tour parent2);
}


package projecte_prop;

import java.util.List;

public abstract class InitialSolGenerator{
    
    public abstract Tour generateInitialSol(int[][] M, List<Integer> id);
    
    public abstract Tour generateInitialSol(Ciutat C);
    
}


package projecte_prop;

import java.util.List;

public class InitialSolGenerator_Random extends InitialSolGenerator{
    
    /** @brief  Procès que ompla el CjtTours
    \pre    El CjtTours és buit i la ciutat del CtrlDomini contè algún Element
    \post   S'ha omplert el CjtTours pop amb els Elements de la Ciutat del CtrlDomini, i després s'han desordenat de manera aleatòria
    */
    @Override public Tour generateInitialSol(Ciutat C){
        //omplim la population
        Tour t = new Tour(C.get_Tour());

        //es fa un suffle de la population inicial
        for(int i = 0; i < t.size()/4; ++i){
            t.swap((int)(Math.random() * t.size()), (int)(Math.random() * t.size()));
        }
        return t;
    }
    
    @Override public Tour generateInitialSol(int[][] M, List<Integer> id){
        return null;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package camio;

/**
 *
 * @author Carlos2
 */
public class twopt {
    public Population_sa twoOpt(Population_sa p) {
        p.ompla_population_random();
        Population_sa pnew = new Population_sa(p);
        int best = p.getCost_ruta();
        for (int i=0; i < p.tamany()-1;++i) {
            for (int j=i+1;j<p.tamany();++j) {
                pnew.twoSwap(p,i,k);
                if (pnew.getCost_ruta() < best) {
                    p = pnew;
                    best = pnew.getCost_ruta();
                }    
            }
        }
        return p;
    } 
    
}

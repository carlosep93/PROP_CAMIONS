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
    public Population twoOpt(Population p) {
        int best = p.getCost_ruta(2);
        for (int i=0; i < p.getSize()-1;++i) {
            for (int k = i+1;k <p.getSize();++ k) {
                pnew.twoSwap(2,i,k);
                if (pnew.getCost_ruta() < best) {
                    p.clonevec
                    best = pnew.getCost_ruta();
                }    
            }
        }
        return p;
    } 
    
}

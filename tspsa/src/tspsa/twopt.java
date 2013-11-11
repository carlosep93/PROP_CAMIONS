/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tspsa;

/**
 *
 * @author Carlos2
 */
public class twopt {
    public static void twoOpt(Population p) {
        int best = p.getCost_ruta(2);
        for (int i=0; i < p.getSize()-1;++i) {
            for (int k = i+1;k <p.getSize();++ k) {
                p.twoSwap(i,k,2);
                if (p.getCost_ruta(2) < best) {
                    best = p.getCost_ruta(2);
                }    
            }
        }
    } 
    
}

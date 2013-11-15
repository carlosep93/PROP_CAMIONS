/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;

/**
 *
 * @author joanbarrosogarrido
 */
public class TwoApp {
    
    
        public static int[] Twoapp(int[][] M) {
        int [][] mst = new int[M.length][M.length];
        mst = Mst.prim(M);
        
        int [] etour = new int[mst.length];
        return etour;
    }
}

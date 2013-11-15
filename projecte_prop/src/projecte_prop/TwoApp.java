/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author joanbarrosogarrido
 */
public class TwoApp {
    
    
        public static int[] Twoapp(int[][] M) {
        int [][] mst = new int[M.length][M.length];
        mst = Mst.prim(M);
        List<Integer> l = new ArrayList<Integer>();
        int[] etour = getEtour(mst,l);
        Stack s = new Stack();
        int [] etour = new int[mst.length];
        return etour;
    }
        
        private int[] getEtour (int[][] mst,List<Integer> L) {
            
        }
}

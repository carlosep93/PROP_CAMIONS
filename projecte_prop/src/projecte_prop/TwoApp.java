/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author joanbarrosogarrido
 */
public class TwoApp {
    
    
    public static Tour Twoapp(int[][] M) {
        int [][] mst = Mst.prim(M);
        List<Integer> l = new ArrayList<Integer>();
        getEpath(mst,l,0);
        return getEtour(mst.length,l);
    }
        
    private static void getEpath(int[][] mst,List<Integer> l, int pos) {
        if (mst[pos][pos] != -1) {
            l.add(pos);
            if(child(mst[pos])) {
                for(int i = 0; i < mst.length ; ++i) {
                    if(mst[pos][i] > 0) {
                        mst[pos][i] = 0;
                        getEpath(mst,l,i);
                    }
                }
            }
        }
    }
    private static boolean child(int[] mst) {
        for(int i = 0; i < mst.length ;++i) {
            if (mst[i] > 0) return true;
        }
        return false;
    }
    
        private static Tour getEtour(int size,List<Integer> l) {
        System.out.println("el camino final de 2 app es:");
        Tour t = new Tour();
        Element E;
        boolean[] visited = new boolean[size];
        if (visited[0] == false) System.out.println("me inicializo en falso!");
        while (!l.isEmpty()) {
            if (!visited[l.get(0)]) {
                E = new Element(l.get(0));
                t.addElement(E);
                visited[l.get(0)] = true;
                l.remove(0);
            }
            else {
                l.remove(0);
            }
        }
        return t;
    }
}

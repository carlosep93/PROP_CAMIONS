
package projecte_prop;

import java.util.List;
import java.util.ArrayList;

public class InitialSolGenerator_TwoApp extends InitialSolGenerator{
    
    
    public Solution generateInitialSol(City C, int[][] M, List<Integer> id){
        List<Element> le = C.getElements();
        List<List<Integer>> llr = C.getAdjacency();
        Tour T = new Tour();
        
        
        
        /*int [][] mst = Mst.prim(M);

    @Override public Tour generateInitialSol(Ciutat C, int[][] M, List<Integer> id){
        int [][] mst = Mst.prim(M);
        List<Integer> l = new ArrayList<Integer>();
        getEpath(mst,l,0);
        return getEtour(mst.length,l,id);
    }
        
    private void getEpath(int[][] mst,List<Integer> l, int pos) {
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
    private boolean child(int[] mst) {
        for(int i = 0; i < mst.length ;++i) {
            if (mst[i] > 0) return true;
        }
        return false;
    }
    
    private Tour getEtour(int size,List<Integer> l,List<Integer> id) {
        Tour t = new Tour();
        Punt E;
        int pos;
        boolean[] visited = new boolean[size];
        while (!l.isEmpty()) {
            if (!visited[l.get(0)]) {
                E = new Punt(id.get(l.get(0)));
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

    public Tour generateInitialSol(Ciutat C){
        return null;
    }
}
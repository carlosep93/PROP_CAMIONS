
package projecte_prop;

import java.util.List;
import java.util.ArrayList;

public abstract  class InitialSolGenerator_TwoApp extends InitialSolGenerator{
    
    @Override
    public abstract Tour generateInitialSol(City C);
        
        
    public void getEpath(ArrayList<ArrayList<Integer>> mst,List<Integer> l, int pos) {
        l.add(pos);
        if(child(mst.get(pos))) {
            for(int i = 0; i < mst.size() ; ++i) {
                if(mst.get(pos).get(i) > 0) {
                    mst.get(pos).set(i,0);
                    getEpath(mst,l,i);
                }
            }
        }
    }
    private boolean child(ArrayList<Integer> mst) {
        for(int i = 0; i < mst.size() ;++i) {
            if (mst.get(i) > 0) return true;
        }
        return false;
    }
    
    public Tour getTour(int size,List<Integer> l,ArrayList<Punt> lp) {
        Tour t = new Tour();
        Punt P;
        boolean[] visited = new boolean[size];
        while(!l.isEmpty()) {
            if(!visited[l.get(0)]) {
                P = lp.get(l.get(0));
                t.addElement(P);
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
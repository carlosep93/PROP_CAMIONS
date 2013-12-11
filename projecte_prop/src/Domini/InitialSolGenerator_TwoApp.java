package Domini;

import java.util.List;
import java.util.ArrayList;

public  class InitialSolGenerator_TwoApp extends InitialSolGenerator{
    
   // private ArrayList<ArrayList<Integer> > mst;
    private Mst mst;
    
    public InitialSolGenerator_TwoApp(Mst mst) {
        this.mst = mst;
    }
    
    @Override
    public Tour generateInitialSol(){
        ArrayList<List<Integer>> tree = mst.getMST();
        List<Integer> path = new ArrayList<Integer>();
        City C;
        C = mst.getCity();
        int ini = 0;
        for(int i = 0; i < C.size(); ++i) {
            if (child(tree.get(i))){
                ini = i;
                break;
            }
        }
        getEpath(tree,path,ini);
        System.out.println();
        ArrayList<Integer> active = C.getEnabledInt();
        boolean[] usable = new boolean[C.size()];
        for(int i = 0; i < active.size(); ++i) {
            usable[active.get(i)] = true;
        }
        Tour T = getTour(usable,path,C.getPunts());
        return T;
        
    }
        
        
    public void getEpath(ArrayList<List<Integer>> mst,List<Integer> l, int pos) {
        l.add(pos);
        System.out.print(" " + pos);
        if(child(mst.get(pos))) {
            for(int i = 0; i < mst.size() ; ++i) {
                if(mst.get(pos).get(i) > 0) {
                    mst.get(pos).set(i,0);
                    getEpath(mst,l,i);
                }
            }
        }
    }
    private boolean child(List<Integer> mst) {
        for(int i = 0; i < mst.size() ;++i) {
            if (mst.get(i) > 0) return true;
        }
        return false;
    }
    
    public Tour getTour(boolean[] usable,List<Integer> l,ArrayList<Punt> lp) {
        Tour t = new Tour();
        Punt P;
        while(!l.isEmpty()) {
            if(usable[l.get(0)]) {
                P = lp.get(l.get(0));
                t.addElement(P);
                usable[l.get(0)] = false;
                System.out.print(" " + l.get(0));
                l.remove(0);
            }
            else {
                l.remove(0);
            }
        }
        return t;
    }
}
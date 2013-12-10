/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author joanbarrosogarrido
 */
public class Mst_Prim extends Mst {

    private City C;
    
    public Mst_Prim(City C) {
        this.C = C;
    }
     
    @Override
    public ArrayList<List<Integer>> getMST(){
        ArrayList<List<Integer>> mst = new ArrayList<List<Integer>>();
        List<Punt> lp = C.getPunts();
        List<Integer> aux = new ArrayList<Integer>();
        for(int i = 0;i < C.size();++i) {
        List<Integer> row = new ArrayList<Integer>();
        mst.add(row);
            for(int j = 0; j < C.size();++j) {
                mst.get(i).add(0);
            }
        }
        ArrayList<ArrayList<Integer>> mat = C.getAdjacency();
        getMST(mst,C);
        //proba de mst
        for(int i = 0;i < mst.size();++i) {
            for(int j = 0; j < mst.size();++j) {
                System.out.print(" "+mst.get(i).get(j));
            }
            System.out.println();
        }
        return mst;
    }
    
    private static void getMST(List<List<Integer>> mst, City C) {
        
        ArrayList<Punt> lp = C.getPunts();
        ArrayList<ArrayList<Integer>> lli = C.getAdjacency();
        List<Relation> lr = new ArrayList<Relation>();
        PQsort sort = new PQsort();
        PriorityQueue<Relation> pqr = new PriorityQueue(1,sort);
        boolean[] visited = new boolean[lp.size()];
        int nextdot = 0;
        for(int i = 0; i < C.size(); ++i) System.out.println("el elemento "+ i+ " esta "+ C.isEnabled(i));
        for(int i = 0; i < C.size(); ++i) {
            if (nextdot == -1) break;
            System.out.println(nextdot);
            if (C.isEnabled(nextdot)) {
                addPQ(pqr,lli.get(nextdot),lp,nextdot);
                if (!allvisited(visited)){
                    nextdot = addmst(pqr,visited,mst);
                }
            }
            else {
                if (nextdot == 0) nextdot = i;
                ++nextdot;
            }
        }
    }
    
    private static void addPQ(PriorityQueue<Relation> pqr,ArrayList<Integer> li,ArrayList<Punt> lp, int pos) {
        for(int i = 0; i < li.size(); ++i) {
            if (i != pos && lp.get(i).isEnabled()) {  //si la adjacencia no es amb si mateix, i el put és habilitat
                   pqr.add(new Relation(pos,i,li.get(i)));
            }
        }
    }
    
    private static int addmst(PriorityQueue<Relation> pqr, boolean [] visited, List<List<Integer>> mst) {
        boolean done = false;
        while (!done && pqr.size() > 0){ 
            Relation R = pqr.poll();
            if (!visited[R.getID2()]) {
                System.out.println();
                mst.get(R.getID1()).remove(R.getID2());
                mst.get(R.getID1()).add(R.getID2(),R.getValue());
                mst.get(R.getID2()).set(R.getID1(),R.getValue());
                visited[R.getID1()] = true;
                visited[R.getID2()] = true;
                done = true;
            }
        if (done) return R.getID2();
        }
        return -1;
    }

    private static boolean allvisited(boolean[] visited) {
        boolean v = true;
        for(int i = 0; i < visited.length && v; i++) {     //salimos si llegamos al final o vemos que no se ha visitado alguno.
            if (!visited[i]) v = visited[i];       //si no esta visitado, v toma el valor y por tanto se sale del loop.
         }
        return v; // si se ha salido del loop será  falso, si se ha recorrido entero y el último no era, será true.
    }
    
    @Override
    public City getCity(){
        return C;
    }
}


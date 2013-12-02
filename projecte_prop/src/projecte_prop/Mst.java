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
public class Mst extends InitialSolGenerator_TwoApp {

    @Override
    public Tour generateInitialSol(City C){
        ArrayList<ArrayList<Integer>> mst = new ArrayList<ArrayList<Integer>>();
        mst_prim(mst,C);
        List<Punt> lp = C.getPunts();
        Tour T = new Tour();
        return T;
    }
    
    private static ArrayList<ArrayList<Integer>> mst_prim(ArrayList<ArrayList<Integer>> mst, City C) {
        ArrayList<Punt> lp = C.getPunts();
        ArrayList<ArrayList<Integer>> lli = C.getAdjacency();
        List<Relation> lr = new ArrayList<Relation>();
        PQsort sort = new PQsort();
        PriorityQueue<Relation> pqr = new PriorityQueue(1,sort);
        boolean[] visited = new boolean[lp.size()];
        int nextdot = 0;
        for(int i = 0; i < lp.size(); ++i) {
            if (lp.get(nextdot).isEnabled()) {
                addPQ(pqr,lli.get(nextdot),lp,i);
                if (!allvisited(visited)){
                    addmst(pqr,visited,mst);
                }
            }
        }
        return mst;
    }
    
    private static void addPQ(PriorityQueue<Relation> pqr,ArrayList<Integer> li,ArrayList<Punt> lp, int pos) {
        for(int i = 0; i < li.size(); ++i) {
            if (i != pos && lp.get(i).isEnabled()) {  //si la adjacencia no es amb si mateix, i el put és habilitat
                   pqr.add(new Relation(pos,i,li.get(i)));
            }
        }
    }
    
    private static void addmst(PriorityQueue<Relation> pqr, boolean [] visited, ArrayList<ArrayList<Integer>> mst) {
        boolean done = false;
        while (!done && pqr.size() > 0){ 
            Relation R = pqr.poll();
            if (!visited[R.getID1()] || !visited[R.getID2()]) {
                mst.get(R.getID1()).add(R.getValue());
                mst.get(R.getID2()).add(R.getValue());
                visited[R.getID1()] = true;
                visited[R.getID2()] = true;
            }
        }
    }

    private static boolean allvisited(boolean[] visited) {
        boolean v = true;
        for(int i = 0; i < visited.length && v; i++) {     //salimos si llegamos al final o vemos que no se ha visitado alguno.
            if (!visited[i]) v = visited[i];       //si no esta visitado, v toma el valor y por tanto se sale del loop.
         }
        return v; // si se ha salido del loop será  falso, si se ha recorrido entero y el último no era, será true.
    }
}

    
    
    /*
    public static int[][] mst_prim(int[][] M, boolean[] visited,int vertex,int[][] finalM) {
        if (M.length > 0) {
            int aux = -1;
            visited[vertex] = true;
            if (!allvisited(visited, M.length)) {
                for (int i = 0; i < visited.length; ++i) {
                    if (visited[i]) {
                        for(int j = 0; j < M.length; ++j) {
                            if(M[i][j] != 0) {
                                if (!visited[j]) {
                                    if (aux == -1) {
                                        aux = M[i][j];
                                    }
                                    else {
                                        aux = Math.min(aux, M[i][j]);
                                    }
                                }
                            }
                        }
                    }
                }
                for(int i = 0; i < visited.length; ++i) {
                    if (visited[i]) {
                        for(int j = 0; j < M.length; ++j) {
                            if (M[i][j] == aux) {
                                if(!visited[j]) {
                                    finalM[i][j] = finalM[j][i] = aux;
                                    return mst_prim(M,visited,j,finalM);
                                }
                            }
                        }
                    }
                }
            }
        }
        
            return finalM;
    }
    * */


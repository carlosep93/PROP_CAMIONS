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
public class Prim extends InitialSolGenerator_TwoApp {

    @Override
    public Tour generateInitialSol(City C){
        List<List<Integer>> mst = new ArrayList<List<Integer>>();
        List<Punt> lp = C.getPunts();
        List<Integer> aux = new ArrayList<Integer>();
        System.out.println("empiezo a rellenar la puta matriz " + C.size());
        for(int i = 0;i < C.size();++i) {
        List<Integer> row = new ArrayList<Integer>();
        mst.add(row);
            for(int j = 0; j < C.size();++j) {
                mst.get(i).add(0);
            }
        }
        ArrayList<ArrayList<Integer>> mat = C.getAdjacency();
        for(int i = 0;i < mst.size();++i) {
            for(int j = 0; j < mst.size();++j) {
                System.out.print(" " + mat.get(i).get(j));
            }
            System.out.println();
        }
        getMST(mst,C);
        //proba de mst
        for(int i = 0;i < mst.size();++i) {
            for(int j = 0; j < mst.size();++j) {
                System.out.print(" "+mst.get(i).get(j));
            }
            System.out.println();
        }
        ArrayList<Integer> path= new ArrayList();
        getEpath(mst,path,0);
        Tour T = new Tour();
        return T;
    }
    
    private static void getMST(List<List<Integer>> mst, City C) {
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
    }
    
    private static void addPQ(PriorityQueue<Relation> pqr,ArrayList<Integer> li,ArrayList<Punt> lp, int pos) {
        for(int i = 0; i < li.size(); ++i) {
            if (i != pos && lp.get(i).isEnabled()) {  //si la adjacencia no es amb si mateix, i el put és habilitat
                   pqr.add(new Relation(pos,i,li.get(i)));
            }
        }
    }
    
    private static void addmst(PriorityQueue<Relation> pqr, boolean [] visited, List<List<Integer>> mst) {
        boolean done = false;
        while (!done && pqr.size() > 0){ 
            Relation R = pqr.poll();
            System.out.println(R.getID1() + " " + R.getID2() + " " + R.getValue());
            System.out.println("AQUI!");
            if (/*!visited[R.getID1()] || */!visited[R.getID2()]) {
                mst.get(R.getID1()).remove(R.getID2());
                System.out.println("Aqui coño!!");
                mst.get(R.getID1()).add(R.getID2(),R.getValue());
                System.out.println("nooo aqui!!!");
                mst.get(R.getID2()).set(R.getID1(),R.getValue());
                visited[R.getID1()] = true;
                visited[R.getID2()] = true;
                done = true;
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


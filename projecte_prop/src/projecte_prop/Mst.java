/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

/**
 *
 * @author joanbarrosogarrido
 */
public class Mst {

    public static ArrayList<ArrayList<Integer>> prim(City C) {
        ArrayList<ArrayList<Integer>> mst = new ArrayList<ArrayList<Integer>>();
        List<Punt> lp = C.getPunts();
        List<List<Integer>> llr = C.getAdjacency();
        mst = mst_prim(mst,C);
        return mst;
        
        /*
        boolean[] visited = new boolean[M.length];
        int vertex = 0;
        int[][] finalM = new int[M.length][M.length];
        finalM = mst_prim(M,visited,vertex,finalM);
        return finalM;
    */
    }
    
    private static ArrayList<ArrayList<Integer>> mst_prim(ArrayList<ArrayList<Integer>> mst, City C) {
        List<Punt> lp = C.getPunts();
        List<List<Integer>> llr = C.getAdjacency();
        List<Relation> lr = new ArrayList<Relation>();
        Comparator<Relation> comparator = new RelationComparator();
        Queue<Relation> pqr = new PriorityQueue(0,Comparator);
        
        return mst;
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
    private static boolean allvisited(boolean[] visited, int length) {
        boolean v = true;
        for(int i = 0; i < length && v; i++) {     //salimos si llegamos al final o vemos que no se ha visitado alguno.
            if (!visited[i]) v = visited[i];       //si no esta visitado, v toma el valor y por tanto se sale del loop.
         }
        return v; // si se ha salido del loop será  falso, si se ha recorrido entero y el último no era, será true.
    }
}
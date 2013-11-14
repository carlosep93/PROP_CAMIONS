/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;

/**
 *
 * @author joanbarrosogarrido
 */
public class Mst {

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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package camio;
/**
 *
 * @author joanbarrosogarrido
 */
public class mst {
    
    
    
    public int[][] AlgPrim(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int vertex = 0;
        int[][] finalM = new int[M.length][M.length];
        finalM = mst_prim(M,visited,vertex,finalM);
        return finalM;
    }
    
    private int[][] mst_prim(int[][] M, boolean[] visited,int vertex,int[][] finalM) {
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
                                finalM[i][j] = aux;
                                finalM[j][j] = aux;
                                return mst_prim(M,visited,j,finalM);
                            }
                        }
                    }
                }
            }
        }
        return finalM;
    }
    
    private boolean allvisited(boolean[] visited, int length) {
        boolean v = true;
        for(int i = 0; i < length && v; i++) {     //salimos si llegamos al final o vemos que no se ha visitado alguno.
            if (!visited[i]) v = visited[i];       //si no esta visitado, v toma el valor y por tanto se sale del loop.
         }
        return v; // si se ha salido del loop será  falso, si se ha recorrido entero y el último no era, será true.
    }
    


public void main() {
    int[][] M = new int[4][4];
    for (int i = 0; i < M.length; ++i) {
        for(int j = 0; j < M.length; ++j) {
             if (i != j) M[i][j] = i+j;  
        }
    }
    M = AlgPrim(M);
    for (int i = 0; i < M.length; ++i) {
        for(int j = 0; j < M.length; ++j) {
             System.out.print(M[i][j] +" " );  
        }
        System.out.println();
    }
    
}
}

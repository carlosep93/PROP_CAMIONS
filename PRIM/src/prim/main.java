/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prim;

/**
 *
 * @author joanbarrosogarrido
 */
public class main {
     
    public static void main(String[] args) {
        int[][] M = new int[4][4];
        for (int i = 0; i < M.length; ++i) {
            for(int j = 0; j < M.length; ++j) {
                 if (i != j) M[i][j] = i+j;  
            }
        }
        int[][] F = AlgPrim(M);
        for (int i = 0; i < M.length; ++i) {
            for(int j = 0; j < M.length; ++j) {
                 System.out.print(F[i][j] + " " );  
            }
            System.out.println();
        }

    }
}

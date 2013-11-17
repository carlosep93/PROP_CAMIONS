/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;

/**
 *
 * @author Pol
 */

import java.util.Scanner;
import projecte_prop.Mst;
import projecte_prop.Mst.*;




public class DriverClass_Mst {
    
    
    
    public static int[][] omple_matriu(int mid){
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int[][] M = new int[mid][mid];
        for (int i = 0; i < M.length; ++i) {
            for(int j = i+1; j < M.length; ++j) {
                System.out.println(" Quina valor vols a la posició [" +i+"]["+j+"]");
                 int val = sc.nextInt();
                 if (i != j) M[i][j] = M[j][i] = val;
            }
        }
        return M;
        
        
    }
    
    public static int[][] omple_matriu_rand(int x){
         int[][] M = new int[x][x];
        for (int i = 0; i < M.length; ++i) {
            for(int j = i+1; j < M.length; ++j) {
                 if (i != j) M[i][j] = M[j][i] = (int)(Math.random() *100);
            }
        }
        return M;
    }
    
    public static void print_matrix(int[][] mat){
         for (int i = 0; i < mat.length; ++i) {
            for(int j = 0; j < mat.length; ++j) {
                 System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
    public static void main(String []args) {
      Scanner sc = new Scanner(System.in);
          boolean Sistema_definit = false;
          int lectura = 0;
          boolean first = false;
          
          
          int[][] matrix = new int[0][0];
          int[][] mst = new int[0][0];
        
          while (lectura !=3){  
          
        System.out.println();
        System.out.println("-------  Informació  -------");
        System.out.println();
        System.out.println("La matriu és: ");
        print_matrix(matrix);
         System.out.println();
        System.out.println("L'arbre d'expanció mínima és: ");
        print_matrix(mst);
         System.out.println();
        System.out.println("Tria una opció: ");
        System.out.println("1- Crar matriu Inicial");
        System.out.println("2- Calcular mst");
        System.out.println("3- Sortir");
        lectura = sc.nextInt();
    
        if(!first && lectura == 2){
             System.out.println ("Primer s'ha de crear la matriu inicial!");
             System.out.println();
             lectura = 1;
        }
         
        if(lectura == 1){
         System.out.println("Quina mida vols la matriu?");
         int mida = sc.nextInt();
         System.out.println("Vols omplir la matriu random(1) o per teclat(2)?");
         lectura = sc.nextInt();
         if(lectura == 2) matrix=omple_matriu(mida);
         if (lectura == 1) matrix = omple_matriu_rand(mida);
         System.out.println("Nova matriu omplerta :)");
         first = true;
          }
         else if(lectura == 2){
         mst = Mst.prim(matrix);
         System.out.println("l'arbre MST està creat :)"); 
         }   
    
        }
    
    }
}

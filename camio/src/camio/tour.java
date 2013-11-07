
package camio;

public class tour {
    public static boolean containsCity(int tour[], int punt){
        boolean conte = false;
        int npunts = tour.length;
        for(int i = 0; i < npunts && !conte; ++i){
            if(tour[i]==punt) conte = true;
        }
        return conte;
    }
    
    
    public static void entraCiu(int origen, int desti, int[][] con){
        for(int i = 0; i < 4; ++i){
            if(con[origen][i] == -1){
                con[origen][i] = desti;
            }
        }
    }
    
    public static int posCiuX(int ciu, int[] vector){
        int i = 0;
        while(i < vector.length){
            if(vector[i] == ciu) break;
            ++i;
        }
        return i;
    }
}

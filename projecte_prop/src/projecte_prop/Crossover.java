
package projecte_prop;

public class Crossover {
    static private int npunts;
    
    public static int[] crossover(int[] parent1, int[] parent2){
        npunts = parent1.length;
        int child[] = new int[npunts];
        
        int startPos = (int)(Math.random() * npunts);
        int endPos = (int)(Math.random() * npunts);
        
        for(int i = 0; i < npunts; ++i){
            child[i]=-1;
            if(startPos < endPos && i > startPos && i < endPos){
                child[i] = parent1[i];
            }
            else if(startPos > endPos){
                if(!(i < startPos && i > endPos)){
                    child[i] = parent1[i];
                }
            }
        }
        for(int i = 0; i < npunts; ++i){
            if(!tour.containsCity(child, i)){
                for(int ii = 0; ii < npunts; ++ii){
                    if(child[ii] == -1){
                        child[ii] = i;
                        break;
                    }
                }
            }
        }
        
        return child;
    }  
    
    public static int[] crossover_edgeRecombination(int[] parent1, int[] parent2){
        npunts = parent1.length;
        int child[] = new int[npunts];        
        int ciutatActual = (int)(Math.random() * npunts);
        int con1[][] = new int [npunts][4];
        int con2[][] = new int [npunts][4];
        
        inicialitzaCon(con1, con2, parent1, parent2);
        
        System.out.println("Primer adjacent: ");
        for(int i = 0; i < npunts; ++i){
            for(int ii = 0; ii < 4; ++ii){
                System.out.print(" " + con1[i][ii]);
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.println("Segón adjacent: ");
        for(int i = 0; i < npunts; ++i){
            for(int ii = 0; ii < 4; ++ii){
                System.out.print(" " + con1[i][ii]);
            }
            System.out.println();
        }
        
        for(int i = 0; i < npunts; ++i){
            
        }
        
        
        
        return child;
    }
    
    private static void inicialitzaCon(int[][] con1, int[][] con2, int[] parent1, int[] parent2){       
        
        for(int i = 0; i < npunts; ++i){
            
            //inicilitza els vectors con1, con2
            for(int ii = 0; ii < 4; ++ii){
                con1[i][ii] = con2[i][ii] = -1;
            }
            
            
            int pos = tour.posCiuX(i, parent1);
            if(pos == 0){
                tour.entraCiu(parent1[pos], parent1[pos+1], con1);
                tour.entraCiu(parent1[pos], parent1[npunts-1], con1);
            }
            else if(pos == npunts-1){
                tour.entraCiu(parent1[pos], parent1[pos-1], con1);
                tour.entraCiu(parent1[pos], parent1[0], con1);
            }
            else{
                tour.entraCiu(parent1[pos], parent1[pos+1], con1);
                tour.entraCiu(parent1[pos], parent1[pos-1], con1);
            }
            pos = tour.posCiuX(i, parent2);
            if(pos == 0){
                tour.entraCiu(parent2[pos], parent2[pos+1], con2);
                tour.entraCiu(parent2[pos], parent2[npunts-1], con2);
            }
            else if(pos == npunts-1){
                tour.entraCiu(parent2[pos], parent2[pos-1], con2);
                tour.entraCiu(parent2[pos], parent2[0], con2);
            }
            else{
                tour.entraCiu(parent2[pos], parent2[pos+1], con2);
                tour.entraCiu(parent2[pos], parent2[pos-1], con2);
            }
        }
    }
}


package projecte_prop;
/**
 *
 * @author josep
 */


public class Crossover {
    
    static private int npunts;
    
    public static Tour crossover(Tour parent1, Tour parent2){
        Tour child = new Tour();
        npunts = parent1.size();
        Element E = new Element(-1);
        
        int startPos = (int)(Math.random() * npunts);
        int endPos = (int)(Math.random() * npunts);
        
        for(int i = 0; i < npunts; ++i){
            child.addElement(E);
            if(startPos < endPos && i > startPos && i < endPos){
                child.replaceElementPos(parent1.getElementPos(i), i);
            }
            else if(startPos > endPos){
                if(!(i < startPos && i > endPos)){
                    child.replaceElementPos(parent1.getElementPos(i), i);
                }
            }
        }
        for(int i = 0; i < npunts; ++i){
            if(!child.containsElement(parent2.getElementPos(i).getID())){
                for(int ii = 0; ii < npunts; ++ii){
                    if(child.getElementPos(ii).getID() == -1){
                        child.replaceElementPos(parent2.getElementPos(i), ii);
                        break;
                    }
                }
            }
        }
        
        return child;
    }  
    
    public static Tour crossover_edgeRecombination(Tour parent1, Tour parent2){
        npunts = parent1.size();
        Tour child = new Tour();        
        int ciutatActual = (int)(Math.random() * npunts);
        int costs1[][] = new int [npunts][4];
        int costs2[][] = new int [npunts][4];
        
        startCosts(costs1, costs2, parent1, parent2);
        
        System.out.println("Primer adjacent: ");
        for(int i = 0; i < npunts; ++i){
            for(int ii = 0; ii < 4; ++ii){
                System.out.print(" " + costs1[i][ii]);
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.println("Segón adjacent: ");
        for(int i = 0; i < npunts; ++i){
            for(int ii = 0; ii < 4; ++ii){
                System.out.print(" " + costs2[i][ii]);
            }
            System.out.println();
        }
        
        for(int i = 0; i < npunts; ++i){
            //eliminar el current points dels costs
            //current point passa a ser el mes curt d'anar des del current point anterir
        }
        return child;
    }
    
    private static void startCosts(int[][] costs1, int[][] costs2, Tour parent1, Tour parent2){       
        /*
        Element E;
        for(int i = 0; i < npunts; ++i){
            
            //inicilitza els vectors con1, con2
            for(int ii = 0; ii < 4; ++ii){
                costs1[i][ii] = costs2[i][ii] = -1;
            }
            
            E = new Element(i, true);
            int pos = parent1.getPosElement(E);
            if(pos == 0){
                entraCiu(parent1.getElementPos(pos).getID(), parent1[pos+1], con1);
                entraCiu(parent1[pos], parent1[npunts-1], con1);
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
        }*/
    }
    
   /* public static void entraCiu(int origen, int desti, int[][] con){
        for(int i = 0; i < 4; ++i){
            if(con[origen][i] == -1){
                con[origen][i] = desti;
            }
        }
    }*/
}

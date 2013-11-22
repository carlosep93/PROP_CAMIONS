
package projecte_prop;
/**
 *
 * @author josep
 */

import java.util.List;
import java.util.ArrayList;

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
    
    public static Tour crossover_edgeRecombination(Ciutat C, Tour parent1, Tour parent2){
        npunts = parent1.size();
        Tour child = new Tour();        
        int ciutatActual = (int)(Math.random() * npunts);
        Element E = new Element(ciutatActual);
        
        ArrayList<ArrayList<Integer>> costs = startCosts(C, parent1, parent2);
        boolean[] visitat = new boolean[npunts];
        
        while(true){
            //borra la ciutat actual de les altres ocurrencies
            for(int ii = 0; ii < npunts; ++ii){
                for(int iii = 0; iii < costs.get(ii).size(); ++iii){
                    if(costs.get(ii).get(iii) == ciutatActual){
                        costs.get(ii).remove(iii);
                    }
                }
            }
            /*
            System.out.println("imprimeixo l'estat dels costos;;; l'element actual " + ciutatActual);
            for(int x = 0; x < npunts; ++x){
                for(int y = 0; y < costs.get(x).size(); ++y){
                    System.out.print(" " + costs.get(x).get(y));
                }
                System.out.println();
            }*/
            
            E = new Element(ciutatActual);
            //System.out.println("element actual: " +  E.getID());
            child.addElement(E);
            visitat[ciutatActual] = true;
            if(!costs.get(ciutatActual).isEmpty()) ciutatActual = costs.get(ciutatActual).get(0);
            else{
                boolean algun = false;
                for(int i = 0; i < npunts; ++i) if(!visitat[i]){ ciutatActual = i; algun = true; }
                if(!algun) break;
            }
            
            //current point passa a ser el mes curt d'anar des del current point anterir
        }        
        return child;
    }
    
    private static ArrayList<ArrayList<Integer>> startCosts(Ciutat C, Tour parent1, Tour parent2){
        
        ArrayList<ArrayList<Integer>> costs = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> aux = new ArrayList<Integer>();
    
        for(int i = 0; i < npunts; ++i){
            costs.add(i, new ArrayList());
            
            //s'afegeixes les adjacencies del pare 1
            int posActual = parent1.getPosElement(i);
            int idAnt, idSeg;
            if(posActual == 0) idAnt = parent1.getElementPos(npunts-1).getID();
            else idAnt = parent1.getElementPos(posActual-1).getID();            
            costs.get(i).add(idAnt);
            
            if(posActual == npunts-1) idSeg = parent1.getElementPos(0).getID();
            else idSeg = parent1.getElementPos(posActual+1).getID();
            entraCiu(C, i, idSeg, costs);
            
            
            //s'afegeixen les adjacencies del pare 2
            posActual = parent2.getPosElement(i);
            if(posActual == 0) idAnt = parent2.getElementPos(npunts-1).getID();
            else idAnt = parent2.getElementPos(posActual-1).getID();
            entraCiu(C, i, idAnt, costs);
            
            
            if(posActual == npunts-1) idSeg = parent2.getElementPos(0).getID();
            else idSeg = parent2.getElementPos(posActual+1).getID();
            entraCiu(C, i, idSeg, costs);
            
        }
        return costs;
    }
    
    public static void entraCiu(Ciutat C, int origen, int desti, ArrayList<ArrayList<Integer>> con){
        boolean introduit = con.get(origen).contains(desti);
        for(int i = 0; i < 4 && !introduit; ++i){
            if(i == con.get(origen).size() || C.get_Relations().getCost(origen, con.get(origen).get(i)) 
                    > C.get_Relations().getCost(origen, desti)){
                con.get(origen).add(i, desti);
                introduit = true;
            }
        }
    }
}


package Domini;

import java.util.ArrayList;

public class Crossover_Edge extends Crossover{
    
    private static int npunts;
    
    private City C;
    
    public Crossover_Edge(City C){
        this.C = C;
    }
    
    @Override public Tour getChild(Tour parent1, Tour parent2){
        npunts = parent1.size();
        Tour child = new Tour();        
        int ciutatActual = (int)(Math.random() * npunts);
        Punt E = new Punt(ciutatActual);
        
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
            
            E = new Punt(ciutatActual);
            child.addElement(E);
            visitat[ciutatActual] = true;
            if(!costs.get(ciutatActual).isEmpty()) ciutatActual = costs.get(ciutatActual).get(0);
            else{
                boolean algun = false;
                for(int i = 0; i < npunts; ++i) if(!visitat[i]){ ciutatActual = i; algun = true; }
                if(!algun) break;
            }
            
        }        
        return child;
    }
    
    private static ArrayList<ArrayList<Integer>> startCosts(City C, Tour parent1, Tour parent2){
        
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
    
    public static void entraCiu(City C, int origen, int desti, ArrayList<ArrayList<Integer>> con){
        boolean introduit = con.get(origen).contains(desti);
        
        for(int i = 0; i < 4 && !introduit; ++i){
            if(i == con.get(origen).size() || C.getAdjacency().get(origen).get(con.get(origen).get(i)) 
                    > C.getAdjacency().get(origen).get(desti)){
                con.get(origen).add(i, desti);
                introduit = true;
            }
        }
    }
}

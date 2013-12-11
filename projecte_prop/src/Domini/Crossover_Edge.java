
package Domini;

import java.util.ArrayList;

public class Crossover_Edge extends Crossover{
    
    private static int npunts;
    private City C;
    private Tour parent1, parent2;
    
    public Crossover_Edge(City C){
        this.C = C;
    }
    
    @Override public Tour getChild(Tour parent1, Tour parent2){
        this.parent1 = parent1;
        this.parent2 = parent2;
        npunts = parent1.size();
        Tour child = new Tour();
        Punt p;
        if(npunts != 0){
            int idAct = parent1.getElementPos(0).getID();
            p = new Punt(idAct);
            child.addElement(p);
            Integer[] adj = new Integer[4];
            
           /* System.out.println("pare1: pes: " + parent1.getCost(C));
            for(int i = 0; i < parent1.size(); ++i){
                System.out.print(parent1.getElementPos(i).getID() + " ");
            }
            System.out.println();
            
            System.out.println("pare2: pes:" + parent2.getCost(C));
            for(int i = 0; i < parent2.size(); ++i){
                System.out.print(parent2.getElementPos(i).getID() + " ");
            }
            System.out.println();*/
            
            boolean[] vis = new boolean[parent1.size()];
            vis[parent1.getPosElement(idAct)] = true;
            for(int i = 1; i < npunts; ++i){
                adj = omplaAdj(idAct);
                boolean aux = false;
                for(int ii = 0; ii < 4; ++ii)
                    if(!vis[parent1.getPosElement(adj[ii])]){
                        p = new Punt(adj[ii]);
                        child.addElement(p);
                        idAct = adj[ii];
                        aux = true;
                        vis[parent1.getPosElement(idAct)] = true;
                        break;
                    }
                if(!aux){
                    for(int ii = 0; ii < parent1.size(); ++ii){
                        if(!vis[ii]){
                            p = new Punt(parent1.getElementPos(ii).getID());
                            child.addElement(p);
                            idAct = parent1.getElementPos(ii).getID();
                            vis[ii] = true;
                            break;
                        }
                    }
                }
            }
            /*System.out.println("child: Pes: " + child.getCost(C));
            for(int i = 0; i < child.size(); ++i){
                System.out.print(child.getElementPos(i).getID() + " ");
            }
            System.out.println();
            System.out.println();*/
        }
        
        return child;
    }
    
    private Integer[] omplaAdj(int idAct){
        Integer[] adj = new Integer[4];
        int punt = 0;
        int id, posParent2;
        //System.out.println("IDACT: "+idAct+"    npunts "+npunts);
        for(int i = 0; i < npunts && punt < 4; ++i){
            if(parent1.getElementPos(i).getID() == idAct){
                if(i == 0) adj[punt] = parent1.getElementPos(parent1.size()-1).getID();
                else adj[punt] = parent1.getElementPos(i-1).getID();
                ++punt;
    
                if(i == parent1.size()-1) adj[punt] = parent1.getElementPos(0).getID();
                else adj[punt] = parent1.getElementPos(i+1).getID();
                ++punt;
            }
            id = parent1.getElementPos(i).getID();
            posParent2 = parent2.getPosElement(id);
            //System.out.println("idAct:" + idAct + " i:"+i+" id:"+id+ " pos2:"+posParent2);
            if(parent2.getElementPos(posParent2).getID() == idAct){
                if(posParent2 == 0) adj[punt] = parent2.getElementPos(parent2.size()-1).getID();
                else adj[punt] = parent2.getElementPos(posParent2-1).getID();
                ++punt;
                
                if(posParent2 == parent2.size()-1) adj[punt] = parent2.getElementPos(0).getID();
                else adj[punt] = parent2.getElementPos(posParent2+1).getID();
                ++punt;
            }
        }
        
        /*System.out.println("printo el vector sense ordenar( size " +  adj.length);
        for(int i = 0; i < 4; ++i){
            System.out.print(adj[i] + " ");
        }
        System.out.println();*/
        
        
        int pos = 0;
        for (int a = 0; a < 4 ; ++a){
            pos = a;
            for(int ii = a; ii < 4 ;++ii){
                //System.out.println("idACt = " + idAct + "   adj[ii] = " + adj[ii]);
                if(C.getAdjacency().get(idAct).get(adj[ii]) < 
                        C.getAdjacency().get(idAct).get(adj[pos])) 
                    pos = ii;
                
                //System.out.println("idAct: " + idAct + "    adj[ii]: " + adj[ii] + "      PES: " +C.getAdjacency().get(idAct).get(adj[ii]));
            }
            int aux = adj[pos];
            adj[pos] = adj[a];
            adj[a] =  aux;
        }
        
        /*System.out.println("printo el vector");
        for(int i = 0; i < 4; ++i){
            System.out.print(adj[i] + " ");
        }
        System.out.println();
        System.out.println();*/
        return adj;
    }
        /*npunts = parent1.size();
        Tour child = new Tour();        
        int ciutatActual = parent1.getElementPos(0).getID();
        Punt E = new Punt(ciutatActual);
        
       /* System.out.println("imprimeio els pares:");
        for(int i = 0; i < parent1.size(); ++i){
            System.out.print(parent1.getElementPos(i).getID() + " ");
        }
        System.out.println();
        for(int i = 0; i < parent2.size(); ++i){
            System.out.print(parent2.getElementPos(i).getID() + " ");
        }
        System.out.println();
        
        ArrayList<ArrayList<Integer>> costs = startCosts(C, parent1, parent2);
        boolean[] visitat = new boolean[C.size()];
        
        /*System.out.println("printo els costs");
        for(int i = 0; i < costs.size(); ++i){
            for(int ii = 0; ii < costs.get(i).size(); ++ii){
                System.out.print(costs.get(i).get(ii) +"/" + C.getAdjacency().get(parent1.getElementPos(i).getID()).get(costs.get(i).get(ii)) + "   ");
            }
            System.out.println();
        }
        
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
            if(!costs.get(parent1.getPosElement(ciutatActual)).isEmpty()){
                ciutatActual = costs.get(parent1.getPosElement(ciutatActual)).get(0);
            }
            else{
                boolean algun = false;
                int pos;
                for(int i = 0; i < npunts; ++i){
                    pos = parent1.getElementPos(i).getID();
                    if(!visitat[pos]){ ciutatActual = pos; algun = true; }
                }
                if(!algun) break;
            }
            
        }
        /*System.out.println("CHILD::::");
        for(int i = 0; i < child.size(); ++i){
            System.out.print(child.getElementPos(i).getID() + " ");
        }
        System.out.println();
        return child;
    }
    
    private static ArrayList<ArrayList<Integer>> startCosts(City C, Tour parent1, Tour parent2){
        
        ArrayList<ArrayList<Integer>> costs = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> aux = new ArrayList<Integer>();
        for(int i = 0; i < npunts; ++i){
            costs.add(i, new ArrayList());
        }
    
        for(int i = 0; i < C.getPunts().size(); ++i){
            
            //s'afegeixes les adjacencies del pare 1
            int posActual = parent1.getPosElement(i);
            if(posActual != -1){
                //System.out.println("pos actual = " +  posActual);
                int idAnt, idSeg;
                if(posActual == 0) idAnt = parent1.getElementPos(npunts-1).getID();
                else idAnt = parent1.getElementPos(posActual-1).getID();            
                costs.get(posActual).add(idAnt);

                if(posActual == npunts-1) idSeg = parent1.getElementPos(0).getID();
                else idSeg = parent1.getElementPos(posActual+1).getID();
                entraCiu(C, posActual, idSeg, costs, parent1);


                //s'afegeixen les adjacencies del pare 2
                posActual = parent2.getPosElement(i);
                if(posActual == 0) idAnt = parent2.getElementPos(npunts-1).getID();
                else idAnt = parent2.getElementPos(posActual-1).getID();
                entraCiu(C, posActual, idAnt, costs, parent1);

                if(posActual == npunts-1) idSeg = parent2.getElementPos(0).getID();
                else idSeg = parent2.getElementPos(posActual+1).getID();
                entraCiu(C, posActual, idSeg, costs, parent1);
            }
            
        }
        return costs;
    }
    
    public static void entraCiu(City C, int origen, int desti, ArrayList<ArrayList<Integer>> con, Tour parent1){
        boolean introduit = con.get(origen).contains(desti);
        
        for(int i = 0; i < 4 && !introduit; ++i){
            //System.out.println("")
            
            if(i == con.get(origen).size() || C.getAdjacency().get(origen).get(con.get(origen).get(i)) 
                    > C.getAdjacency().get(origen).get(parent1.getPosElement(desti))){
                con.get(origen).add(i, desti);
                introduit = true;
            }
        }
    }*/
}

package Domini;


public class Crossover_Edge extends Crossover{
    
    private static int npunts;
    private City C;
    private Tour parent1, parent2;
    
    public Crossover_Edge(){}
    
    @Override public Tour getChild(City C, Tour parent1, Tour parent2){
        this.C = C;
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

        int pos = 0;
        for (int a = 0; a < 4 ; ++a){
            pos = a;
            for(int ii = a; ii < 4 ;++ii){
                if(C.getAdjacency().get(idAct).get(adj[ii]) < 
                        C.getAdjacency().get(idAct).get(adj[pos])) 
                    pos = ii;
            }
            int aux = adj[pos];
            adj[pos] = adj[a];
            adj[a] =  aux;
        }
        return adj;
    }
}
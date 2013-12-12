
package Domini;

public class Crossover_Simple extends Crossover{
    
    public Crossover_Simple(){}
    
    @Override public Tour getChild(City C, Tour parent1, Tour parent2){
        Tour child = new Tour();
        int npunts = parent1.size();
        Punt E = new Punt(-1);
        
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
}

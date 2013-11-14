
package projecte_prop;

/**
 *
 * @author josep
 */

import java.util.List;
import java.util.ArrayList;

public class Tour {
    private int nElements, cost;
    List<Element> cjtElem;
    
    //constructora del conjunt d'element parcial
    public Tour(){
        cjtElem = new ArrayList<Element>();
        nElements = 0;
        cost = 0;
    }
    
    //inserta l'element E al final de la llista cjtElem retorna si s'ha inserit be
    public boolean addElement(Element E, Ciutat C){
        if(!cjtElem.contains(E) && cjtElem.add(E)){
            ++nElements;
            if(nElements == 2){
                cost += 2 * C.get_Relations().getCost(E, getElementPos(0));
            }
            else if(nElements > 2){
                cost -= C.get_Relations().getCost(getElementPos(0), getElementPos(nElements-2));
                cost += C.get_Relations().getCost(getElementPos(0), E);
                cost += C.get_Relations().getCost(E, getElementPos(nElements-2));
            }
            return true;
        }
        return false;
    }
    
    //inserta l'element E a la posició pos de la llista Ruta
    public boolean addElement(Element E, int pos, Ciutat C){
        if((pos >= 0 && pos <= nElements) || !cjtElem.contains(E)){
            cjtElem.add(pos, E);
            ++nElements;
            if(pos == 0){
                cost -= C.get_Relations().getCost(getElementPos(1), getElementPos(nElements-1));
                cost += C.get_Relations().getCost(getElementPos(nElements-1), getElementPos(pos));
                cost += C.get_Relations().getCost(getElementPos(pos), getElementPos(pos+1));
            }
            else if(pos == nElements-1){
                cost -= C.get_Relations().getCost(getElementPos(0), getElementPos(nElements-2));
                cost += C.get_Relations().getCost(getElementPos(pos-1), getElementPos(pos));
                cost += C.get_Relations().getCost(getElementPos(0), getElementPos(pos));
            }
            else{
                cost -= C.get_Relations().getCost(getElementPos(0), getElementPos(nElements-1));
                cost += C.get_Relations().getCost(getElementPos(pos-1), getElementPos(pos));
                cost += C.get_Relations().getCost(getElementPos(pos), getElementPos(pos+1));
            }
            return true;
        }
        return false;
    }
    
    //reemplaça l'element E per l'element E2 retorna si l'operació s'ha fet correctament
    public boolean replaceElement(Element E, Element E2, Ciutat C){
        int pos = getPosElement(E);
        if(!containsElement(E) && containsElement(E2) && removeElement(E2, C) && addElement(E, pos, C)) return true;
        return false;
    }
    
    //reemplaça l'element de la posició pos per l'element E retorna si l'operació s'ha fet correctament
    public boolean replaceElement(Element E, int pos, Ciutat C){
        if(!containsElement(E) && pos >= 0 && pos < nElements && removeElement(pos, C) && addElement(E, pos, C)) return true;
        return false;
    }
    
    //retorna si l'element "e" està contingut dins el Tour
    public boolean containsElement(Element E){
        return cjtElem.contains(E);
    }
    
    //elimina la ocurrencia d'E al cjtElem retorna si s'ha esborrat correctamen
    public boolean removeElement(Element E, Ciutat C){
        if(cjtElem.contains(E)){
            if(getPosElement(E) == 0){
                cost -= C.get_Relations().getCost(getElementPos(nElements-1), E);
                cost -= C.get_Relations().getCost(E, getElementPos(1));
                cost += C.get_Relations().getCost(getElementPos(nElements-1), getElementPos(1));
            }
            else if(getPosElement(E) == nElements-1){
                cost -= C.get_Relations().getCost(getElementPos(nElements-2), E);
                cost -= C.get_Relations().getCost(E, getElementPos(0));
                cost += C.get_Relations().getCost(getElementPos(nElements-2), getElementPos(0));
            }
            else{
                cost -= C.get_Relations().getCost(getElementPos(getPosElement(E)-1), E);
                cost -= C.get_Relations().getCost(E, getElementPos(getPosElement(E)+1));
                cost += C.get_Relations().getCost(getElementPos(getPosElement(E)-1), getElementPos(getPosElement(E)+1));
                
            }
            cjtElem.remove(E);
            --nElements;
            return true;
        }
        return false;
    }
    
    //elimina de la Ruta l'element de la posició pos returna si s'ha borrat correctament
    public boolean removeElement(int pos, Ciutat C){
        if(pos < nElements && pos >= 0){
            if(pos == 0){
                cost -= C.get_Relations().getCost(getElementPos(nElements-1), getElementPos(0));
                cost -= C.get_Relations().getCost(getElementPos(0), getElementPos(1));
                cost += C.get_Relations().getCost(getElementPos(nElements-1), getElementPos(1));
            }
            else if(pos == nElements-1){
                cost -= C.get_Relations().getCost(getElementPos(nElements-2), getElementPos(nElements-1));
                cost -= C.get_Relations().getCost(getElementPos(nElements-1), getElementPos(0));
                cost += C.get_Relations().getCost(getElementPos(nElements-2), getElementPos(0));
            }
            else{
                cost -= C.get_Relations().getCost(getElementPos(pos-1), getElementPos(pos));
                cost -= C.get_Relations().getCost(getElementPos(pos), getElementPos(pos+1));
                cost += C.get_Relations().getCost(getElementPos(pos-1), getElementPos(pos+1));
                
            }
            cjtElem.remove(pos);
            --nElements;
            return true;
        }
        return false;
    }
    
    //obtè l'element cjtElem[pos]
    public Element getElementPos(int pos){
        return cjtElem.get(pos);
    }
    
    //retuorna la posició de l'element E al Tour si retorna -1 hi ha hagut error
    public int getPosElement(Element E){
        return cjtElem.indexOf(E);
    }
    
    //fa swap de dos elements, retorna si s'ha fet correctament
    public boolean swap(Element E1, Element E2, Ciutat C){
        if(cjtElem.contains(E1) && cjtElem.contains(E1) && E1 != E2){
            replaceElement(E1,E2, C);
            replaceElement(E2,E1, C);
            return true;
        }
        return false;
    }
    
    //fa un swap de pos1 i pos2, retorna si s'ha fet correctament
    public boolean swap(int pos1, int pos2, Ciutat C){
        if(pos1 >= 0 && pos1 < nElements && pos2 >= 0 && pos2 < nElements && pos1 != pos2){
            replaceElement(getElementPos(pos1), pos2, C);
            replaceElement(getElementPos(pos2), pos1, C);
            return true;
        }
        return false;
    }
    
    //retorna el tamany del tour
    public int size(){
        return nElements;
    }
    
    //retorna el cost de la ruta
    public int getCost(){
        return cost;
    }
}

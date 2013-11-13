
package projecte_prop;

/**
 *
 * @author josep
 */

import java.util.List;
import java.util.ArrayList;
import java.lang.String;

public class CjtElements {
    private int nElements, cost;
    private int id, data;
    private String nom;
    List<Element> cjtElem;
    
    //constructora del conjunt d'element parcial
    public CjtElements(){
        nElements = 0;
        cost = 0;
        id = data = -1;
        nom = null;
    }
    
    //constructora del conjunt d'element total
    public CjtElements(int id, String nom, int data){
        nElements = 0;
        cost = 0;
        this.id = id;
        this.nom = nom;
        this.data = data;
    }
    
    //inserta l'element E al final de la llista cjtElem retorna si s'ha inserit be
    public boolean addElement(Element E){
        if(!cjtElem.contains(E) && cjtElem.add(E)){
            ++nElements;
            if(nElements == 2){
                cost += 2 * Relations.getCost(E, getElementPos(0));
            }
            else if(nElements > 2){
                cost -= Relations.getCost(getElementPos(0), getElementPos(nElements-2));
                cost += Relations.getCost(getElementPos(0), E);
                cost += Relations.getCost(E, getElementPos(nElements-2));
            }
            return true;
        }
        return false;
    }
    
    //inserta l'element E a la posició pos de la llista Ruta
    public boolean addElementPos(Element E, int pos){
        if((pos >= 0 && pos <= nElements) || !cjtElem.contains(E)){
            cjtElem.add(pos, E);
            ++nElements;
            if(pos == 0){
                cost -= Relations.getCost(getElementPos(1), getElementPos(nElements-1));
                cost += Relations.getCost(getElementPos(nElements-1), getElementPos(pos));
                cost += Relations.getCost(getElementPos(pos), getElementPos(pos+1));
            }
            else if(pos == nElements-1){
                cost -= Relations.getCost(getElementPos(0), getElementPos(nElements-2));
                cost += Relations.getCost(getElementPos(pos-1), getElementPos(pos));
                cost += Relations.getCost(getElementPos(0), getElementPos(pos));
            }
            else{
                cost -= Relations.getCost(getElementPos(0), getElementPos(nElements-1));
                cost += Relations.getCost(getElementPos(pos-1), getElementPos(pos));
                cost += Relations.getCost(getElementPos(pos), getElementPos(pos+1));
            }
            return true;
        }
        return false;
    }
    
    //retorna si l'element "e" està contingut dins el Tour
    public boolean containsElement(Element E){
        return cjtElem.contains(E);
    }
    
    //retuorna la posició de l'element E al Tour si retorna -1 hi ha hagut error
    public int getPosElement(Element E){
        return cjtElem.indexOf(E);
    }
    
    //elimina la ocurrencia d'E al cjtElem retorna si s'ha esborrat correctamen
    public boolean removeElement(Element E){
        if(cjtElem.contains(E)){
            if(getPosElement(E) == 0){
                cost -= Relations.getCost(getElementPos(nElements-1), E);
                cost -= Relations.getCost(E, getElementPos(1));
                cost += Relations.getCost(getElementPos(nElements-1), getElementPos(1));
            }
            else if(getPosElement(E) == nElements-1){
                cost -= Relations.getCost(getElementPos(nElements-2), E);
                cost -= Relations.getCost(E, getElementPos(0));
                cost += Relations.getCost(getElementPos(nElements-2), getElementPos(0));
            }
            else{
                cost -= Relations.getCost(getElementPos(getPosElement(E)-1), E);
                cost -= Relations.getCost(E, getElementPos(getPosElement(E)+1));
                cost += Relations.getCost(getElementPos(getPosElement(E)-1), getElementPos(getPosElement(E)+1));
                
            }
            cjtElem.remove(E);
            --nElements;
            return true;
        }
        return false;
    }
    
    //elimina de la Ruta l'element de la posició pos returna si s'ha borrat correctament
    public boolean removeElementPos(int pos){
        if(pos < nElements && pos >= 0){
            if(pos == 0){
                cost -= Relations.getCost(getElementPos(nElements-1), getElementPos(0));
                cost -= Relations.getCost(getElementPos(0), getElementPos(1));
                cost += Relations.getCost(getElementPos(nElements-1), getElementPos(1));
            }
            else if(pos == nElements-1){
                cost -= Relations.getCost(getElementPos(nElements-2), getElementPos(nElements-1));
                cost -= Relations.getCost(getElementPos(nElements-1), getElementPos(0));
                cost += Relations.getCost(getElementPos(nElements-2), getElementPos(0));
            }
            else{
                cost -= Relations.getCost(getElementPos(pos-1), getElementPos(pos));
                cost -= Relations.getCost(getElementPos(pos), getElementPos(pos+1));
                cost += Relations.getCost(getElementPos(pos-1), getElementPos(pos+1));
                
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
    
    //fa swap de dos elements, retorna si s'ha fet correctament
    public boolean swapElem(Element E1, Element E2){
        if(cjtElem.contains(E1) && cjtElem.contains(E1) && E1 != E2){
            int pos1, pos2;
            pos1 = getPosElement(E1);
            pos2 = getPosElement(E2);
            
            if(pos1 > pos2){
                int posaux = pos1;
                pos1 = pos2;
                pos2 = posaux;
                Element Eaux = E1;
                E1 = E2;
                E2= Eaux;
            }
            
            removeElement(E2);
            addElementPos(E2, pos1+1);
            removeElement(E1);
            addElementPos(E1, pos2+1);
            return true;
        }
        return false;
    }
    
    //fa un swap de pos1 i pos2, retorna si s'ha fet correctament
    public boolean swapPos(int pos1, int pos2){
        if(pos1 >= 0 && pos1 < nElements && pos2 >= 0 && pos2 < nElements && pos1 != pos2){
            Element E1, E2;
            E1 = getElementPos(pos1);
            E2 = getElementPos(pos2);
            if(pos1 > pos2){
                int posaux = pos1;
                pos1 = pos2;
                pos2 = posaux;
                Element Eaux = E1;
                E1 = E2;
                E2 = Eaux;
            }
            
            removeElement(E2);
            addElementPos(E2, pos1+1);
            removeElement(E1);
            addElementPos(E1, pos2+1);
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
    
    //retorna la id del tour si no te id retorna -1
    public int getId(){
        return id;
    }
    
    //retorna la data del tour si no te data retorna -1
    public int getData(){
        return data;
    }
    
    //retorna el nom del tour si no te nom retorna null
    public String getNom(){
        return nom;
    }
}

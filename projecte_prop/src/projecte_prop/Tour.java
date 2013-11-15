
package projecte_prop;

/**
 *
 * @author josep
 */

import java.util.List;
import java.util.ArrayList;

//import Stubs.Relations;

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
    public void addElement(Element E){
        cjtElem.add(E);
        ++nElements;
    }
    
    //inserta l'element E a la posició pos de la llista Ruta
    public void addElement(Element E, int pos){
        cjtElem.add(pos, E);
        ++nElements;
    }
    
    //elimina la ocurrencia d'E al cjtElem retorna si s'ha esborrat correctamen
    public void removeElement(Element E){
        for(int i = 0; i < nElements; ++i){
            if(cjtElem.get(i).getID() == E.getID()){
                cjtElem.remove(i);
                break;
            }
        }
        --nElements;
    }
    
    //elimina de la Ruta l'element de la posició pos returna si s'ha borrat correctament
    public void removeElement(int pos){
        cjtElem.remove(pos);
        --nElements;
    }
    
    //reemplaça l'element E per l'element E2 retorna si l'operació s'ha fet correctament
    public void replaceElement(Element E, Element E2){
        int pos = getPosElement(E);
        removeElement(E);
        addElement(E2, pos);
    }
    
    //reemplaça l'element de la posició pos per l'element E retorna si l'operació s'ha fet correctament
    public void replaceElement(Element E, int pos){
        removeElement(pos);
        addElement(E, pos);
    }
    
    //retorna si l'element "e" està contingut dins el Tour
    public boolean containsElement(Element E){
        boolean trobat = false;
        for(int i = 0; i < nElements; ++i){
            if(cjtElem.get(i).getID() == E.getID()){
                trobat = true;
                break;
            }
        }
        return trobat;
    }
    
    //obtè l'element cjtElem[pos]
    public Element getElementPos(int pos){
        return cjtElem.get(pos);
    }
    
    //retuorna la posició de l'element E al Tour si retorna -1 hi ha hagut error
    public int getPosElement(Element E){
        int pos = -1;
        for(int i = 0; i < nElements; ++i){
            if(cjtElem.get(i).getID() == E.getID()){
                pos = i;
                break;
            }
        }
        return pos;
    }
    
    //fa swap de dos elements, retorna si s'ha fet correctament
    public void swap(Element E1, Element E2){
        int pos1, pos2;
        pos1 = getPosElement(E1);
        pos2 = getPosElement(E2);
        replaceElement(E1,pos2);
        replaceElement(E2,pos1);
    }
    
    //fa un swap de pos1 i pos2, retorna si s'ha fet correctament
    public void swap(int pos1, int pos2){
        Element E1, E2;
        E1 = getElementPos(pos1);
        E2 = getElementPos(pos2);
        replaceElement(E1, pos2);
        replaceElement(E2, pos1);
    }
    
    //retorna el tamany del tour
    public int size(){
        return nElements;
    }
    
    //pre: nElements >= 2
    //retorna el cost de la ruta
    public int getCost_withRelation(Relations R){
        cost = 0;
        for(int i = 0; i < nElements-1; ++i){
            cost += R.getCost(cjtElem.get(i), cjtElem.get(i+1));
        }
        cost += R.getCost(cjtElem.get(0),cjtElem.get(nElements-1));
        return cost;
    }
    
    
    //JOSEEEEEEP AQUESTA CLASSE NO LI CAMBIS EL NOM NI LI AFAGEIXIS PARAMETRES D ENTRADA
    //QUE LA FAN SERVIR MOLTES ALTRES CLASSES I STUBS
    public int getCost(){
      return cost;  
    }
    
}

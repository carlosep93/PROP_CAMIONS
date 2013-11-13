/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;

/**
 *
 * @author josep
 */

import java.util.List;
import java.util.ArrayList;
import java.lang.String;

public class Tour {
    private int nElements, cost;
    private int id, data;
    private String nom;
    List<Element> cjtElem;
    
    //constructora
    public Tour(){
        nElements = 0;
        cost = 0;
        id = data = -1;
        nom = null;
    }
    
    public Tour(int id, String nom, int data){
        nElements = 0;
        cost = 0;
        this.id = id;
        this.nom = nom;
        this.data = data;
    }
    
    //inserta l'element E al final de la llista Ruta retorna si s'ha inserit be
    public boolean insertaElement(Element E){
        if(!cjtElem.contains(E) && cjtElem.add(E)){
            ++nElements;
            if(nElements == 1){
                cost += 2 * Relations.getCost(E.getID(), getElementPos(0).getID());
            }
            else{
                cost -= Relations.getCost(getElementPos(0).getID(), getElementPos(nElements-2).getID());
                cost += Relations.getCost(E.getID(), getElementPos(0).getID());
                cost += Relations.getCost(E.getID(), getElementPos(nElements-2).getID());
            }
            return true;
        }
        return false;
    }
    
    //inserta l'element E a la posició pos de la llista Ruta
    public boolean insertElementPos(Element E, int pos){
        if((pos >= 0 && pos <= nElements) || !cjtElem.contains(E)){
            cjtElem.add(pos, E);
            ++nElements;
            if(nElements == 1){
                cost += 2 * Relations.getCost(E.getID(), getElementPos(0).getID());
            }
            else{
                cost -= Relations.getCost(getElementPos(0).getID(), getElementPos(nElements-2).getID());
                cost += Relations.getCost(E.getID(), getElementPos(0).getID());
                cost += Relations.getCost(E.getID(), getElementPos(nElements-2).getID());
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
        if(cjtElem.remove(E)){
            if(getPosElement(E) == 0){
                cost -= Relations.getCost(E.getID(), getElementPos(1).getID());
                cost -= Relations.getCost(E.getID(), getElementPos(nElements-1).getID());
                cost += Relations.getCost(getElementPos(1), getElementPos(nElements-1).getID());
            }
            else if(getPosElement(E) == nElements-1){
                cost -= Relations.getCost(E.getID(), getElementPos(0).getID());
                cost -= Relations.getCost(E.getID(), getElementPos(nElements-2).getID());
                cost += Relations.getCost(getElementPos(0), getElementPos(nElements-2).getID());
            }
            else{
                cost -= Relations.getCost(E.getID(), getElementPos(getPosElement(E)-1).getID());
                cost -= Relations.getCost(E.getID(), getElementPos(getPosElement(E)+1).getID());
                cost += Relations.getCost(getElementPos(getPosElement(E)-1).getID(), getElementPos(getPosElement(E)+1).getID());
                
            }
            --nElements;
            return true;
        }
        return false;
    }
    
    //elimina de la Ruta l'element de la posició pos returna si s'ha borrat correctament
    public boolean removeElementPos(int pos){
        if(pos < nElements && pos >= 0){
            cjtElem.remove(pos);
            if(pos == 0){
                cost -= Relations.getCost(getElementPos(pos).getID(), getElementPos(1).getID());
                cost -= Relations.getCost(getElementPos(pos).getID(), getElementPos(nElements-1).getID());
                cost += Relations.getCost(getElementPos(1), getElementPos(nElements-1).getID());
            }
            else if(pos == nElements-1){
                cost -= Relations.getCost(getElementPos(pos).getID(), getElementPos(0).getID());
                cost -= Relations.getCost(getElementPos(pos).getID(), getElementPos(nElements-2).getID());
                cost += Relations.getCost(getElementPos(0), getElementPos(nElements-2).getID());
            }
            else{
                cost -= Relations.getCost(getElementPos(pos).getID(), getElementPos(pos-1).getID());
                cost -= Relations.getCost(getElementPos(pos).getID(), getElementPos(pos+1).getID());
                cost += Relations.getCost(getElementPos(pos-1).getID(), getElementPos(pos+1).getID());
                
            }
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
    public boolean swapElem(Element E, Element E2){
        if(cjtElem.contains(E) && cjtElem.contains(E)){
            int pos1, pos2;
            pos1 = cjtElem.indexOf(E); pos2 = cjtElem.indexOf(E2);  //s'obtè les posicions dels dos elements
            Element Eaux = cjtElem.get(pos1);                       //s'assigna a una variable auxiliar E1
            cjtElem.add(pos1, cjtElem.get(pos2));
            cjtElem.add(pos2, Eaux);
        }
        return false;
    }
    
    //fa un swap de pos1 i pos2, retorna si s'ha fet correctament
    public boolean swapPos(int pos1, int pos2){
        if(pos1 >= 0 && pos1 < nElements && pos2 >= 0 && pos2 < nElements){
            Element Eaux = cjtElem.get(pos1);
            cjtElem.add(pos1, cjtElem.get(pos2));
            cjtElem.add(pos2, Eaux);
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

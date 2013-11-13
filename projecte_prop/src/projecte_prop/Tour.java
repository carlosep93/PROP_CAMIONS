/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;

/**
 *
 * @author josep
 */
public class Tour {
    private int nElements;
    
    //constructora
    public Tour(){
        
    }
    
    //retorna si l'element "e" està contingut dins el Tour
    public boolean containsElement(Element e){
        boolean conte = false;
        for(int i = 0; i < nElements && !conte; ++i){
            if(tour[i]==punt) conte = true;
        }
        return conte;
    }
}
